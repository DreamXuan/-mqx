package com.exam.serviceimpl;

import com.exam.mapper.StudentpaperMapper;
import com.exam.pojo.Studentpaper;
import com.exam.service.StudentPaperService;
import com.exam.utils.WxResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentPaperServiceimpl implements StudentPaperService {
    @Resource
    StudentpaperMapper studentpaperMapper;

    public List<Studentpaper> listByRightcount( Integer userid,  String spid) {
        return studentpaperMapper.listByRightcount(userid,spid);
    }

    public Integer addPaper(Studentpaper studentpaper) {
        return null;
    }

    public List<Studentpaper> StudentPaperListByuserid(Integer userid) {
        return studentpaperMapper.StudentPaperList(userid);
    }

    public WxResult postAnswer(Studentpaper studentpaper) {
        try {
            studentpaperMapper.insert(studentpaper);
            return WxResult.ok();
        } catch (Exception e) {
            return WxResult.fail("操作异常");
        }

    }
}
