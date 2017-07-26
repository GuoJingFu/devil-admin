package cn.datagamer.devil.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.datagamer.devil.admin.bean.SysUser;
import cn.datagamer.devil.admin.service.ISysUserService;

/**
 * @author Devil
 * @mail 562157205@qq.com
 * @date 2017年6月4日 下午4:19:57
 */
@Controller
public class HelloController {
    
    @Autowired
    private ISysUserService sysUserService;
    
    @RequestMapping("/") //注意：spring-boot默认查找静态文件是从"/"目录找，所以不能@RequestMapping这样配置
    public String index(Model model) {
        model.addAttribute("hello", "Devil");
        return "index";
    }
    
    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String greeting() {
        return "Hello World!";
    }

    @RequestMapping("/helloHtml")  
    public String helloHtml(Model model) {
       model.addAttribute("title", "Hello World!");
       model.addAttribute("hello", "Dear");
       return "hello";  
    }  
    
    @RequestMapping("/helloFromDataBase")  
    public String helloFromDataBase(Model model) {
        SysUser searchModel = new SysUser();
        searchModel.setPageStart(1);
        searchModel.setPageSize(1);
        PageInfo<SysUser> userList = sysUserService.findList(searchModel);
        if (!CollectionUtils.isEmpty(userList.getList())) {
            SysUser user = userList.getList().get(0);
            model.addAttribute("hello", user.getName());
            model.addAttribute("title", user.getAccount());
        }
        return "hello";  
    }  
}
