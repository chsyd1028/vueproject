package com.csyd.controller;

import com.csyd.pojo.User;
import com.csyd.pojo.vo.LoginVo;
import com.csyd.pojo.vo.PageVo;
import com.csyd.result.Result;
import com.csyd.result.ResultGenerator;
import com.csyd.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Created by ChengShanyunduo
 * 2019/3/25
 */
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin //跨域请求必加
    @RequestMapping("/user/login")
    @ResponseBody
    public Result login(@Valid @RequestBody LoginVo loginVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            String message = String.format("登陆失败，详细信息[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return ResultGenerator.genFailResult(message);
        }
        if (!Objects.equals("admin", loginVo.getUsername()) || !Objects.equals("123456", loginVo.getPassword())) {
            String message = String.format("登陆失败，详细信息[用户名、密码信息不正确]。");
            return ResultGenerator.genFailResult(message);
        }
        return ResultGenerator.genSuccessResult();
    }

    @CrossOrigin
    @RequestMapping("/user/userList")
    @ResponseBody
    public Result userList(@RequestBody PageVo pageVo){
        PageInfo<User> userPage = userService.userPage(pageVo.getPageNum(), pageVo.getPageSize());
        return ResultGenerator.genSuccessResult(userPage);
    }
}
