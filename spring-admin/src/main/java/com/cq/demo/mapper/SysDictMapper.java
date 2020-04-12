package com.cq.demo.mapper;


import com.cq.demo.entity.SysDict;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
@Repository
public interface SysDictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    List<SysDict> findPage();

    List<SysDict> findPageByLabel(@Param(value = "label") String label);

    List<SysDict> findByLable(@Param(value = "label") String label);
}
