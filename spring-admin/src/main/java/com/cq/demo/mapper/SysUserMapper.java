package com.cq.demo.mapper;

import com.cq.demo.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author chenqu
 * @since 2019-12-08
 */
@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> findPage();

    List<SysUser> findPageByName(@Param(value = "name") String name);

    SysUser findByName(@Param(value = "name") String name);
}
