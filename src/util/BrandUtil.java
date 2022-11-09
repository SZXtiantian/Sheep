package util;

import java.util.Random;

import model.Brand;

public class BrandUtil {
	public static Random random = new Random();

	public static String[] brandNames = { "叉子", "剪刀", "刷子", "玉米", "火", "苹果","胡萝卜", "球", "手套", "肉腿", "铃铛", "水桶"};
	

	// 随机获取一个牌名称
	public static String getBrandName() {
		int randomIndex = random.nextInt(brandNames.length);
		return brandNames[randomIndex];
	}
	public static Brand[] buildBrands(Integer capacity) {
		Brand[] brands = new Brand[capacity];
		for (int i = 0; i < brands.length; i+=3) {
			String randomBrandName = getBrandName();
			Brand brand1 = new Brand(randomBrandName);
			Brand brand2 = new Brand(randomBrandName);
			Brand brand3 = new Brand(randomBrandName);
			brands[i] = brand1;
			brands[i + 1] = brand2;
			brands[i + 2] = brand3;		
		}	
		for (int i = 0; i < brands.length; i++) {
			//获取当前位置变量A
			Brand brandA = brands[i];
			//交换位置B的索引
			int randomIndex = random.nextInt(brands.length);
			Brand brandB = brands[randomIndex];
			Brand temp = brandA;
			
			brands[i] = brandB;
		//	brandA = brandB;
			brands[randomIndex] = temp;
		}
		return brands;
	}
}
