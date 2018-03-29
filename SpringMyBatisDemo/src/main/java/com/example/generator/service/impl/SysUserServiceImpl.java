package com.example.generator.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.generator.bean.SysUser;
import com.example.generator.dao.SysUserMapper;
import com.example.generator.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return this.sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(SysUser record) {
        return this.sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return this.sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Long userId) {
        return this.sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return this.sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return this.sysUserMapper.updateByPrimaryKey(record);
    }

}
