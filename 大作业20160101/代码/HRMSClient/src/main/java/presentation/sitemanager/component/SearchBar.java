package presentation.sitemanager.component;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * 搜索框类
 * @author yilu
 *
 */
public class SearchBar extends JLabel{
	int x;
	int y;
	ImageIcon imageIcon;
	
	private static final long serialVersionUID = 1L;

	public SearchBar(int x,int y){
		super();
	
		this.x=x;
		this.y=y;
		setOthers();
	}
	
	void setOthers(){
		imageIcon=new ImageIcon(this.getClass().getResource("image/SearchBar.png"));
		this.setIcon(imageIcon);
		this.setBounds(this.x,this.y,imageIcon.getIconWidth(),imageIcon.getIconHeight());
		//this.setFont(new java.awt.Font("微软雅黑",  1,  20));
		//this.setForeground(Color.black);
		//this.setText(this.name);
		this.setOpaque(false);
	}
}
