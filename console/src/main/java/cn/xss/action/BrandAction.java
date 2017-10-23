package cn.xss.action;

import cn.xss.core.pojo.Brand;
import cn.xss.core.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Administrator
 * Date: 2017/10/22
 * Time: 0:41
 */
@Controller
public class BrandAction {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/console/brand/{pageName}.do")
    public String consoleBrandShow(@PathVariable(value = "pageName") String pageName, Brand brand, Model model) {
        List<Brand> brandList = brandService.findByExample(brand);
        model.addAttribute("brandList", brandList);
        model.addAttribute("name", brand.getName());
        model.addAttribute("isDisplay", brand.getIsDisplay());
        return "/brand/" + pageName;
    }
}
