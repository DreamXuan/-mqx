package com.exam.service;

import com.exam.pojo.Sysfunction;
import com.exam.pojo.Sysuser;
import com.exam.utils.WxResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    Sysuser login(String username, String userpwd);

    /**
     * 后台管理加载权限列表
     * @param user
     * @return
     */
    List<Sysfunction> initpage(Sysuser user);

    /**
     * 用户列表
     * @param sname
     * @return
     */
    List<Sysuser> userlist(String sname);

    Sysuser selByUserid(Integer userid);

    WxResult editUser(Sysuser user);

    WxResult deluser(Integer userid, HttpServletRequest request);
}
