package com.exam.serviceimpl;

import com.exam.mapper.PaperMapper;
import com.exam.pojo.Paper;
import com.exam.pojo.PaperExample;
import com.exam.pojo.PaperExample.Criteria;
import com.exam.service.PaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaperServiceimpl implements PaperService {
    @Resource
    PaperMapper paperMapper;
    public List<Paper> qlist(Paper paper) {
        return paperMapper.countByPaper(paper);
    }

    public List<Paper> hlist(String pname) {
        PaperExample example=new PaperExample();
        Criteria criteria = example.createCriteria();
        if (pname!=null && !pname.equals("")){
            criteria.andPnameLike("%" + pname + "%");
        }
        return paperMapper.selectByExample(example);
    }

    public int addPaper(Paper paper) {
        return paperMapper.insertPaper(paper.getPid(),paper.getPname(),paper.getScount());
    }

}
