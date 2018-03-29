package com.example.generator.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.generator.bean.SysMenu;
import com.example.generator.dao.SysMenuMapper;
import com.example.generator.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuMapper mapper;

    @Override
    public int deleteByPrimaryKey(Long menuId) {
        return this.mapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int insert(SysMenu record) {
        return this.mapper.insert(record);
    }

    @Override
    public int insertSelective(SysMenu record) {
        return this.mapper.insertSelective(record);
    }

    @Override
    public SysMenu selectByPrimaryKey(Long menuId) {
        return this.mapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu record) {
        return this.mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysMenu record) {
        return this.mapper.updateByPrimaryKey(record);
    }

}
