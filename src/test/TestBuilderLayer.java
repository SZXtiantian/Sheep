package test;

import java.util.Random;

import model.Brand;
import model.Cell;
import model.Layer;

public class TestBuilderLayer {
	public static Random random = new Random();
	
	public static String[] brandNames = {
		"叉子","剪刀","刷子","玉米","火"
	};
	
	//随机获取一个牌名称
	public static String getBrandName(){
		int randomIndex = random.nextInt(brandNames.length);
		return brandNames[randomIndex];
	}
	public static void main(String[] args) {
		Layer layer = null;
		try {
			layer = new Layer(6,  6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(getBrandName());
		Brand[] brands = new Brand[layer.getCapacity()];
		/*for (int i = 0; i < brands.length; i++) {
			String randomBrandName = getBrandName();
			Brand brand = new Brand(randomBrandName);
			brands[i] = brand;
			
		}*/
		//解决凑不够三张牌的问题
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
			System.out.print (brands[i].getName() + "-");			
		}
		System.out.println();
		System.out.println("-------------------------------------------------");
		for (int i = 0; i < brands.length; i++) {
			//获取当前位置变量A
			Brand brandA = brands[i];
			//交换位置B的索引
			int randomIndex = random.nextInt(brands.length);
			Brand brandB = brands[randomIndex];
			Brand temp = brandA;
			
			brands[i] = brandB;
			brands[randomIndex] = temp;
		}
		System.out.println();
		System.out.println("-------------------------------------------------");
		for (int i = 0; i < brands.length; i++) {
			System.out.print (brands[i].getName() + "-");			
		}
		System.out.println();
		System.out.println("-------------------------------------------------");
		Cell[][] cells = layer.getCells();
		
		
		int flag = 0;
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				System.out.println(row + "-"+ col);
				
				Cell cell = new Cell();
				cell.setState(1);
				cell.setBrand(brands[flag++]);
				
				cells[row][col] = cell;//将之前空的图层设置值
			}
		}
		System.out.println();
		System.out.println("-------------------------------------------------");
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				Brand brands1 = cells[row][col].getBrand();
				System.out.print(brands1.getName()+"-");
			}
			System.out.println();
		}
	}
}
