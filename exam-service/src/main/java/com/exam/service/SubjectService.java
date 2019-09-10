package com.exam.service;

import com.exam.pojo.Subject;
import com.exam.utils.WxResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SubjectService {
    /**
     * 查询全部错误试题列表
	 * @param userid
     * @param spid
	 * @return
             */
    List <Subject> list(Integer userid, String spid);
    /**
     * 查询试题内容(前台)
     * @param pname
     * @return
     */
    List<Subject> subjectlist(String pname);

    /**
     * 试题列表(后台)
     * @param scontent
     * @return
     */
    List<Subject> hsublist(String scontent);

    int addSubject(Subject subject);

    Subject selBySid(Integer sid);

    WxResult editSubject(Subject subject);

    WxResult delsubject(Integer sid, HttpServletRequest request);
}
