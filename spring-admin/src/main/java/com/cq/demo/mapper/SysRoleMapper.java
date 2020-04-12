package com.cq.demo.mapper;


import com.cq.demo.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色管理 Mapper 接口
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
@Repository
public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> findPage();

    List<SysRole> findAll();

    List<SysRole> findPageByName(@Param(value = "name") String name);

    List<SysRole> findByName(@Param(value = "name") String name);
}
