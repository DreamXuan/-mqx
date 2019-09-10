package com.exam.serviceimpl;

import com.exam.mapper.SysfunctionMapper;
import com.exam.mapper.SysuserMapper;
import com.exam.pojo.Sysfunction;
import com.exam.pojo.Sysuser;
import com.exam.pojo.SysuserExample;
import com.exam.pojo.SysuserExample.Criteria;
import com.exam.service.UserService;
import com.exam.utils.WxResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Resource
    private SysuserMapper sysuserMapper;
    @Resource
    private SysfunctionMapper sysfunctionMapper;

    public Sysuser login(String username, String userpwd) {
        return sysuserMapper.login(username,userpwd);
    }

    public List<Sysfunction> initpage(Sysuser user) {
        if (user.getRoleid().equals(-1)){
            return sysfunctionMapper.initpage();
        }else {
           return sysfunctionMapper.initpageR(user.getRoleid());
        }

    }

    @Override
    public List<Sysuser> userlist(String sname) {
        SysuserExample example=new SysuserExample();
        Criteria criteria = example.createCriteria();
        if (sname!=null && !sname.equals("")) {
            criteria.andUsernameLike("%" + sname + "%");
        }
        return sysuserMapper.selectByExample(example);
    }

    @Override
    public Sysuser selByUserid(Integer userid) {
        return sysuserMapper.selectByPrimaryKey(userid);
    }

    @Override
    public WxResult editUser(Sysuser user) {
            try {
                return WxResult.ok(sysuserMapper.updateByPrimaryKey(user)) ;
            }catch (IllegalStateException e){
                return WxResult.build(400, "操作异常！");
            }
    }

    @Override
    public WxResult deluser(Integer userid, HttpServletRequest request) {
        try {
            return WxResult.ok(sysuserMapper.deleteByPrimaryKey(userid)) ;
        }catch (IllegalStateException e){
            return WxResult.build(400, "操作异常！");
        }
    }


    /*public Sysuser adminlogin(String username, String userpwd) {
        return null;
    }*/
}
