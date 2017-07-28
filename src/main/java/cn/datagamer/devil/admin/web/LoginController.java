package cn.datagamer.devil.admin.web;

import cn.datagamer.devil.admin.bean.SysUser;
import cn.datagamer.devil.admin.service.ISysUserService;
import cn.datagamer.devil.admin.util.Md5Util;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆逻辑
 *
 * @author Devil
 * @date 2017-07-28 09:53
 */
@Controller
public class LoginController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, String account, String password) {
        SysUser user = new SysUser();
        user.setAccount(account);
        user.setHashedPassword(Md5Util.compute(password));
        user.setPageStart(1);
        user.setPageSize(1);
        PageInfo<SysUser> pageList = sysUserService.findList(user);
        Map<String, Object> resultMap = new HashMap<>();
        if (CollectionUtils.isEmpty(pageList.getList())) {
            resultMap.put("data", null);
            resultMap.put("code", 2);
        } else {
            resultMap.put("data", pageList);
            resultMap.put("code", 1);
        }
        return resultMap;
    }
}
