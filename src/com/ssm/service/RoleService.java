package com.ssm.service;

import com.ssm.po.Role;


import java.util.List;

/**
 * @author lenovo
 */
public interface RoleService {
    public List<Role> findRoleList();
    public Role findRoleWithUsersByRoleId(Integer roleId);
}
