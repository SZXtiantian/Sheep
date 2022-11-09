package test;

import javax.swing.JFrame;

import model.Brand;
import model.Cell;
import model.Layer;
import util.LayerUtil;

/**
 * 
 * @Description 测试渲染一个图层的数据
 * @author TimTim Email:754595995@qq.com
 * @version
 * @date 2022年11月4日下午9:13:27
 *
 */
public class TestRenderLayer extends JFrame {

	private static final long serialVersionUID = 1L;
	private Layer layer = LayerUtil.build(6, 6);

	public TestRenderLayer() {
		// 初始化窗口基本信息
		init();
		// 渲染图层
		renderLayer();
		// 自动刷新
		autoRefresh();
	}
	public void renderLayer() {
		Cell[][] cells = layer.getCells();
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				Brand brands1 = cells[row][col].getBrand();
				//System.out.print(brands1.getName()+"-");
				int x = col *50;
				int y = row *50;
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
		this.setTitle("羊了个羊");// 标题
		this.setSize(450, 800); // 窗口大小		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 退出页面终止进程
		this.setLocationRelativeTo(null);// 居中
		// 设置绝对布局
		this.setLayout(null);
		this.setBounds(0, 0, 450, 800);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestRenderLayer();
	}
}
