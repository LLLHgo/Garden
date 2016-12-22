package presentation.client.compoment;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WelPanel extends JPanel{
	private ImageIcon imageIcon = null;
public WelPanel(){
	imageIcon = new ImageIcon("image/WelPanel.png");
	this.setOpaque(false);
    //this.setLayout(null);
    this.setSize(704, 502);
    //this.setBounds(277,80,704, 502);
    this.setVisible(false);

}
@Override
public void paintComponent(Graphics g) {
	    g.drawImage(imageIcon.getImage(), 0, 0, this);
	    super.paintComponents(g);
	   }
}
