package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.UserModel;

public interface UserService {
    /**
     * 基于查询用户信息
     * @param id
     */
    UserModel getUserById(Integer id);

    /**
     * 用户注册
     * @param userModel
     */
    void register(UserModel userModel) throws BusinessException;

    /**
     * 验证用户的登录信息，密码和手机号是否匹配
     * @param telphone 用户注册的手机
     * @param encrptPaaword 用户加密的密码
     */
    UserModel validateLogin(String telphone,String encrptPaaword) throws BusinessException;
}
