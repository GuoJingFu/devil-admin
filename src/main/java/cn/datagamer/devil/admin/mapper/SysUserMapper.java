package cn.datagamer.devil.admin.mapper;

import java.util.List;

import cn.datagamer.devil.admin.bean.SysUser;

/**
 * 用户表 mapper接口
 * @version 1.0
 */
public interface SysUserMapper {
	
    /**
     * 增加方法
     */
    SysUser insert(SysUser user);
    
    /**
     * 删除方法(逻辑删除)
     * @return
     */
    boolean delete(SysUser user);
    
    /**
     * 更新方法
     * @return
     */
    int update(SysUser user);
    
    /**
     * 选择更新方法
     * @return
     */
    int updateSelectiveByPrimaryKey(SysUser user);
    
    /**
     * 根据id进行查询
     */
    SysUser findById(Integer beanId);
    
    /**
     * 根据model参数进行查询
     */
    List<SysUser> findList(SysUser user);
}
