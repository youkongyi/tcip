package com.stech.tcip.sys.dao;

import java.util.List;

import com.stech.tcip.sys.pojo.Accesstoken;

public interface AccesstokenMapper {
    int deleteByPrimaryKey(Integer pkid);

    int insert(Accesstoken record);

    int insertSelective(Accesstoken record);

    Accesstoken selectByPrimaryKey(Integer pkid);
    
    Accesstoken selectByToken(String accessToken);

    int updateByPrimaryKeySelective(Accesstoken record);

    int updateByPrimaryKey(Accesstoken record);
    
    /**
     * 
     * @Title: selectAll   
     * @Description: TODO(查询所有的token)   
     * @param accesstoken
     * @return:List<Accesstoken>
     */
    public List<Accesstoken> selectAllAccesstokens(Accesstoken accesstoken);
    
    
    /**
     * 
     * @Title: selectUrlbyDataorgid   
     * @Description: TODO(根据分公司ID查询TCIS3.0服务器地址)   
     * @param dataorgid
     * @return:String
     */
    public String selectUrlbyDataorgId(String dataorgId);
}