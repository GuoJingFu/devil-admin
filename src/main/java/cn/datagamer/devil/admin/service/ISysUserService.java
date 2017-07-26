package cn.datagamer.devil.admin.service;

import com.github.pagehelper.PageInfo;

import cn.datagamer.devil.admin.bean.SysUser;

/**
 * 系统用户表 service接口
 */
public interface ISysUserService {

    /**
     * 增加方法
     */
    SysUser insert(SysUser sysUser);
    
    /**
     * 删除方法
     * @return
     */
    boolean delete(SysUser sysUser);
    
    /**
     * 更新方法
     * @return
     */
    boolean update(SysUser sysUser);
    
    /**
     * 选择更新方法
     * @return
     */
    boolean updateSelectiveByPrimaryKey(SysUser sysUser);
    
    /**
     * 根据id进行查询
     */
    SysUser findById(Integer beanId);
    
    /**
     * 根据model参数进行查询
     */
    PageInfo<SysUser> findList(SysUser sysUser);
    
}
