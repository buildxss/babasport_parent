package cn.xss.core.service;

import cn.xss.core.pojo.Brand;
import cn.xss.core.dao.BrandDAO;
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
        System.out.println("hello world");
        List<Brand> brandList = brandDAO.findByExample(brand);
        return brandList;
    }
}
