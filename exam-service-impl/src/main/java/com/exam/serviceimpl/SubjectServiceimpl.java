package com.exam.serviceimpl;

import com.exam.mapper.SubjectMapper;
import com.exam.pojo.Subject;
import com.exam.pojo.SubjectExample;
import com.exam.pojo.SubjectExample.Criteria;
import com.exam.service.SubjectService;
import com.exam.utils.WxResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SubjectServiceimpl implements SubjectService {
    @Resource
    SubjectMapper subjectMapper;

    public List<Subject> list(Integer userid, String spid) {
        List<Subject> list = subjectMapper.errorList(userid, spid);
        return list;
    }

    public List<Subject> subjectlist(String pname) {
        return subjectMapper.subjectlist(pname);
    }

    public List<Subject> hsublist(String scontent) {
        SubjectExample example=new SubjectExample();
        Criteria criteria = example.createCriteria();
        if (scontent!=null && !scontent.equals("")){
            criteria.andScontentLike("%" + scontent + "%");
        }
        return subjectMapper.selectByExample(example);
    }

    @Override
    public int addSubject(Subject subject) {
        return subjectMapper.insertSelective(subject);
    }

    @Override
    public Subject selBySid(Integer sid) {
        return subjectMapper.selectByPrimaryKey(sid);
    }

    @Override
    public WxResult editSubject(Subject subject) {
        try {
            return WxResult.ok(subjectMapper.updateByPrimaryKey(subject)) ;
        }catch (IllegalStateException e){
            return WxResult.build(400, "操作异常！");
        }
    }

    @Override
    public WxResult delsubject(Integer sid, HttpServletRequest request) {
        try {
            return WxResult.ok(subjectMapper.deleteByPrimaryKey(sid)) ;
        }catch (IllegalStateException e){
            return WxResult.build(400, "操作异常！");
        }
    }


}
