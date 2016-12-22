package presentation.sitemanager.component;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyTextField extends JTextField{
	
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	int w;
	int h;
	String info;
	public MyTextField (int x,int y,int w,int h,String info){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.info=info;
		
		setOthers();
	}
	void setOthers(){
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setFont(new java.awt.Font("华文黑体",  1,  20));
		this.setForeground(Color.DARK_GRAY);
		this.setText(info);
		this.setBackground(null);
		//this.setBorder(new EmptyBorder(0,0,0,0));
		this.setOpaque(false);
		this.setEditable(false);
	}
}
