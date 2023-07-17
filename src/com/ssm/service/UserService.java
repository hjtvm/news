package com.ssm.service;

import com.ssm.po.User;

import java.util.List;

/**
 * @author lenovo
 */
public interface UserService {
    public List<User> selectUserList(String keywords, Integer userListRoleId);
    public User findUser(String loginName,String password);
    public User getUserByUserId(Integer id);
    public User getUserByLoginName(String loginName);
    public int addUser(User user);
    public int editUser(User user);
    public int delUser(Integer userId);
    public int setUserStatus(User user);
}
