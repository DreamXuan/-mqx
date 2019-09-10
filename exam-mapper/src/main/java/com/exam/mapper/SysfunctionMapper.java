package com.exam.mapper;

import com.exam.pojo.Sysfunction;
import com.exam.pojo.SysfunctionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysfunctionMapper {
    int countByExample(SysfunctionExample example);

    int deleteByExample(SysfunctionExample example);

    int deleteByPrimaryKey(Integer funid);

    int insert(Sysfunction record);

    int insertSelective(Sysfunction record);

    List<Sysfunction> selectByExample(SysfunctionExample example);

    Sysfunction selectByPrimaryKey(Integer funid);

    int updateByExampleSelective(@Param("record") Sysfunction record, @Param("example") SysfunctionExample example);

    int updateByExample(@Param("record") Sysfunction record, @Param("example") SysfunctionExample example);

    int updateByPrimaryKeySelective(Sysfunction record);

    int updateByPrimaryKey(Sysfunction record);

    /**
     *初始化用户功能列表
     * @return
     */
    List<Sysfunction> initpage();
    List<Sysfunction> initpageR(int roleid);

    List<Sysfunction> selFunlist(Integer roleid);
}