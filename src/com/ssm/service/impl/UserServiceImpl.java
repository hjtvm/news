package com.ssm.service.impl;

import com.ssm.dao.UserDao;
import com.ssm.po.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lenovo
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> selectUserList(String keywords, Integer userListRoleId) {
        List<User> userList = this.userDao.selectUserList(keywords,userListRoleId);
        return userList;
    }

    @Override
    public User findUser(String loginName, String password) {
        User user = this.userDao.findUser(loginName,password);
        return user;
    }

    @Override
    public User getUserByUserId(Integer id) {
        return this.userDao.getUserByUserId(id);
    }

    @Override
    public User getUserByLoginName(String loginName) {
        return this.userDao.getUserByLoginName(loginName);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int editUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int delUser(Integer userId) {
        return userDao.delUser(userId);
    }

    @Override
    public int setUserStatus(User user) {
        return userDao.setUserStatus(user);
    }
}
