package com.ssm.dao;

import com.ssm.po.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lenovo
 */
public interface RoleDao {
    public List<Role> selectRoleList();
    public Role selectRoleWithUsers(@Param("roleId") Integer roleId);
}
