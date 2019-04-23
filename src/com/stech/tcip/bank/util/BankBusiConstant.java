/*
 * 珠海卓锐公司源代码，版权归鼎方公司所有。
 * 创建日期 : 2019年1月17日
 * 修改历史 : 
 *     1. [2019年1月17日]创建文件 by "geHanBiao"
 */
package com.stech.tcip.bank.util;

import java.util.Arrays;
import java.util.List;

/**
 * 银行业务常量
 * @author "geHanBiao"
 * @version 2019年1月17日
 */
public class BankBusiConstant {
    
    public static void main(String[] args) {
        if(BankBusiConstant.BANK_CODE.contains("NX")) {
            System.out.println(123);
        }
    }
    
    /** 银行代码  */
    public static final List<String> BANK_CODE = Arrays.asList("NX","JS","ZG");
    
    /** ******************错误代码********************* */
    public static final String ERROR_0000 = "操作成功";

    public static final String ERROR_1001 = "数据库或网络断开";

    public static final String ERROR_1002 = "该用户不存在";

    public static final String ERROR_1003 = "银行端数据错误";

    public static final String ERROR_1004 = "被冲正的流水号不存在或已冲正";

    public static final String ERROR_1005 = "隔天不能冲正";

    public static final String ERROR_1006 = "交易超时";

    public static final String ERROR_1007 = "用户本月已打印发票";

    public static final String ERROR_1008 = "非银行作业范围";

    public static final String ERROR_1009 = "系统繁忙";

    public static final String ERROR_1010 = "缴费流水号重复";

    public static final String ERROR_1011 = "对帐文件不合法(空文件或者文件行数不对应)";

    public static final String ERROR_1012 = "缴费金额不足";

    public static final String ERROR_1013 = "银行传入数据包格式错误";

    public static final String ERROR_1014 = "银行端传入月份未生成帐单";

    public static final String ERROR_1015 = "用户无营业费欠费";

    public static final String ERROR_1016 = "用户无未打印发票";

    public static final String ERROR_1017 = "该用户有未处理帐单,请稍后再试";

    public static final String ERROR_1018 = "该笔缴费已做统计,不能冲正";

    public static final String ERROR_1019 = "欠费用户不能缴预存";

    public static final String ERROR_1020 = "外部流水重复";

    public static final String ERROR_1021 = "多表用户请到燃气营业厅打印发票";

    public static final String ERROR_1022 = "查询的发票格式有误";

    public static final String ERROR_1023 = "操作数据过程发生异常";

    public static final String ERROR_1601 = "协议操作程序异常";

    public static final String ERROR_1610 = "用户已建立协议";

    public static final String ERROR_1611 = "用户没有建立协议";
    
    public static final String ERROR_1602 = "获取操作员归属失败";

    public static final String ERROR_1098 = "暂停交易";

    public static final String ERROR_1099 = "其他错误";

    public static final String ERROR_1073 = "对帐文件不合法(对帐文件不存在)";

    public static final String ERROR_1078 = "对帐文件不合法(对帐文件为空)";

    public static final String ERROR_1077 = "无欠费账单";
    
    public static final String ERROR_1079 = "缴费金额不足";
    
    public static final String ERROR_1080 = "该用户无可重打发票";
    
    public static final String ERROR_1081 = "不支持IC卡用户";
    
    public static final String ERROR_1082 = "实缴与应缴金额不等";
    
    public static final String ERROR_1083 = "重复对账";
    
    public static final String ERROR_2001 = "数据库或网络断开";
    
    public static final String ERROR_2002 = "文件不存在";
    
    /** 服务代码 名称  */
    public static final String[] SERVER_0001 = { "addr", "址信息同步" };
    
    public static final String[] SERVER_0002 = { "supplypoint", "供气信息同步" };
    
    public static final String[] SERVER_0003 = { "user", "用户信息同步" };
    
    public static final String[] SERVER_0004 = { "meter", "表具信息同步" };
    
    public static final String[] SERVER_0005 = { "totalamount", "IC卡用户购总同步" };
    
    public static final String[] SERVER_0006 = { "gsmodelid", "紫荆燃气具型号同步" };

    public static final String[] SERVER_1001 = { "1001", "数据字典信息查询" };

    public static final String[] SERVER_1002 = { "1002", "联系人信息查询" };
    
    public static final String[] SERVER_1003 = { "1003", "用户信息查询" };
    
    public static final String[] SERVER_1004 = { "1004", "批量查询用户信息" };
    
    public static final String[] SERVER_1005 = { "1005", "用户表具信息查询" };
    
    public static final String[] SERVER_1006 = { "1006", "IC卡信息查询" };
    
    public static final String[] SERVER_1007 = { "1007", "用户气价信息查询" };
    
    public static final String[] SERVER_1008 = { "1008", "查询当前阶梯使用量" };
    
    public static final String[] SERVER_1009 = { "1009", "用户预存查询" };
    
    public static final String[] SERVER_1010 = { "1010", "气费账单查询" };
    
    public static final String[] SERVER_1011 = { "1011", "气费欠费账单查询" };
    
    public static final String[] SERVER_1012 = { "1012", "IC卡充值历史查询" };
    
