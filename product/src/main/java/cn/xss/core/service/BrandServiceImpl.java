package cn.xss.core.service;

import cn.xss.core.pojo.Brand;
import cn.xss.core.dao.BrandDAO;
import cn.xss.core.tools.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User: Administrator
 * Date: 2017/10/22
 * Time: 0:28
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {



    @Autowired
    private BrandDAO brandDAO;

    @Override
    public List<Brand> findByExample(Brand brand) {
        List<Brand> brandList = brandDAO.findByExample(brand);
        System.out.println(brandList.size());
        return brandList;
    }

    @Override
    public PageHelper.Page<Brand> findByExample(Brand brand, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);//开始分页
        brandDAO.findByExample(brand);
        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        return endPage;
    }

    @Override
    public Brand findBrandById(Integer brandId) {
        Brand brand = brandDAO.findBrandById(brandId);
        return brand;
    }

    @Override
    public void updateBrand(Brand brand) {
        brandDAO.updateBrand(brand);
    }


}
