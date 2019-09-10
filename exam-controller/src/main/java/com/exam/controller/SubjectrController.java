package com.exam.controller;

import com.exam.pojo.Subject;
import com.exam.service.SubjectService;
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
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping("sys")
public class SubjectrController {
    @Resource
    private SubjectService subjectService;

    @RequestMapping("subjectlist")
    public String subjectList(ModelMap map, @RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo,String scontent){
        Integer pageSize = 5;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        //String newpname = new String(pname.getBytes("iso-8859-1"), "utf-8");
        //String newpname = new String(pname.getBytes("utf-8"));

        List<Subject> list = subjectService.hsublist(scontent);
        PageInfo<Subject> pageInfo=new PageInfo<>(list);
        map.addAttribute("pageInfo",pageInfo);
        return "/sys/subject/list";
    }

    @RequestMapping("addsubject")
    public String addSubject(Subject subject,HttpServletRequest request){
        try {
            BeanUtils.populate(subject, request.getParameterMap());
            Integer i = subjectService.addSubject(subject);
            if (i > 0) {
                return "redirect:subjectlist";
            } else {
                request.setAttribute("msg", "增加试题功能失败！");
                return "/sys/subject/add";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping(value = "editsubject",method = RequestMethod.GET)
    public String editSubject(Integer sid, HttpServletRequest request){
        Subject subject = subjectService.selBySid(sid);
        request.setAttribute("item",subject);
        return "sys/subject/edit";
    }
    @ResponseBody
    @RequestMapping(value = "savesubject",method = RequestMethod.POST)
    public String editSubject(Subject subject){
        return JsonUtils.objectToJson(subjectService.editSubject(subject)) ;
    }

    @ResponseBody
    @RequestMapping(value = "delsubject",method = RequestMethod.POST)
    public  String delSubject(Integer sid, HttpServletRequest request){
        return JsonUtils.objectToJson(subjectService.delsubject(sid, request)) ;
    }

}
