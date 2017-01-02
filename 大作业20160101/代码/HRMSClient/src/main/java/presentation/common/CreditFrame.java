package presentation.common;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import presentation.sitemanager.component.CheckButton;
/**
 * 信用frame
 * @author yilu
 *
 */
public class CreditFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	JPanel creditShowPanel;
	JTextArea creditArea;
	JScrollPane jscrollPane;
	CheckButton checkButton;
	ImageIcon background;
	ArrayList<String> credits;

	public CreditFrame(ArrayList<String> credits){
		this.credits=credits;
		background=new ImageIcon(this.getClass().getResource("image/creditBackground.png"));
		creditShowPanel=new JPanel(){
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g){
				super.paintComponent(g);
				background.setImage(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
				background.paintIcon(this, g, 0, 0);
			}
		};

		creditArea=new JTextArea(10,1);
		creditArea.setFont(new java.awt.Font("华文黑体",  1,  15));
		creditArea.setForeground(Color.white);
		creditArea.setWrapStyleWord(true);
		creditArea.setLineWrap(true);
		creditArea.setOpaque(false);
		creditArea.setEditable(false);
		creditArea.setText("信用值记录"+"\n");

		jscrollPane = new JScrollPane(creditArea);
		jscrollPane.setBounds(10,10,500,300);
		jscrollPane.setOpaque(false);
		jscrollPane.getViewport().setOpaque(false);
		jscrollPane.setBorder(new EmptyBorder(0,0,0,0));

		checkButton=new CheckButton(200,300,65,65);
		checkButton.addMouseListener(new CheckListener());

		creditShowPanel.add(checkButton);
		creditShowPanel.add(jscrollPane);
		creditShowPanel.setLayout(null);
		creditShowPanel.setBounds(0,0,300,380);

		this.getContentPane().add(creditShowPanel);
		this.setResizable(false);
		this.setBounds(580, 250, 300, 380);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		for(int i=credits.size()-1;i>=0;i--){
			creditArea.append(credits.get(i)+"\n");
		}
	}

	class CheckListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			dispose();
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}

	}
}
