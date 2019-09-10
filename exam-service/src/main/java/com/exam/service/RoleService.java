package com.exam.service;

import com.exam.pojo.Sysrole;
import com.exam.utils.WxResult;

import java.util.List;

public interface RoleService {

    List<Sysrole> rlist(String rolename);

    Sysrole selByrid(Integer roleid);

    WxResult editRole(Sysrole role);

    Integer addSubject(Sysrole sysrole);

    int addRight(Integer roleid, String[] funids);

}
