package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewOrderPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private SearchButton searchButton;
	private JTextField searchField;
	private Button unfin;
	private Button fin;
	private Button abnormal;
	private Button repeal;

public ViewOrderPanel(){
	imageIcon = new ImageIcon("image/searchPanel.png");
	searchButton=new SearchButton();
	searchField=new JTextField();
	searchField.setBounds(72, 18, 450, 50);
	searchField.setBorder(new EmptyBorder(0,0,0,0));
	searchField.setFont(new java.awt.Font("微软雅黑", 4,  25));
	searchField.setForeground(Color.WHITE);
	searchField.setOpaque(false);
	searchField.setFocusable(true);
		unfin=new Button(100,"未执行");
		fin=new Button(170,"已执行");
		abnormal=new Button(240,"异常");
		repeal=new Button(310,"已撤销");
		this.setLayout(null);
	    this.setSize(704, 502);
	    this.setOpaque(false);
	    this.add(searchField);
	    this.add(searchButton);
	    this.add(unfin);
	    this.add(fin);
	    this.add(abnormal);
	    this.add(repeal);
	    this.setVisible(false);
}
@Override
public void paintComponent(Graphics g) {
	    g.drawImage(imageIcon.getImage(), 0, 0, this);
	    super.paintComponents(g);

	   }



	class Button extends JButton{

		private static final long serialVersionUID = 1L;
		int x=0;
		int y;
		int w=150;
		int h=40;
		String name;

		public Button(int y,String name){
			super();

			this.y=y;
			this.name=name;

			setOthers();
		}

		private void setOthers(){
			this.setBounds(this.x,this.y,this.w,this.h);
			this.setText(name);
			this.setFont(new java.awt.Font("微软雅黑", 4,  20));
			this.setForeground(Color.white);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setVisible(true);

		}
	}
}
