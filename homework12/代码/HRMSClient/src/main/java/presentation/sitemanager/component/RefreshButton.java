package presentation.sitemanager.component;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RefreshButton extends JButton{
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	ImageIcon img;
	public RefreshButton(int x,int y){
		super();
		this.x=x;
		this.y=y;
		setOthers();
	}
	void setOthers(){
		img=new ImageIcon("src/main/resource/picture/sitemanager/refreshButton.png");
		this.setIcon(img);
		this.setBounds(this.x,this.y,img.getIconWidth(),img.getIconHeight());
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);
	}
}
