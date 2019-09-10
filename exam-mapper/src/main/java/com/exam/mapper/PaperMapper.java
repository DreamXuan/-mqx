package com.exam.mapper;


import com.exam.pojo.Paper;
import com.exam.pojo.PaperExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperMapper {
    List<Paper> countByPaper(Paper paper);

    int deleteByExample(PaperExample example);

    int deleteByPrimaryKey(Integer pid);

    int insertPaper(@Param("pid")Integer pid,@Param("pname") String pname,@Param("scount") Integer scount);
   // int insertPaper(Paper paper);
    int insertSelective(Paper record);

    List<Paper> selectByExample(@Param("example") PaperExample example);

    Paper selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByExample(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByPrimaryKeySelective(Paper record);

    int updateByPrimaryKey(Paper record);

}