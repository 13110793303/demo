package com.cq.demo.mapper;


import com.cq.demo.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色菜单 Mapper 接口
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
@Repository
public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);

    List<SysRoleMenu> findRoleMenus(@Param(value = "roleId") Long roleId);

    List<SysRoleMenu> findAll();

    int deleteByRoleId(@Param(value = "roleId") Long roleId);
}
