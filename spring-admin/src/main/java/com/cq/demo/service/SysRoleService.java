package com.cq.demo.service;

import com.cq.demo.common.core.service.CurdService;
import com.cq.demo.entity.SysMenu;
import com.cq.demo.entity.SysRole;
import com.cq.demo.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
 * 角色管理 服务类
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
public interface SysRoleService extends CurdService<SysRole> {
    /**
     * 查询全部
     *
     * @return
     */
    List<SysRole> findAll();

    /**
     * 查询角色菜单集合
     *
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 保存角色菜单
     *
     * @param records
     * @return
     */
    int saveRoleMenus(List<SysRoleMenu> records);

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    List<SysRole> findByName(String name);

}
