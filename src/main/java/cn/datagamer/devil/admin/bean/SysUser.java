package cn.datagamer.devil.admin.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户表 实体类
 */
public class SysUser implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
	private Integer id;  // 	private String account;  // 账号	private String name;  // 名称	private String hashedPassword;  // 加密后的密码	private Integer status;  // 状态（0：启用 1：停用）	private Integer isDeleted;  // 是否删除（0：未删除 1：已删除）
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
	private Integer pageStart;	private Integer pageSize;		public Integer getId() {	    return this.id;	}	public void setId(Integer id) {	    this.id=id;	}	public String getAccount() {	    return this.account;	}	public void setAccount(String account) {	    this.account=account;	}	public String getName() {	    return this.name;	}	public void setName(String name) {	    this.name=name;	}	public String getHashedPassword() {	    return this.hashedPassword;	}	public void setHashedPassword(String hashedPassword) {	    this.hashedPassword=hashedPassword;	}	public Integer getStatus() {	    return this.status;	}	public void setStatus(Integer status) {	    this.status=status;	}	public Integer getIsDeleted() {	    return this.isDeleted;	}	public void setIsDeleted(Integer isDeleted) {	    this.isDeleted=isDeleted;	}
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
