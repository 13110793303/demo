package com.cq.demo.service.impl;

import com.cq.demo.common.core.page.ColumnFilter;
import com.cq.demo.common.core.page.MybatisPageHelper;
import com.cq.demo.common.core.page.PageRequest;
import com.cq.demo.common.core.page.PageResult;
import com.cq.demo.entity.SysDict;
import com.cq.demo.mapper.SysDictMapper;
import com.cq.demo.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SysDictServiceImpl implements SysDictService {
    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public int save(SysDict record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysDictMapper.insertSelective(record);
        }
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysDict record) {
        return sysDictMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDict> records) {
        for (SysDict record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilter("label");
        if (columnFilter != null) {
            return MybatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", columnFilter.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
    }

    @Override
    public List<SysDict> findByLable(String lable) {
        return sysDictMapper.findByLable(lable);
    }

}
