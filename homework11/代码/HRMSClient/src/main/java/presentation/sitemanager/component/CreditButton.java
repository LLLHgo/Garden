package presentation.sitemanager.component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CreditButton extends JLabel{
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	ImageIcon img;
	public CreditButton(int x,int y){
		super();
		this.x=x;
		this.y=y;
		setOthers();
	}
	void setOthers(){
		img=new ImageIcon("src/main/resource/picture/sitemanager/creditRecordIcon.png");
		this.setIcon(img);
		this.setBounds(this.x,this.y,img.getIconWidth(),img.getIconHeight());
		this.setVisible(true);
	}
}
