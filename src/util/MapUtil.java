package util;

import java.awt.Container;
import java.awt.Rectangle;


import model.Brand;
import model.Cell;
import model.Layer;
import model.Map;

public class MapUtil {
	public static Map build(Integer floorHeight) {
		Map map = new Map();
		map.setFloorHeight(floorHeight);
		Layer layer1 = LayerUtil.build(3, 3);
/*		Layer layer2 = LayerUtil.build(3, 3);
		Layer layer3 = LayerUtil.build(3, 3);*/
		
		layer1.setOffsetx(30);
/*		layer2.setOffsetx(20);
		layer3.setOffsetx(10);*/
		
		//图层链式关系
		layer1.setParent(null);
/*		layer2.setParent(layer1);
		layer3.setParent(layer2);*/
		
		map.getList().add(layer1);
/*		map.getList().add(layer2);
		map.getList().add(layer3);*/
		return map;
	}
	
	
	//true 有交集
	//false 没有交集
	public static boolean compare(Brand brand, Layer layer) {
		Cell [][]cells = layer.getCells();
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				Cell cell = cells[row][col];
				if (cell.getState() == 1) {
					//单元格有牌
					Rectangle temp = cell.getBrand().getBounds();
					
					Rectangle rect = brand.getBounds();
					
					//两个矩阵是否交集
					boolean result = rect.intersects(temp);
					if (result) {
						return result;						
					}				
				}
			}			
		}
		if (layer.getParent() != null) {
			return compare(brand, layer.getParent());
		}else{
			return false;
		}		
	}
	public static boolean compare1(Brand brand , Layer layer){

        for (int j = 0; j < layer.getCapacity(); j++) {

            Cell  cell = layer.getIndex(j);
            if(cell.getState()==1){
                Brand temp =cell.getBrand();
                boolean  flag=brand.getBounds().intersects(temp.getBounds());

                if (flag){
                    // 说明被遮盖了。  只要有一个元素相交就是被遮盖啦。
                    return flag;
                }
            }


        }

        // 当整个for循环都结束。 说明 当前的牌和 上层的图层没有相交
        //  应该和 上层图层的 上层图层继续 比较
        if(layer.getParent()==null){
            // 说明没有上层图层啦， 都比较完毕。  没有被遮盖

            return false;
        }else{
            return compare1(brand, layer.getParent());
        }

    }
	
    public static boolean compare2(Container container, Brand brand , Layer layer){

        for (int j = 0; j < layer.getCapacity(); j++) {

            Cell  cell = layer.getIndex(j);
            if(cell.getState()==1){
                Brand temp =cell.getBrand();
                boolean  flag=brand.getBounds().intersects(temp.getBounds());

                if (flag){
                    // 说明被遮盖了。  只要有一个元素相交就是被遮盖啦。
                    return flag;
                }
            }


        }

        // 当整个for循环都结束。 说明 当前的牌和 上层的图层没有相交
        //  应该和 上层图层的 上层图层继续 比较
        if(layer.getParent()==null){
            // 说明没有上层图层啦， 都比较完毕啦。  没有被遮盖

            return false;
        }else{
            return compare2(container, brand, layer.getParent());
        }

    }
}
