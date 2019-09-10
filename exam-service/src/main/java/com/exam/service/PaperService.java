package com.exam.service;

import com.exam.pojo.Paper;

import java.util.List;

public interface PaperService {
    /**
     * 试题列表(前台首页)
     * @param paper
     * @return
     */
    List<Paper> qlist(Paper paper);

    /**
     * 试题列表(后台)
     * @param pname
     * @return
     */
    List<Paper> hlist(String pname);

    int addPaper(Paper paper);
}
