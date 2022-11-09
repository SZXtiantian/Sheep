package util;

import javax.swing.JFrame;

import model.Brand;
import model.Cell;
import model.Layer;

public class LayerUtil {	
	public static Layer build(Integer rowNum, Integer colNum){
		Layer layer = null;
		try {
			layer = new Layer(rowNum, colNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Brand[] brands = BrandUtil.buildBrands(layer.getCapacity());		
		Cell[][] cells = layer.getCells();
		
		int flag = 0;
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				System.out.println(row + "-"+ col);
				Brand brands1 = brands[flag++];
				Cell cell = new Cell();
				cell.setState(1);
				cell.setBrand(brands1);
				
				brands1.setCell(cell);
				
				cells[row][col] = cell;//将之前空的图层设置值
			}
		}
		return layer;
	}
	public static void renderLayer(Layer layer, JFrame jframe) {
		Cell[][] cells = layer.getCells();
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				Brand brands1 = cells[row][col].getBrand();
				//System.out.print(brands1.getName()+"-");
				int x = col *50;
				int y = row *50;
				brands1.setBounds(x, y, 50, 50);
				jframe.getContentPane().add(brands1);
			}
			System.out.println();
		}
	}
}
