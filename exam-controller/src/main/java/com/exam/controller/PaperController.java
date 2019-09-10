package com.exam.controller;

import com.exam.pojo.Paper;
import com.exam.pojo.Subject;
import com.exam.service.PaperService;
import com.exam.service.SubjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("sys")
public class PaperController {
    @Resource
    private PaperService paperService;
    @Resource
    private SubjectService subjectService;
    /**
     * 试卷管理
     * @param map
     * @param pageNo
     * @param pname
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("paperlist")
    public String paperList(ModelMap map, @RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo,String pname) throws ServletException, IOException {
        Integer pageSize = 5;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        //String newpname = new String(pname.getBytes("iso-8859-1"), "utf-8");
        //String newpname = new String(pname.getBytes("utf-8"));

        List<Paper> list = paperService.hlist(pname);
        PageInfo<Paper> pageInfo=new PageInfo<>(list);
        map.addAttribute("pageInfo",pageInfo);
        return "/sys/paper/list";
    }

    /**
     * 查看试题
     * @param pname
     * @param request
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("paperdetail")
    public String paperdetail(String pname, HttpServletRequest request) throws ServletException, IOException {
        String newpname = new String(pname.getBytes("iso-8859-1"), "utf-8");
        List<Subject> subjects = subjectService.subjectlist(newpname);
        request.setAttribute("subjects", subjects);
        request.setAttribute("pname", newpname);
        return "/sys/paper/subjects";
    }

    /**
     * 增加试题
     * @param paper
     * @param request
     * @return
     */
    @RequestMapping("addpaper")
    public String addPaper(Paper paper, HttpServletRequest request) {
        try {
            BeanUtils.populate(paper, request.getParameterMap());
            Integer i = paperService.addPaper(paper);
            if (i > 0) {
                return "redirect:paperlist";
            } else {
                request.setAttribute("msg", "增加试题功能失败！");
                return "/sys/paper/add";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
