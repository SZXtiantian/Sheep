package model;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;


import view.Start;

/**
 * 
* @Description 一个牌
* @author TimTim Email:754595995@qq.com
* @version
* @date 2022年11月4日下午5:28:58
*
 */
public class Brand extends Component{


	private static final long serialVersionUID = 1L;
	//牌名
	private String name;	
	//是否置灰
	private Boolean isGray;	
	//正常图
	private Image image;	
	//灰图
	private Image grayImage;	
	private Integer x;	
	private Integer y;	
	@SuppressWarnings("unused")
	private Integer wigth;	
	@SuppressWarnings("unused")
	private Integer height;
	EliminateBox eliminateBox = new EliminateBox();
	private Cell cell;
	@Override
	public String getName() {
		return name;
	}

//	public Brand(String name, int num){
//		this.name = name;
//		
//		this.image = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
//		
//		this.isGray = false;
//		this.wigth = 50;
//		this.height = 50;
//		
//		this.x = 0;
//		this.y = 0;
//		cell.setState(num);
//		
//	}
	// 对应img下图片的前缀
	public Brand(String name, boolean t){
		this.name = name;
		this.image = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
		this.grayImage = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
		
		this.isGray = true;
		this.wigth = 50;
		this.height = 50;
		
		this.x = 0;
		this.y = 0;
	}
	public Brand(String name){
		this.name = name;
		
		this.image = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+".png");
		this.grayImage = Toolkit.getDefaultToolkit().getImage("imgs\\"+name+"_gray.png");
		
		this.isGray = false;
		this.wigth = 50;
		this.height = 50;
		
		this.x = 0;
		this.y = 0;
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			//点一下鼠标（监听）响应才会执行
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				System.out.println("Brand.mouseClick!");
				Brand brand = (Brand)e.getSource();//获取当前组件
				
				if (brand.getIsGray()) {
					//灰色
					return;
				}else{
					//删除组件，还要删除数据模型当中数据和对应状态
					// brand.getParent().remove(brand);
					eliminateBox.addSlot(brand);
					if (cell.getState() != 2) {
						cell.setState(0);
						cell.setBrand(null);
					}
					
					
					//有待修改
					//TestRenderMap.map.compareAll();
					
					Start.map.compareAll();
					if (Start.map.isEmpty()) {
						JOptionPane.showMessageDialog(null, "You win!!!");
					}
				}
				
				//brand.getParent().remove(brand);//调用上层容器删掉自己（树型多用此结构）
			}
		});
	}
	
	
	@Override
	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
		if (this.isGray == true) {
			//绘制灰色
			g.drawImage(this.grayImage, this.x, this.y, null);
		}else{
			//绘制正常图片
			g.drawImage(this.image, this.x, this.y, null);
		}
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsGray() {
		return isGray;
	}
	public void setIsGray(Boolean isGray) {
		this.isGray = isGray;
	}
	public java.awt.Image getImage() {
		return image;
	}
	public void setImage(java.awt.Image image) {
		this.image = image;
	}
	public java.awt.Image getGrayImage() {
		return grayImage;
	}
	public void setGrayImage(java.awt.Image grayImage) {
		this.grayImage = grayImage;
	}
/*	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getWigth() {
		return wigth;
	}
	public void setWigth(Integer wigth) {
		this.wigth = wigth;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	*/
	public Cell getCell() {
		return cell;
	}


	public void setCell(Cell cell) {
		this.cell = cell;
	}
}
