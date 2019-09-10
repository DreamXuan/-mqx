package com.exam.mapper;

import com.exam.pojo.Studentpaper;
import com.exam.pojo.StudentpaperExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentpaperMapper {
    int countByExample(StudentpaperExample example);

    int deleteByExample(StudentpaperExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Studentpaper record);

    int insertSelective(Studentpaper record);

    List<Studentpaper> selectByExample(StudentpaperExample example);

    Studentpaper selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Studentpaper record, @Param("example") StudentpaperExample example);

    int updateByExample(@Param("record") Studentpaper record, @Param("example") StudentpaperExample example);

    int updateByPrimaryKeySelective(Studentpaper record);

    int updateByPrimaryKey(Studentpaper record);

    List<Studentpaper> StudentPaperList(Integer userid);

    List<Studentpaper> listByRightcount(@Param("userid") Integer userid,@Param("spid") String spid);
}