package com.exam.service;

import com.exam.pojo.Studentpaper;
import com.exam.utils.WxResult;

import java.util.List;

public interface StudentPaperService {


    /**
     * 查询全部正确试题数量(为计算总分)
     * @param userid
     * @param spid
     * @return
     */
     List<Studentpaper> listByRightcount(Integer userid,String spid);

    /**
     * 学生提交答案
     * @param studentpaper
     * @return
     */
     Integer addPaper(Studentpaper studentpaper);

    /**
     * 学生查看已经做过试卷列表
     * @param userid
     * @return
     */
     List<Studentpaper> StudentPaperListByuserid(Integer userid);

    /**
     * 学生提交试卷
     * @param studentpaper
     * @return
     */
     WxResult postAnswer(Studentpaper studentpaper);
}
