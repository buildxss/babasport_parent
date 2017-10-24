package cn.xss.core.dao;

import java.util.List;

import cn.xss.core.pojo.Brand;

/**
 * 商品品牌管理DAO
 * @author Administrator
 *
 */
public interface BrandDAO {
	
	/**
	 * 根据条件查询商品品牌
	 * @param brand
	 * @return
	 */
	List<Brand> findByExample(Brand brand);

	/**
	 * 根据id查询商品品牌
	 * @param brandId
	 * @return
	 */
	Brand findBrandById(Integer brandId);

	/**
	 * 修改商品品牌信息
	 * updateBrand
	 * @param brand
	 */
	void updateBrand(Brand brand);
}
