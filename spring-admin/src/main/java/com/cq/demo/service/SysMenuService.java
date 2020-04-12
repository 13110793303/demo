package com.cq.demo.service;

import com.cq.demo.common.core.service.CurdService;
import com.cq.demo.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
public interface SysMenuService extends CurdService<SysMenu> {
    /**
     * 查询菜单树,用户ID和用户名为空则查询全部
     *
     * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
     * @param menuType
     * @return
     */
    List<SysMenu> findTree(String userName, int menuType);

    /**
     * 根据用户名查找菜单列表
     *
     * @param userName
     * @return
     */
    List<SysMenu> findByUser(String userName);

}
