package cn.xss.core.service;

import cn.xss.core.pojo.Brand;
import cn.xss.core.tools.PageHelper;
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
     * 根据条件查询商品品牌
     *
     * @param brand
     * @return
     */
    List<Brand> findByExample(Brand brand);

    /**
     * 分页查询商品品牌
     * @param brand
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageHelper.Page<Brand> findByExample(Brand brand, Integer pageNum, Integer pageSize);

    /**
     * 根据id查询商品品牌
     * @param brandId
     * @return
     */
    Brand findBrandById(Integer brandId);

    /**
     * 修改商品品牌信息
     * @param brand
     */
    void updateBrand(Brand brand);

}
