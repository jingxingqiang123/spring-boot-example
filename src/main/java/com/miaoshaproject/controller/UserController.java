package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserServcie;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JingXingQiang
 * @date 2019/6/1 22:31
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServcie userServcie;

    @RequestMapping("/get")
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) {
        // 调用service服务获取对应的id的用户对象并返回给前端
        UserModel userModel = userServcie.getUserById(id);

        // 将核心领域模型用户对象转化为可供UI使用的viewobject
         UserVO userVO = convertFromModel(userModel);

         // 返回通用对象
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }
}
