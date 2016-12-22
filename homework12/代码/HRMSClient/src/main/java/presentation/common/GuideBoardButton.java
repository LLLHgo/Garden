package presentation.common;

import java.awt.Color;

import javax.swing.JButton;

public class GuideBoardButton extends JButton{

	private static final long serialVersionUID = 1L;
	int x=40;
	int y;
	int w=194;
	int h=46;
	String name;

	public GuideBoardButton(int y,String name){
		super();

		this.y=y;
		this.name=name;

		setOthers();
	}

	private void setOthers(){
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setText(name);
		this.setFont(new java.awt.Font("微软雅黑", 4,  25));
		this.setForeground(Color.white);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);

	}
}
