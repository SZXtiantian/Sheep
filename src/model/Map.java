package model;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

//import javax.swing.JOptionPane;

import util.MapUtil;

/**
 * 
 * @Description 一个地图，下有多个图层， 层层覆盖
 * @author TimTim Email:754595995@qq.com
 * @version
 * @date 2022年11月4日下午9:29:54
 *
 */
public class Map {
	private Integer floorHeight;

	private List<Layer> list = new ArrayList<>();


	public Integer getFloorHeight() {
		return floorHeight;
	}

	public void setFloorHeight(Integer floorHeight) {
		this.floorHeight = floorHeight;
	}

	public List<Layer> getList() {
		return list;
	}

	public void setList(List<Layer> list) {
		this.list = list;
	}

	public boolean isEmpty() {
		Layer layer = list.get(list.size() - 1);
		Cell[][] cells = layer.getCells();
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				Cell cell = cells[row][col];
				if (cell.getState() == 1) {
					return false;
				}
			}
		}
		return true;
	}
	/*
	 * 性能会差， 牌多 1、开始时调用 2、牌点击后调用
	 */
	public void compareAll() {
		for (int i = 1; i < list.size(); i++) {
			Layer layer = list.get(i);
			Cell[][] cells = layer.getCells();

			for (int row = 0; row < cells.length; row++) {
				for (int col = 0; col < cells[row].length; col++) {
					Cell cell = cells[row][col];
					if (cell.getState() == 1) {
						Brand brand = cell.getBrand();
						boolean result = MapUtil.compare1(brand, layer.getParent());
						brand.setIsGray(result);
					}
				}
			}
		}
		//JOptionPane.showMessageDialog(null, "You lose!Game Over");
		/*for (int i = 1; i < list.size(); i++) {
			if (list.size() == 1) {
				Layer layer = list.get(1);
				Cell[][] cells = layer.getCells();
				for (int row = 0; row < cells.length; row++) {
					for (int col = 0; col < cells[row].length; col++) {
						if (cells[row][col] != null) {
							return;
						}
					}
				}
				JOptionPane.showMessageDialog(null, "You lose!Game Over");
			}
		}*/
	}
	
	public void compareAll(Container container) {
		for (int i = 1; i < list.size(); i++) {
			Layer layer = list.get(i);
			Cell[][] cells = layer.getCells();

			for (int row = 0; row < cells.length; row++) {
				for (int col = 0; col < cells[row].length; col++) {
					Cell cell = cells[row][col];
					if (cell.getState() == 1) {
						Brand brand = cell.getBrand();
						boolean result = MapUtil.compare2(container, brand, layer.getParent());
						brand.setIsGray(result);
					}
				}
			}
		}
		
	}
	public void compareAll1(Container container) {
		List<Layer> list1= this.getList();
		for (int i = 1; i < list1.size(); i++) {
			Layer layer = list1.get(i);

			for (int j = 1; j < list1.size(); j++) {
				for (int k = 0; k < layer.getCapacity(); k++) {
					Cell cell = layer.getIndex(j);
					if (cell.getState() == 1) {
						Brand brand = cell.getBrand();
						boolean result = MapUtil.compare2(container, brand, layer.getParent());
						brand.setIsGray(result);
					}
				}
			}
		}
	}

}
