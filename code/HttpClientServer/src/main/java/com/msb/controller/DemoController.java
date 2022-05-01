package com.msb.controller;

import com.msb.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IBM on 2020/9/9.
 */
@Controller
public class DemoController {

    @RequestMapping("/demo")
    @ResponseBody
    public String demo(String param)
    {
        return param + "abc";
    }

    @RequestMapping("/demo2")
    @ResponseBody
    public User demo2(User user)
    {
        return user ;
    }

    @RequestMapping("/demo3")
    @ResponseBody
    public List<User> demo3()
    {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "张三丰"));
        list.add(new User(2 , "张无忌"));
        return list ;
    }


    @RequestMapping("/demo4")
    @ResponseBody
    public String demo4(@RequestBody List<User> list)
    {
        System.out.println(list);
        return list.toString();
    }


    @RequestMapping("/demo5")
    @ResponseBody
    @CrossOrigin
    public List<User> demo5(@RequestBody List<User> list)
    {
        System.out.println(list);
        return list;
    }


}
