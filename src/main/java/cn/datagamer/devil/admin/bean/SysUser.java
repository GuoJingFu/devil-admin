package cn.datagamer.devil.admin.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户表 实体类
 */
public class SysUser implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
	private Integer id;  // 
	/**
     * 基本信息
     */
    private Date createdAt;
    
    private Date updatedAt;
    
    private Integer createdBy;
    
    private Integer updatedBy;
	
	private String curPassword; //现密码
	
	/**
	 * 分页
	 */
	private Integer pageStart;
    /**
     * @return the curPassword
     */
    public String getCurPassword() {
        return curPassword;
    }
    /**
     * @param curPassword the curPassword to set
     */
    public void setCurPassword(String curPassword) {
        this.curPassword = curPassword;
    }
    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }
    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }
    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    /**
     * @return the createdBy
     */
    public Integer getCreatedBy() {
        return createdBy;
    }
    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    /**
     * @return the updatedBy
     */
    public Integer getUpdatedBy() {
        return updatedBy;
    }
    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
    /**
     * @return the pageStart
     */
    public Integer getPageStart() {
        return pageStart;
    }
    /**
     * @param pageStart the pageStart to set
     */
    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }
    /**
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }
    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}