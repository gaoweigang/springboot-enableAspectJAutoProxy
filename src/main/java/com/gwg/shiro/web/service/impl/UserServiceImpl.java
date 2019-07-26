package com.gwg.shiro.web.service.impl;

import com.gwg.shiro.web.config.jdbc.DataSource;
import com.gwg.shiro.web.config.jdbc.DataSourceNames;
import com.gwg.shiro.web.service.UserService;
import com.gwg.shiro.web.vo.UserRole;
import com.gwg.shiro.web.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author gwg
 *
 */
@Component
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * 1.使用jdk动态代理的时候，会报如下异常：
     * The bean 'userServiceImpl' could not be injected as a 'com.gwg.shiro.web.service.impl.UserServiceImpl' because it is a JDK dynamic proxy that implements:
     * 2.使用@EnableAspectJAutoProxy(proxyTargetClass = false)使用标准的jdk动态代理
     * 3.使用@EnableAspectJAutoProxy(proxyTargetClass = true)使用CGLIB
     */
	/*@Autowired
    private UserServiceImpl userService;*/


    @Override
    public UserVo queryUserVoByUserCode(String userCode) {
        System.out.println("queryUserVoByUserCode start...");
        UserVo userVo = new UserVo();
        userVo.setUsername("gaoweigang");
        userVo.setUserCode("000012");
        return userVo;
    }


    /**
     * 使用CGLIB代理，把@DataSouce注解写到实现类中，而使用jdk动态代理则需把@DataSource注解写到接口中
     */
    @DataSource(name = DataSourceNames.ROLE)
    public List<UserRole> queryUserRoleInfoByUserCode(String userCode){
        System.out.println("queryUserVoByUserCode start...");
        List<UserRole> userRoleList = new ArrayList<>();
        UserRole userRole = new UserRole();
        userRole.setUserCode("000012");
        userRole.setRoleCode("admin");
        userRoleList.add(userRole);
        return userRoleList;

    }




}
