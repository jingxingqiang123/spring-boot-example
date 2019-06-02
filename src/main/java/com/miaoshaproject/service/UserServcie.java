package com.miaoshaproject.service;

import com.miaoshaproject.service.model.UserModel;

public interface UserServcie {
    /**
     * 基于查询用户信息
     * @param id
     */
    UserModel getUserById(Integer id);
}
