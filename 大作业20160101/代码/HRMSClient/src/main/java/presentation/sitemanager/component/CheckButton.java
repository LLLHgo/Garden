package presentation.sitemanager.component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * 确认按钮
 * @author yilu
 *
 */
public class CheckButton extends JButton{
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	int w;
	int h;
	ImageIcon img;
	public CheckButton(int x,int y,int w,int h){
		super();
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		setOthers();
	}
	void setOthers(){
		img=new ImageIcon(this.getClass().getResource("image/checkIcon.png"));
		this.setIcon(img);
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);
	}
}