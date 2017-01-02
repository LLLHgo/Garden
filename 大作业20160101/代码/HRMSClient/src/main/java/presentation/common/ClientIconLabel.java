package presentation.common;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * 客户头像
 * @author yilu
 *
 */
public class ClientIconLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	int w;
	int h;
	ImageIcon img;
	public ClientIconLabel(int x,int y){
		super();
		this.x=x;
		this.y=y;
		setOthers();
	}
	void setOthers(){
		img=new ImageIcon(this.getClass().getResource("image/client.png"));
		this.setIcon(img);
		this.w=img.getIconWidth();
		this.h=img.getIconHeight();
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setOpaque(false);
		this.setVisible(true);
	}
}
