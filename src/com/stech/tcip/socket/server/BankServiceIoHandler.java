package com.stech.tcip.socket.server;

import java.nio.charset.Charset;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.stech.tcip.bank.util.BankBusiUtil;
import com.stech.tcip.schedule.util.StringUtils;
import com.stech.tcip.sys.services.InvokeTCISService;

public class BankServiceIoHandler implements IoHandler {
    
    private static final Logger log = LogManager.getLogger(BankServiceIoHandler.class);
    
    @Value("${mina.charset}")
    private String CHARSET;

    @Value("${mina.cmdexitself}")
    private String CMD_EXIT_SELF;
    
    @Value("${mina.cmdtest}")
    private String CMD_TEST;
    
    @Value("${mina.dataorgid}")
    private String dataorgid;
    
    // 调用TCIS3.0接口
    @Autowired
    private InvokeTCISService invokeTCISService;

    @Override
    public void exceptionCaught(IoSession session, Throwable e) throws Exception {
        String error = "Exception:" + e.getMessage();
        if ((!session.isClosing()) && StringUtils.isNotNull(error)) {
          session.write(IoBufferTools.create(error));
        }
        log.error("服务器发生异常: " + error);
        closedSession(session);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        IoBuffer ib = (IoBuffer) message;
        String input = ib.getString(Charset.forName(CHARSET).newDecoder());
        log.info("input :[" + input + "]");
        if (isCommand(input, session)) {
            return;
        }
        // 转换输入报文参数
        String reqMsg = BankBusiUtil.transInputNXBankbusi(input,dataorgid);
        log.info("请求报文: " + reqMsg);
        // 调用tcis3.0服务
        String result = invokeTCISService.invokeWS(reqMsg,dataorgid);
        log.info("返回报文: " + result);
        if (session.isClosing() || result == null || result.equals("")) {
        } else {
            // 转换返回报文参数
            result = BankBusiUtil.transOutputNXBankbusi(input,result);
            // 返回报文
            session.write(IoBufferTools.create(result));
        }
        log.info("return:[" + result + "]");
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        closedSession(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        closedSession(session);
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        log.info("===================>创建一个新的连接 session:" +session.getRemoteAddress() +" " + session.getId());
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        closedSession(session);
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
    }

    private void closedSession(IoSession session) {
        log.info("关闭当前sessio: "+ session.getId() +" # " + session.getRemoteAddress());
        CloseFuture closeFuture = session.close(true);
        closeFuture.addListener(new IoFutureListener<IoFuture>() {
            public void operationComplete(IoFuture future) {
                if (future instanceof CloseFuture) {
                    ((CloseFuture) future).setClosed();
                    log.info("sessionClosed CloseFuture setClosed-->," + future.getSession().getId());
                }
            }
        });
    }

    private boolean isCommand(String input, IoSession session) throws Exception {
        if (input.equals(CMD_EXIT_SELF)) {
            session.write(IoBufferTools.create(CMD_EXIT_SELF));
            log.info("return:[" + CMD_EXIT_SELF + "]");
            log.info("收到退出命令,即将退出程序！");
            session.close(true);
            System.exit(0);
            return true;
        } else if (input.equals(CMD_TEST)) {
            String s = "测试专用语句: " + Thread.currentThread().getName();
            session.write(IoBufferTools.create(s));
            log.info("return:[" + s + "]");
            return true;
        } else {
            return false;
        }
    }
    
}
