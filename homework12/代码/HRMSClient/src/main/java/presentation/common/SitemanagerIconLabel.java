package presentation.common;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SitemanagerIconLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	int w;
	int h;
	ImageIcon img;
	public SitemanagerIconLabel(int x,int y){
		super();
		this.x=x;
		this.y=y;
		setOthers();
	}
	void setOthers(){
		img=new ImageIcon("src/main/resource/picture/headIcon/sitemanager.png");
		this.setIcon(img);
		this.w=img.getIconWidth();
		this.h=img.getIconHeight();
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setOpaque(false);
		this.setVisible(true);
	}
}
