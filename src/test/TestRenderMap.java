package test;

import java.awt.Color;
import java.awt.Container;
import java.util.List;

import javax.swing.JFrame;


import model.Brand;
import model.Cell;
import model.Layer;
import model.Map;
import util.MapUtil;

public class TestRenderMap extends JFrame{
	private static final long serialVersionUID = 1L;
	public static Map map = MapUtil.build(3);

	public TestRenderMap() {
		// 初始化窗口基本信息
		init();
		// 渲染图层
		List<Layer> list = map.getList();
		for (int i = 0; i < list.size(); i++) {
			renderLayer(this.getContentPane(), list.get(i));
		}
		map.compareAll();
		// 自动刷新
		autoRefresh();
	}
	private void renderLayer(Container container, Layer layer) {
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
	// 自动刷新,就是隔一段时间，拽一下窗口
	private void autoRefresh() {
		JFrame start = this;
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					start.repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	private void init() {
		this.setTitle("羊了个羊");// 标题
		this.setSize(450, 800); // 窗口大小
		this.getContentPane().setBackground(Color.GREEN);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 退出页面终止进程
		this.setVisible(true);
		// 设置绝对布局
		this.setLayout(null);
		this.setBounds(0, 0, 450, 800);
		this.setLocationRelativeTo(null);// 居中
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new TestRenderMap(); 
	}
}
