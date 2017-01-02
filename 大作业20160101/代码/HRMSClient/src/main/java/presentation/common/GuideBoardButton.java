package presentation.common;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
/**
 * 导航栏按钮
 * @author yilu
 *
 */
public class GuideBoardButton extends JButton{

	private static final long serialVersionUID = 1L;
	int x=40;
	int y;
	int w=194;
	int h=46;
	String name;
	JButton button;

	public GuideBoardButton(int y,String name){
		super();

		this.y=y;
		this.name=name;
		button=this;
		this.addMouseListener(new mouseListener());
		setOthers();
	}

	private void setOthers(){
		this.setBounds(this.x,this.y,this.w,this.h);
		this.setText(name);
		this.setFont(new java.awt.Font("微软雅黑", 4,  25));
		this.setForeground(Color.white);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setVisible(true);

	}
private class mouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		button.setBounds(x+3,y+3,w,h);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		button.setBounds(x,y,w,h);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		button.setForeground(Color.GRAY);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		button.setForeground(Color.WHITE);
	}

}
}
