package view;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;

import model.Brand;
import model.Cell;
import model.Layer;
import model.Map;
import util.MapUtil;
/**
 * 
* @Description 游戏启动入口
* @author TimTim Email:754595995@qq.com
* @version
* @date 2022年11月4日下午5:23:13
*
 */

public class Start extends JFrame{

	private static final long serialVersionUID = 1L;
	public static Map map = MapUtil.build(1);

	private Brand background = new Brand("背景草地", true);
	private Brand eliminateBox = new Brand("消除区域", true);	
	public Start() {
		// 初始化窗口基本信息
		
		init();
		// 渲染图层
		List<Layer> list = map.getList();
		for (int i = 0; i < list.size(); i++) {
			renderLayer(list.get(i));
		}
		//background.getCell().setState(2);
		eliminateBox.setBounds(0, 575, 450, 800);
		this.getContentPane().add(eliminateBox);
		background.setBounds(0, 0, 450, 800);
		this.getContentPane().add(background);
		
		map.compareAll();
		// 自动刷新		
		autoRefresh();
	}
	private void renderLayer(Layer layer) {
		Cell[][] cells = layer.getCells();
		layer.showCells();
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				Brand brands1 = cells[row][col].getBrand();
				//System.out.print(brands1.getName()+"-");
				int x = col *50 + layer.getOffsetx();
				int y = row *50 + layer.getOffsety();
				brands1.setBounds(x, y, 50, 50);
				this.getContentPane().add(brands1);
			}
			System.out.println();
		}
	}
	/**
	 * 
	* @Description 	自动刷新,就是隔一段时间，拽一下窗口
	* @author TimTim
	* @date 2022年11月9日下午2:31:39
	 */
	private void autoRefresh() {
		JFrame start = this;
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					start.repaint();
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	private void init() {
		// 标题
		this.setTitle("羊了个羊");
		// 窗口大小
		this.setSize(450, 800); 
		this.getContentPane().setBackground(Color.GREEN);
		// 退出页面终止进程
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		// 设置绝对布局
		this.getLayeredPane().setLayout(null);
		
		this.setBounds(0, 0, 450, 800);
		// 居中
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Start(); 
	}
}
