package com.cq.demo.service;

import com.cq.demo.common.core.service.CurdService;
import com.cq.demo.entity.SysUser;
import com.cq.demo.entity.SysUserRole;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 用户管理 服务类
 * </p>
 *
 * @author chenqu
 * @since 2019-12-08
 */
public interface SysUserService extends CurdService<SysUser> {
    SysUser findByName(String username);

    /**
     * 查找用户的菜单权限标识集合
     *
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    /**
     * 查找用户的角色集合
     *
     * @param userId
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);

}
