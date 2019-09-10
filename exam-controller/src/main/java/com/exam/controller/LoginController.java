package com.exam.controller;

import com.exam.pojo.Paper;
import com.exam.pojo.Sysfunction;
import com.exam.pojo.Sysuser;
import com.exam.service.PaperService;
import com.exam.service.SubjectService;
import com.exam.service.UserService;
import com.exam.utils.WxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {
    @Resource
    private UserService userService;
    @Resource
    private PaperService paperService;
    @Resource
    private SubjectService subjectService;

    /**
     * 学生登录
     * @return
     */
    @RequestMapping( "stulogin")
    public void stulogin(String username,String userpwd, HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Sysuser user = userService.login(username, userpwd);
        if (user==null){
            request.setAttribute("msg", "账号或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }else {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            index(request, response);
        }
    }
    /**
     * 管理员登陆
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("adminlogin")
    public void adminlogin(String username,String userpwd,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Sysuser user = userService.login(username, userpwd);
        if(user==null){
            request.setAttribute("msg", "用户名密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }else{
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            initpage(request, response);
            //request.getRequestDispatcher("/sys/user?cmd=init").forward(request, response);
        }
    }
    /**
     * 初始化主页
     * @param request
     * @param response
     */
    private void initpage(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(true);
        Sysuser user = (Sysuser)session.getAttribute("user");
        List<Sysfunction> list =userService.initpage(user);
        try {
            request.setAttribute("list", list);
            RequestDispatcher rds=request.getRequestDispatcher("/index.jsp");
            rds.forward(request, response);
            return;
            //request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转首页时加载试题列表
     * @param request
     * @param response
     */
    @RequestMapping("/paperlist")
    public void index(HttpServletRequest request, HttpServletResponse response) {
        Paper paper = new Paper();
        List<Paper> papers = paperService.qlist(paper);
        request.setAttribute("list", papers);
        try {
            request.getRequestDispatcher("/user/index.jsp").forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    /**
     * 退出登录
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "logout",method = RequestMethod.POST)
    @ResponseBody
    public WxResult logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        WxResult wxResult=null;
        HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("user");
             wxResult = WxResult.ok();
        } else {
           wxResult = WxResult.fail("退出失败");

        }
        return wxResult;
    }

}
