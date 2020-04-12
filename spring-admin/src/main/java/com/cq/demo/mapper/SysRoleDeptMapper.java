package com.cq.demo.mapper;


import com.cq.demo.entity.SysRoleDept;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色机构 Mapper 接口
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
@Repository
public interface SysRoleDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleDept record);

    int insertSelective(SysRoleDept record);

    SysRoleDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleDept record);

    int updateByPrimaryKey(SysRoleDept record);
}
