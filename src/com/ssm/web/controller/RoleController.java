package com.ssm.web.controller;


import com.ssm.po.Role;

import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author lenovo
 */
@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value="/findRoleList.action",method= RequestMethod.GET)
	public String findRoleList(Model model){
		List<Role> roleList=roleService.findRoleList();
		if(roleList.size()>0){
			model.addAttribute("role", roleList.get(0));
		}
		return "role/role_list";
	}

	@RequestMapping(value="/findRoleWithUsersByRoleId.action",method= RequestMethod.GET)
	public String findRoleWithUsersByRoleId(Integer roleId, Model model){
		Role role=roleService.findRoleWithUsersByRoleId(roleId);
		if(role!=null){
			System.out.println(role);
		}
		return "";
	}
}
