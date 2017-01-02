package presentation.client.compoment;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * 初始欢迎界面类
 * @author ClaraLee
 *
 */
public class WelPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private ImageIcon imageIcon = null;
public WelPanel(){
	imageIcon = new ImageIcon(this.getClass().getResource("image/WelPanel.png"));
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
