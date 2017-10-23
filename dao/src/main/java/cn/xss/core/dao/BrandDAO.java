package cn.xss.core.dao;

import cn.xss.core.pojo.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品品牌DAO
 * Created by IntelliJ IDEA
 * User: Administrator
 * Date: 2017/10/21
 * Time: 22:38
 */
@Repository
public interface BrandDAO {

    /**
     * 根据条件查询商品品牌
     *
     * @param brand
     * @return
     */
    public List<Brand> findByExample(Brand brand);

}
