package com.cq.demo.mapper;


import com.cq.demo.entity.SysDept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 机构管理 Mapper 接口
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
@Repository
public interface SysDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);

    List<SysDept> findPage();

    List<SysDept> findAll();
}
