package com.song.controller;

import com.song.entity.User;
import com.song.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Song on 2017/2/15.
 * User控制层
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public String show(@RequestParam(value = "name")String name){
        User user = userService.findUserByName(name);
        if(null != user)
            return user.getId()+"/"+user.getName()+"/"+user.getPassword();
        else return "null";
    }

    @RequestMapping(value = "/show2",method = RequestMethod.GET)
    @ResponseBody
    public String show2(@RequestParam(value = "name")String name){
        User user = userService.findUserByName2(name);
        if(null != user)
            return user.getId()+"/"+user.getName()+"/"+user.getPassword();
        else return "null";
    }

    @RequestMapping(value = "/show3",method = RequestMethod.GET)
    @ResponseBody
    public String show3(@RequestParam(value = "name")String name,@RequestParam(value = "password")String password){
        User user = userService.findUserByName3(name,password);
        if(null != user)
            return user.getId()+"/"+user.getName()+"/"+user.getPassword();
        else return "null";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String add(@RequestParam(value = "name")String name,@RequestParam(value = "password")String password){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userService.insertUser(user);
       return "用户添加成功";
    }

    @RequestMapping(value = "/add2",method = RequestMethod.GET)
    @ResponseBody
    public String add2(@RequestParam(value = "name")String name,@RequestParam(value = "password")String password){
        userService.insertUser(name,password);
        return "用户添加成功2";
    }

}
