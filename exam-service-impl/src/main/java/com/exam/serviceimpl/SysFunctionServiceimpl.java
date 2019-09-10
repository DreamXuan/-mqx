package com.exam.serviceimpl;

import com.exam.mapper.SysfunctionMapper;
import com.exam.pojo.Sysfunction;
import com.exam.pojo.Sysrole;
import com.exam.service.SysFunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysFunctionServiceimpl implements SysFunctionService {
    @Resource
    private SysfunctionMapper sysfunctionMapper;
    @Override
    public List<Sysfunction> selfunlist(Integer roleid) {
        return sysfunctionMapper.selFunlist(roleid);
    }
}
