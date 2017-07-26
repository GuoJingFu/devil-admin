package cn.datagamer.devil.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.datagamer.devil.admin.bean.SysUser;
import cn.datagamer.devil.admin.mapper.SysUserMapper;
import cn.datagamer.devil.admin.service.ISysUserService;

/**
 * 系统用户表 service实现
 */
@Service
public class SysUserService implements ISysUserService {
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Override
    /**
     * 增加方法
     */
    @Transactional
    public SysUser insert(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }
    
    @Override
    /**
     * 删除方法
     * @return
     */
    @Transactional
    public boolean delete(SysUser sysUser) {
        return sysUserMapper.delete(sysUser);
    }
    
    @Override
    /**
     * 更新方法
     * @return
     */
    @Transactional
    public boolean update(SysUser sysUser) {
        return sysUserMapper.update(sysUser) == 1;
    }
    
    @Override
    /**
     * 选择更新方法
     * @return
     */
    @Transactional
    public boolean updateSelectiveByPrimaryKey(SysUser sysUser) {
        return sysUserMapper.updateSelectiveByPrimaryKey(sysUser) == 1;
    }
    
    @Override
    /**
     * 根据id进行查询
     */
    public SysUser findById(Integer beanId) {
        return sysUserMapper.findById(beanId);
    }
    
    @Override
    /**
     * 根据model参数进行分页查询
     */
    public PageInfo<SysUser> findList(SysUser sysUser) {
        List<SysUser> sysUsers = new ArrayList<SysUser>();
        PageHelper.startPage(sysUser.getPageStart(), sysUser.getPageSize());
        sysUsers = sysUserMapper.findList(sysUser);
        PageInfo<SysUser> page = new PageInfo<SysUser>(sysUsers);
        return page;
    }
    
}
