package presentation.sitemanager.component;

import java.awt.Color;

import javax.swing.JLabel;

public class MyLabel extends JLabel{
	
	int x;
	int y;
	int w;
	int h;
	String name;
	
	private static final long serialVersionUID = 1L;

	public MyLabel(int x,int y,int w,int h,String name){
		super();
	
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.name=name;
		
		setOthers();
	}
	
	void setOthers(){
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setFont(new java.awt.Font("华文黑体",  1,  20));
		this.setForeground(Color.white);
		this.setText(this.name);
		this.setOpaque(false);
	}
}
