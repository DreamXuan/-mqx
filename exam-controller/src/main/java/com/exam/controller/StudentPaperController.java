package com.exam.controller;

import com.exam.pojo.Studentpaper;
import com.exam.pojo.Subject;
import com.exam.pojo.Sysuser;
import com.exam.service.StudentPaperService;
import com.exam.service.SubjectService;
import com.exam.utils.JsonUtils;
import com.exam.utils.WxResult;
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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
public class StudentPaperController {
    @Resource
    private StudentPaperService studentPaperService;
    @Resource
    private SubjectService subjectService;

    /**
     *获取学生的错题试卷列表
     * @param map
     * @param request
     * @param pageNo
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("errorpaperlist")
    public String errorPaperList(ModelMap map, HttpServletRequest request,
                               @RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo)throws ServletException, IOException {

       /* Integer pageSize = 5;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);*/
        Sysuser user = (Sysuser) request.getSession().getAttribute("user");
        List<Studentpaper> list = studentPaperService.StudentPaperListByuserid(user.getUserid());
       /* PageInfo<Studentpaper> pageInfo=new PageInfo<>(list);*/
        map.addAttribute("pageInfo",list);
        return "/user/paper/studentpaper";
    }

    /**
     * 获取学生的错题详情
     * @param map
     * @param request
     * @param spid
     * @param pageNo
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "errorpaperdetail")
    public String errorPaperDetail(ModelMap map,HttpServletRequest request,
                                   @RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo,
                                   @RequestParam(defaultValue = "", required = true, value = "spid") String spid)throws ServletException, IOException{
        Integer pageSize = 5;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        Sysuser user = (Sysuser) request.getSession().getAttribute("user");
        List<Subject> list = subjectService.list(user.getUserid(),spid);
        PageInfo<Subject> pageInfo=new PageInfo<>(list);
        map.addAttribute("pageInfo",pageInfo);
        return "/user/paper/studenterror";
    }

    /**点击开始答题
     * 获取试题内容
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("paperdetail")
    public String paperDetail(String pname,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newpname = new String(pname.getBytes("iso-8859-1"), "utf-8");
        List<Subject> subjects = subjectService.subjectlist(newpname);
        request.setAttribute("subjects", subjects);
        request.setAttribute("pname", newpname);
        return "/user/paper/paper";
    }

    /**
     * 提交试卷
     * @param studentpaper
     * @return
     */
    @RequestMapping(value = "/postanswer",method = RequestMethod.POST)
    @ResponseBody
    public String postAnswer(Studentpaper studentpaper)throws IOException{
        String pname = new String(studentpaper.getPname().getBytes("iso-8859-1"), "utf-8");
        studentpaper.setPname(pname);
        return JsonUtils.objectToJson(studentPaperService.postAnswer(studentpaper));
    }

    @RequestMapping(value = "/getscore",method = RequestMethod.POST)
    @ResponseBody
    public WxResult getScore(Integer userid, String spid, HttpServletRequest request){
        WxResult wxResult=null;
       /* Studentpaper studentpaper=new Studentpaper();
        studentpaper.setSpid(spid);
        studentpaper.setUserid(userid);*/
        try {

            List<Studentpaper> studentpapers = studentPaperService.listByRightcount(userid,spid);
            BeanUtils.populate(studentpapers,request.getParameterMap());
            Integer score = studentpapers.get(0).getRightcount();
            request.setAttribute("score",score);
            wxResult=WxResult.ok(score);
        } catch (IllegalAccessException e) {
            wxResult= WxResult.fail("失败");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            wxResult= WxResult.fail("失败");
            e.printStackTrace();
        }

        return wxResult;
    }
}
