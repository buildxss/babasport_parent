package cn.xss.core.service;

import cn.xss.core.pojo.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品品牌服务接口
 * Created by IntelliJ IDEA
 * User: Administrator
 * Date: 2017/10/22
 * Time: 0:26
 */
@Repository
public interface BrandService {
    /**
     * 根据条件查询
     *
     * @param brand
     * @return
     */
    List<Brand> findByExample(Brand brand);
}
