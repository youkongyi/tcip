package com.stech.tcip.sys.dao;

import java.util.List;

import com.stech.tcip.sys.dto.AppAuthorizes;
import com.stech.tcip.sys.pojo.App;

/**   
 * @ClassName:  AppMapper   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: samuel 
 * @date:   2017年7月18日 下午2:58:00   
 *   
 **/
public interface AppMapper {
    int deleteByPrimaryKey(String appid);

    int insert(App record);

    int insertSelective(App record);

    App selectByPrimaryKey(String appid);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);
    
    /**
     * 
     * @Title: selectAll   
     * @Description: TODO(查询所有第三方应用)   
     * @param app
     * @return:List<App>
     */
    public List<App> selectAllApps(App app);
 
    /**
     * 
     * @Title: selectAll   
     * @Description: TODO(查询所有第三方应用)   
     * @param app
     * @return:List<App>
     */
    public List<AppAuthorizes> selectAppAuthorizes(AppAuthorizes appAuthorizes);
}