package cn.datagamer.devil.admin.web;

import cn.datagamer.devil.admin.bean.SysUser;
import cn.datagamer.devil.admin.service.ISysUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统用户逻辑
 *
 * @author Devil
 * @date 2017-07-31 09:21
 */
@Controller
@RequestMapping("/sysUserManagement")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("/index")
    public String index() {
        return "sysUser/index";
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getList(HttpServletRequest request, @RequestBody SysUser sysUser) {
        if (sysUser.getPageSize() == null) sysUser.setPageSize(0);
        if (sysUser.getPageStart() == null) sysUser.setPageStart(1);
        PageInfo<SysUser> userList = sysUserService.findList(sysUser);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("total", userList.getTotal());
        resultMap.put("rows", userList.getList());
        return resultMap;
    }

}
