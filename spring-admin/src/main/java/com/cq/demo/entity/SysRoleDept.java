package com.cq.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色机构
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
public class SysRoleDept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;
    /**
     * 角色ID
     */

    private Long roleId;
    /**
     * 机构ID
     */

    private Long deptId;
    /**
     * 创建人
     */

    private String createBy;
    /**
     * 创建时间
     */

    private Date createTime;
    /**
     * 更新人
     */

    private String lastUpdateBy;
    /**
     * 更新时间
     */

    private Date lastUpdateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "SysRoleDept{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", deptId=" + deptId +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", lastUpdateBy=" + lastUpdateBy +
                ", lastUpdateTime=" + lastUpdateTime +
                "}";
    }
}
