package presentation.client.compoment;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class OrderItemPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private minideleteButton db;
	private viewButton vb;

public OrderItemPanel(){
	imageIcon = new ImageIcon("image/hotelEvaluatePanel.png");
	db=new minideleteButton(500, 7);
	vb=new viewButton(450, 30);

    this.setLayout(null);
	this.setSize(600,100);
	this.add(vb);
	this.add(db);
	this.setOpaque(false);
	this.setVisible(true);
}
@Override
public void paintComponent(Graphics g) {
	    g.drawImage(imageIcon.getImage(), 0, 0, this);
	    super.paintComponents(g);
	   }
}
