package com.exam.mapper;

import com.exam.pojo.Sysrole;
import com.exam.pojo.SysroleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysroleMapper {
    int countByExample(SysroleExample example);

    int deleteByExample(SysroleExample example);

    int deleteByPrimaryKey(Integer roleid);

    int insert(Sysrole record);

    int insertSelective(Sysrole record);

    List<Sysrole> selectByExample(@Param("example") SysroleExample example);

    Sysrole selectByPrimaryKey(Integer roleid);

    int updateByExampleSelective(@Param("record") Sysrole record, @Param("example") SysroleExample example);

    int updateByExample(@Param("record") Sysrole record, @Param("example") SysroleExample example);

    int updateByPrimaryKeySelective(Sysrole record);

    int updateByPrimaryKey(Sysrole record);

    int delRigentByroleid(Integer roleid);

    int insRoleright(@Param("roleid") Integer roleid,@Param("funid") String funid);
}