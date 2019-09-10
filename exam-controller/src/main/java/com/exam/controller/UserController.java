package com.exam.controller;

import com.exam.pojo.Sysuser;
import com.exam.service.UserService;
import com.exam.utils.JsonUtils;
import com.exam.utils.MD5Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("userlist")
    public String userList(ModelMap map, @RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo,String sname){
        Integer pageSize = 5;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        //String newpname = new String(pname.getBytes("iso-8859-1"), "utf-8");
        //String newpname = new String(pname.getBytes("utf-8"));

        List<Sysuser> list = userService.userlist(sname);
        PageInfo<Sysuser> pageInfo=new PageInfo<>(list);
        map.addAttribute("pageInfo",pageInfo);
        return "/sys/user/list";
    }
    @RequestMapping(value = "edituser",method = RequestMethod.GET)
    public String edituser(Integer userid, HttpServletRequest request){
        Sysuser user = userService.selByUserid(userid);
        request.setAttribute("item",user);
        return "sys/user/edit";
    }
    @ResponseBody
    @RequestMapping(value = "saveuser",method = RequestMethod.POST)
    public String edituser(Sysuser user){
        String userpwd = MD5Utils.md5(user.getUserpwd());
        user.setUserpwd(userpwd);
        return JsonUtils.objectToJson(userService.editUser(user)) ;
    }

    @ResponseBody
    @RequestMapping(value = "deluser",method = RequestMethod.POST)
    public  String deluser(Integer sid, HttpServletRequest request){
        return JsonUtils.objectToJson(userService.deluser(sid, request)) ;
    }
}
