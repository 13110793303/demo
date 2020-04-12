package com.cq.demo.service;

import com.cq.demo.common.core.service.CurdService;
import com.cq.demo.entity.SysDict;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
public interface SysDictService extends CurdService<SysDict> {

    /**
     * 根据名称查询
     *
     * @param lable
     * @return
     */
    List<SysDict> findByLable(String lable);
}
