package cn.xss.action;

import cn.xss.core.pojo.Brand;
import cn.xss.core.service.BrandService;
import cn.xss.core.tools.PageHelper;
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

    // 品牌 通用映射，当有具体映射时候，只会执行具体映射方法
    @RequestMapping(value = "/console/brand/{pageName}.do")
    public String consoleBrandShow(@PathVariable(value = "pageName") String pageName) {
        return "brand/" + pageName;
    }

    // 显示品牌列表（具体映射）
    @RequestMapping(value = "/console/brand/list.do")
    public String consoleBrandShowList(Model model, Brand brand, Integer pageNum, Integer pageSize) {
        System.out.println("consoleBrandShow...");
        PageHelper.Page<Brand> brandPage = brandService.findByExample(brand, pageNum, pageSize);
        model.addAttribute("brandPage", brandPage);
        model.addAttribute("name", brand.getName());
        model.addAttribute("isDisplay", brand.getIsDisplay());
        return "brand/list";
    }

    @RequestMapping(value = "/console/brand/edit.do")
    public String consoleBrandShowEdit(Model model, Integer brandId) {
        System.out.println("consoleBrandShowEdit...");
        Brand brand = brandService.findBrandById(brandId);
        model.addAttribute("brand", brand);
        return "brand/edit";
    }

    @RequestMapping(value = "/console/brand/doEdit.do")
    public String consoleBrandDoEdit(Model model, Brand brand) {
        System.out.println("consoleBrandDoEdit...");
        System.out.println(brand);
        brandService.updateBrand(brand);
        return "redirect:/console/brand/list.do";
    }
}
