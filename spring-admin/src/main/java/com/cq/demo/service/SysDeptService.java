package com.cq.demo.service;


import com.cq.demo.common.core.service.CurdService;
import com.cq.demo.entity.SysDept;

import java.util.List;

/**
 * <p>
 * 机构管理 服务类
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
public interface SysDeptService extends CurdService<SysDept> {
    /**
     * 查询机构树
     *
     * @return
     */
    List<SysDept> findTree();
}
