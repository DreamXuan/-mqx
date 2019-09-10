package com.exam.mapper;

import com.exam.pojo.Subject;
import com.exam.pojo.SubjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectMapper {
    int countByExample(SubjectExample example);

    int deleteByExample(SubjectExample example);

    int deleteByPrimaryKey(Integer sid);

    int insert(Subject record);

    int insertSelective(Subject record);

    List<Subject> selectByExample(@Param("example") SubjectExample example);

    Subject selectByPrimaryKey(Integer sid);

    int updateByExampleSelective(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByExample(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    List<Subject> errorList(@Param("userid") Integer userid,@Param("spid") String spid);

    List<Subject> subjectlist(String pname);

}