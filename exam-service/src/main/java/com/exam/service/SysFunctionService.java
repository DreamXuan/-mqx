package com.exam.service;

import com.exam.pojo.Sysfunction;

import java.util.List;

public interface SysFunctionService {
    /**
     * 分配权限初始化页面数据
     * @param roleid
     * @return
     */
    public List<Sysfunction> selfunlist(Integer roleid);
}
