package cn.xss.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA
 * User: Administrator
 * Date: 2017/10/21
 * Time: 19:33
 */
@Controller
public class CenterAction {

    @RequestMapping(value = "/console/{pageName}.do")
    public String consoleShow(@PathVariable(value = "pageName") String pageName) {
        System.out.println("consoleShow...");
        return pageName;
    }

    @RequestMapping(value = "/console/frame/{pageName}.do")
    public String consoleFrameShow(@PathVariable(value = "pageName") String pageName) {
        System.out.println("consoleProductShow...");
        return "frame/" + pageName;
    }

    @RequestMapping(value = "/console/product/{pageName}.do")
    public String consoleProductShow(@PathVariable(value = "pageName") String pageName) {
        System.out.println("consoleProductShow...");
        return "product/" + pageName;
    }

}
