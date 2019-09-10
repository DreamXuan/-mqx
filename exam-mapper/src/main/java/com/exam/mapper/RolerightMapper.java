package com.exam.mapper;

import com.exam.pojo.Roleright;
import com.exam.pojo.RolerightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolerightMapper {
    int countByExample(RolerightExample example);

    int deleteByExample(RolerightExample example);

    int deleteByPrimaryKey(Integer rrid);

    int insert(Roleright record);

    int insertSelective(Roleright record);

    List<Roleright> selectByExample(RolerightExample example);

    Roleright selectByPrimaryKey(Integer rrid);

    int updateByExampleSelective(@Param("record") Roleright record, @Param("example") RolerightExample example);

    int updateByExample(@Param("record") Roleright record, @Param("example") RolerightExample example);

    int updateByPrimaryKeySelective(Roleright record);

    int updateByPrimaryKey(Roleright record);
}