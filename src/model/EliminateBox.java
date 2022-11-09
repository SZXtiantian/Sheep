package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
/**
 * 
* @Description
* @author TimTim Email:754595995@qq.com
* @version
* @date 2022年11月5日下午4:06:19
*
 */
public class EliminateBox {
	private static List<Brand> slot = new ArrayList<>();
	
	public void addSlot(Brand brand) {
		slot.add(brand);	
		slot.sort(Comparator.comparing(Brand::getName));//按牌名字排序
		
		Map<String, List<Brand>> map = slot.stream().collect(Collectors.groupingBy(Brand::getName));//获取牌的名称
		Set<String> key = map.keySet();
		for (String s : key) {
			List<Brand> brands = map.get(s);
			if (brands.size()==3) {
				
				deleteByBrandName(s);
				break;
			}
		}
		paint();
		over(brand);
	}
	
	void paint(){
		for (int i = 0; i < slot.size(); i++) {
			Brand brand = slot.get(i);
			int x = i * brand.getWidth() + 10;
			brand.setBounds(x, 600, 50, 50);
		}
	}
	
	void deleteByBrandName(String name){
		Iterator<Brand>iterator = slot.iterator();
		while(iterator.hasNext()){
			Brand next = iterator.next();
			if (next.getName().equals(name)) {
				next.getParent().remove(next);
				iterator.remove();
			}
		}
	}
	void over(Brand brand){
		if (slot.size() >= 7) {
			JOptionPane.showMessageDialog(brand, "You lose!Game Over");
		}
	}
}
