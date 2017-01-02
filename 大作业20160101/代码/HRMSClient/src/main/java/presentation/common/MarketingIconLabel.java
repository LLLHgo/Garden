package presentation.common;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * 网站营销人员头像
 * @author yilu
 *
 */
public class MarketingIconLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	int w;
	int h;
	ImageIcon img;
	public MarketingIconLabel(int x,int y){
		super();
		this.x=x;
		this.y=y;
		setOthers();
	}
	void setOthers(){
		img=new ImageIcon(this.getClass().getResource("image/marketing.png"));
		this.setIcon(img);
		this.w=img.getIconWidth();
		this.h=img.getIconHeight();
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setOpaque(false);
		this.setVisible(true);
	}
}
