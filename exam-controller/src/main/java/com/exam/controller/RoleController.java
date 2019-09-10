package com.exam.controller;

import com.exam.pojo.Roleright;
import com.exam.pojo.Sysfunction;
import com.exam.pojo.Sysrole;
import com.exam.service.RoleService;
import com.exam.service.SysFunctionService;
import com.exam.utils.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@Controller
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private SysFunctionService sysFunctionService;

    @RequestMapping("rolelist")
    public String roleList(ModelMap map, @RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo, String rolename) throws ServletException, IOException {
        Integer pageSize = 5;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);

        List<Sysrole> list = roleService.rlist(rolename);
        PageInfo<Sysrole> pageInfo = new PageInfo<>(list);
        map.addAttribute("pageInfo", pageInfo);
        return "/sys/role/list";
    }

    /**
     * 点击修改角色调用
     *
     * @param roleid
     * @param request
     * @return
     */
    @RequestMapping(value = "editrole", method = RequestMethod.GET)
    public String editrole(Integer roleid, HttpServletRequest request) {
        Sysrole role = roleService.selByrid(roleid);
        request.setAttribute("item", role);
        return "sys/role/edit";
    }

    /**
     * 点击保存角色调用
     *
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "saverole", method = RequestMethod.POST)
    public String editrole(Sysrole role) {
        return JsonUtils.objectToJson(roleService.editRole(role));
    }

    /**
     *点击修改权限调用
     * @param roleid
     * @param request
     * @return
     */
    @RequestMapping(value = "editright", method = RequestMethod.GET)
    public String editRight(Integer roleid, HttpServletRequest request) {
        List<Sysfunction> list = sysFunctionService.selfunlist(roleid);
        request.setAttribute("list", list);

        Sysrole sysrole = roleService.selByrid(roleid);
        request.setAttribute("role", sysrole);
        return "sys/role/right";
    }
    @ResponseBody
    @RequestMapping(value = "saveright", method = RequestMethod.POST)
    public String editright(Roleright role, HttpServletRequest request) {
        String[] funids = request.getParameterValues("ckrr");
        roleService.addRight(role.getRoleid(),funids);
        return "";
    }

    @RequestMapping("addrole")
    public String addRole(Sysrole sysrole,HttpServletRequest request){
        try {
            BeanUtils.populate(sysrole, request.getParameterMap());
            Integer i = roleService.addSubject(sysrole);
            if (i > 0) {
                return "redirect:rolelist";
            } else {
                request.setAttribute("msg", "增加角色失败！");
                return "/sys/role/add";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
