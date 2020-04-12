package com.cq.demo.service.impl;

import com.cq.demo.common.core.page.ColumnFilter;
import com.cq.demo.common.core.page.MybatisPageHelper;
import com.cq.demo.common.core.page.PageRequest;
import com.cq.demo.common.core.page.PageResult;
import com.cq.demo.constants.SysConstants;
import com.cq.demo.entity.SysMenu;
import com.cq.demo.entity.SysRole;
import com.cq.demo.entity.SysRoleMenu;
import com.cq.demo.mapper.SysMenuMapper;
import com.cq.demo.mapper.SysRoleMapper;
import com.cq.demo.mapper.SysRoleMenuMapper;
import com.cq.demo.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色管理 服务实现类
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public int save(SysRole record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysRoleMapper.insertSelective(record);
        }
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysRole> records) {
        for (SysRole record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysRole findById(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilter("name");
        if (columnFilter != null && columnFilter.getValue() != null) {
            return MybatisPageHelper.findPage(pageRequest, sysRoleMapper, "findPageByName", columnFilter.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, sysRoleMapper);
    }

    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.findAll();
    }

    public SysRoleMapper getSysRoleMapper() {
        return sysRoleMapper;
    }

    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
            // 如果是超级管理员，返回全部
            return sysMenuMapper.findAll();
        }
        return sysMenuMapper.findRoleMenus(roleId);
    }

    @Transactional
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if (records == null || records.isEmpty()) {
            return 1;
        }
        Long roleId = records.get(0).getRoleId();
        sysRoleMenuMapper.deleteByRoleId(roleId);
        for (SysRoleMenu record : records) {
            sysRoleMenuMapper.insertSelective(record);
        }
        return 1;
    }

    @Override
    public List<SysRole> findByName(String name) {
        return sysRoleMapper.findByName(name);
    }
}
