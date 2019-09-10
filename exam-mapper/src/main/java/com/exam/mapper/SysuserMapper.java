package com.exam.mapper;

import com.exam.pojo.Sysuser;
import com.exam.pojo.SysuserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysuserMapper {
    int countByExample(SysuserExample example);

    int deleteByExample(SysuserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(Sysuser record);

    int insertSelective(Sysuser record);

    List<Sysuser> selectByExample(@Param("example") SysuserExample example);

    Sysuser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") Sysuser record, @Param("example") SysuserExample example);

    int updateByExample(@Param("record") Sysuser record, @Param("example") SysuserExample example);

    int updateByPrimaryKeySelective(Sysuser record);

    int updateByPrimaryKey(Sysuser record);

    /**
     * 登录
     * @param username
     * @param userpwd
     * @return
     */
    Sysuser login(@Param("username") String username, @Param("userpwd") String userpwd);



}