package com.csyd.service;

import com.csyd.dao.UserMapper;
import com.csyd.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ChengShanyunduo
 * 2019/4/10
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public PageInfo<User> userPage(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectAll();
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return userPageInfo;
    }
}
