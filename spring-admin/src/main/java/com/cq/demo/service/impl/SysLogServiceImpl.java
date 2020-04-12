package com.cq.demo.service.impl;

import com.cq.demo.common.core.page.ColumnFilter;
import com.cq.demo.common.core.page.MybatisPageHelper;
import com.cq.demo.common.core.page.PageRequest;
import com.cq.demo.common.core.page.PageResult;
import com.cq.demo.entity.SysLog;
import com.cq.demo.mapper.SysLogMapper;
import com.cq.demo.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int save(SysLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLogMapper.insertSelective(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        for (SysLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilter("userName");
        if (columnFilter != null) {
            return MybatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", columnFilter.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, sysLogMapper);
    }

}
