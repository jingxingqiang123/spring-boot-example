package com.miaoshaproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JingXingQiang
 * @date 2019/6/1 20:08
 */
@RestController
@RequestMapping("/")
public class HelloController {

//    @Autowired
//    private UserDOMapper userDOMapper;

    @RequestMapping("hello")
    public String hello() {
        return "Hello  girl";
    }
//    @RequestMapping("getUser")
//    public String getUser() {
//       UserDO userDO = userDOMapper.selectByPrimaryKey(1);
//       if (userDO==null){
//           return "用户对象不存在";
//       }else {
//           return userDO.getName();
//       }
//    }
}
