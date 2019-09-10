package com.exam.serviceimpl;

import com.exam.mapper.SysroleMapper;
import com.exam.pojo.Sysrole;
import com.exam.pojo.SysroleExample;
import com.exam.pojo.SysroleExample.Criteria;
import com.exam.service.RoleService;
import com.exam.utils.WxResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceimpl implements RoleService {
    @Resource
    private SysroleMapper sysroleMapper;

    @Override
    public List<Sysrole> rlist(String rolename) {
        SysroleExample example=new SysroleExample();
        Criteria criteria = example.createCriteria();
        if (rolename!=null && !rolename.equals("")){
            criteria.andRolenameLike("%" +rolename+"%");
        }
        return sysroleMapper.selectByExample(example);
    }

    @Override
    public Sysrole selByrid(Integer roleid) {
        return sysroleMapper.selectByPrimaryKey(roleid);
    }

    @Override
    public WxResult editRole(Sysrole sysrole) {
        try {
            return WxResult.ok(sysroleMapper.updateByPrimaryKey(sysrole)) ;
        }catch (IllegalStateException e){
            return WxResult.build(400, "操作异常！");
        }
    }

    @Override
    public Integer addSubject(Sysrole sysrole) {
        return sysroleMapper.insertSelective(sysrole);
    }

    @Override
    public int addRight(Integer roleid, String[] funids) {
        sysroleMapper.delRigentByroleid(roleid);
        int a = 0;
        for (String fid : funids) {
            a += sysroleMapper.insRoleright(roleid, fid);
        }
        return a;
    }

}