    public static final String[] SERVER_1013 = { "1013", "缴费历史查询" };
    
    public static final String[] SERVER_1014 = { "1014", "IC卡充值前校验" };
    
    public static final String[] SERVER_1015 = { "1015", "抄表历史查询" };
    
    public static final String[] SERVER_1016 = { "1016", "验证用户是否在抄表周期内" };
    
    public static final String[] SERVER_1017 = { "1017", "自报上期止码查询" };
    
    public static final String[] SERVER_1018 = { "1018", "对账请求" };
    
    public static final String[] SERVER_1019 = { "1019", "在途工单查询" };
    
    public static final String[] SERVER_1020 = { "1020", "工单信息查询" };
    
    public static final String[] SERVER_1021 = { "1021", "内购燃气具信息查询" };
    
    public static final String[] SERVER_1022 = { "1022", "外购燃气具信息查询" };
    
    public static final String[] SERVER_1023 = { "1023", "安检单查询" };
    
    public static final String[] SERVER_1024 = { "1024", "隐患情况查询" };
    
    public static final String[] SERVER_1025 = { "1025", "VCC缴费记录查询" };
    
    public static final String[] SERVER_1026 = { "1026", "站箱用户信息查询" };
    
    public static final String[] SERVER_1027 = { "1027", "点火失败配置信息查询" };
    
    public static final String[] SERVER_1028 = { "1028", "厂商信息查询" };
    
    public static final String[] SERVER_1029 = { "1029", "材料信息查询" };
    
    public static final String[] SERVER_1030 = { "1030", "员工信息查询" };
    
    public static final String[] SERVER_1031 = { "1031", "客户业务记录查询" };
    
    public static final String[] SERVER_1032 = { "1032", "工单详情查询" };
    
    public static final String[] SERVER_1033 = { "1033", "地址实时查询" };
    
    public static final String[] SERVER_1034 = { "1034", "燃气具缴费记录查询" };
    
    public static final String[] SERVER_1035 = { "1035", "账期查询" };
    
    public static final String[] SERVER_1036 = { "1036", "银行信息查询" };
    
    public static final String[] SERVER_2001 = { "2001", "IC卡充值" };

    public static final String[] SERVER_2002 = { "2002", "气费缴费" };
    
    public static final String[] SERVER_2003 = { "2003", "自报读数试算" };

    public static final String[] SERVER_2004 = { "2004", "自报读数" };
    
    public static final String[] SERVER_2006 = { "2006", "IC卡圈存状态回写" };
    
    public static final String[] SERVER_2007 = { "2007", "营业费制定" };
    
    public static final String[] SERVER_2008 = { "2008", "银行批扣" };
    
    public static final String[] SERVER_2009 = { "2009", "银行回盘" };
    
    public static final String[] SERVER_3001 = { "3001", "联系人信息变更" };
    
    public static final String[] SERVER_3002 = { "3002", "工单发起" };
    
    public static final String[] SERVER_3003 = { "3003", "诉求工单取消" };
    
    public static final String[] SERVER_3004 = { "3004", "内购燃气具安装" };

    public static final String[] SERVER_3005 = { "3005", "内购燃气具维修" };
    
    public static final String[] SERVER_3006 = { "3006", "业务记录回写" };
    
    public static final String[] SERVER_3011 = { "3011", "修改表具编号" };
    
    public static final String[] SERVER_5001 = { "5001", "表处理" };
    
    public static final String[] SERVER_5002 = { "5002", "点火" };
    
    public static final String[] SERVER_5003 = { "5003", "挂表" };
    
    public static final String[] SERVER_5004 = { "5004", "点火挂表" };
    
    public static final String[] SERVER_5005 = { "5005", "燃气具安装" };
    
    public static final String[] SERVER_5006 = { "5006", "燃气具维修" };
    
    public static final String[] SERVER_5007 = { "5007", "IC卡无工单维修" };
    
    public static final String[] SERVER_5008 = { "5008", "燃气具送货" };
    
    public static final String[] SERVER_5009 = { "5009", "报停" };
    
    public static final String[] SERVER_5010 = { "5010", "校表" };
    
    public static final String[] SERVER_5011 = { "5011", "恢复用气" };
    
    public static final String[] SERVER_5012 = { "5012", "户内改管" };
    
    public static final String[] SERVER_5013 = { "5013", "户内整改" };
    
    public static final String[] SERVER_5014 = { "5014", "工商供气合同" };
    
    public static final String[] SERVER_5015 = { "5015", "工商安检记录" };
    
    public static final String[] SERVER_5016 = { "5016", "工商用气设备" };
    
    public static final String[] SERVER_5017 = { "5017", "工商户点火" };
    
    public static final String[] SERVER_5018 = { "5018", "工商户挂表" };
    
    public static final String APP_NAME_INTERFACES = "JK";// 接口
    
    public static final String IC_TYPE= "2001";//IC卡充值
    
    public static final String G_TYPE= "2003";//气费
    
    public static final String B_TYPE= "2004";//营业费
    
    public static final String BILL_DETAIL_SPLIT_SIGN = "\\|";
}
