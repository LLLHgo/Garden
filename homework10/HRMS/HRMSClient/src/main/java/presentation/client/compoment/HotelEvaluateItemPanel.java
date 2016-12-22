package presentation.client.compoment;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class HotelEvaluateItemPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private evaluateButton eb;
	private viewButton vb;

public HotelEvaluateItemPanel(){
	imageIcon = new ImageIcon("image/hotelEvaluatePanel.png");
	eb=new evaluateButton(510, 27);
	vb=new viewButton(450, 30);

    this.setLayout(null);
	this.setSize(600,100);
	this.add(vb);
	this.add(eb);
	this.setOpaque(false);
	this.setVisible(true);
}
@Override
public void paintComponent(Graphics g) {
	    g.drawImage(imageIcon.getImage(), 0, 0, this);
	    super.paintComponents(g);
	   }
}

