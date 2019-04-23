package com.stech.tcip.bank.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.stech.tcip.schedule.dao.ScheduleMapper;

/**
 * 银行业务工具类
 * @author "geHanBiao"
 * @version 2019年1月17日
 */
@Component
public class BankBusiUtil {
    
    private static ScheduleMapper scheduleMapper;
    
    @Autowired
    public void setScheduleMapper(ScheduleMapper scheduleMapper) {
        BankBusiUtil.scheduleMapper = scheduleMapper;
    }
    
    /**
     * @description： 转换农商银行批扣输入报文参数
     * @param param
     * @return
     * @author："geHanBiao"
     * @crateDate：2019年1月17日上午9:18:18
     */
    public static String transInputNXBankbusi(String param,String dataorgid){
        JSONObject json = new JSONObject();
        try {
            // 交易码
            String busiCode = param.substring(5,10).trim();
            // 银行代码
            String bankNo = param.substring(10, 12).trim();
            // 镇区代码
            String areCode = param.substring(12, 14).trim();
            // 银行操作员
            String bankOperId = param.substring(14, 24).trim();
            // 网点代码
            String spotNo = param.substring(24, 34).trim();
            // 结果代码
            String reCode = param.substring(34, 38).trim();
            // 流水号
            String flowNo = param.substring(78,98).trim();
            String messageid = "";
            // 批扣请求
            if("20011".equals(busiCode)){
                messageid = "2008";
            }
            // 批扣返回
            if("20021".equals(busiCode)){
                messageid = "2009";
                String fileName = param.substring(98,128).trim();
                String fileSize = param.substring(128,158).trim();
                json.put("fileName", fileName);
                json.put("fileSize", fileSize);
            }
            // 获取应用信息与机构信息
            Map<String,Object> orginfo = scheduleMapper.queryOrgInfoAppForMap(dataorgid);
            json.put("dataorgid", dataorgid);
            json.put("orgcode", orginfo.get("ORGCODE"));
            json.put("bankOperId", bankOperId);
            json.put("spotNo", spotNo);
            json.put("messageid", messageid);
            json.put("bankNo", bankNo);
            json.put("areCode", areCode);
            json.put("reCode", reCode);
            json.put("flowNo", flowNo);
            json.put("appid", orginfo.get("APPID"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toString();
    }
    
    /**
     * @description： 转换农商银行批扣返回报文参数
     * @param param
     * @param retMsg
     * @return
     * @author："geHanBiao"
     * @crateDate：2019年1月17日上午9:18:57
     */
    public static String transOutputNXBankbusi(String input,String retMsg){
        StringBuffer str = new StringBuffer();
        try {
            String busiCode = input.substring(5,10);
            String bankNo = input.substring(10, 12);
            String areCode = input.substring(12, 14);
            String bankOperId = input.substring(14, 24);
            String spotNo = input.substring(24, 34);
            String reCode = input.substring(34, 38);
            String reMsg = input.substring(38, 78);
            JSONObject json = JSONObject.parseObject(retMsg);
            String msg = json.getString("msg");
            if("success".equals(msg)){
                String flowNo = input.substring(78);
                // 补齐msg报文
                msg = BankBusiConstant.ERROR_0000;
                if(msg.getBytes().length < 40){
                    int length = 40 - msg.getBytes().length;
                    for(int i=0; i<length;i++){
                        msg +=" ";
                    }
                }
                    
                //消息定长 消息头(78) + 消息包(80)
                str.append("158  ");
                str.append(busiCode);
                str.append(bankNo);
                str.append(areCode);
                str.append(bankOperId);
                str.append(spotNo);
                str.append(reCode);
                str.append(reMsg);
                str.append(flowNo);
                // 批扣请求
                if("20011".equals(busiCode)){
                    // 文件名
                    String fileName = json.getString("fileNameInput");
                    // 文件大小
                    String fileSize = json.getString("fileInputSize");
                    //补齐FILE_NAME报文
                    if(fileName.length() < 30){
                        int length = 30 - fileName.length();
                        for(int i=0; i<length;i++){
                            fileName +=" ";
                        }
                    }
                    //补齐SIZE报文
                    if(fileSize.length() < 30){
                        int length = 30 - fileSize.length();
                        for(int i=0; i<length;i++){
                            fileSize +=" ";
                        }
                    }
                    str.append(fileName);
                    str.append(fileSize);
                }
            } else {
                if(msg.getBytes().length < 40){
                    int length = 40 - msg.getBytes().length;
                    for(int i=0; i<length;i++){
                        msg +=" ";
                    }
                }
                //消息头定长78
                reCode = "2002";
                str.append("78   ");
                str.append(busiCode);
                str.append(bankNo);
                str.append(areCode);
                str.append(bankOperId);
                str.append(spotNo);
                str.append(reCode);
                str.append(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return str.toString();
    }
}
