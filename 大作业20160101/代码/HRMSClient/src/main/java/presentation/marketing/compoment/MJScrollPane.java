package presentation.marketing.compoment;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class MJScrollPane extends JScrollPane{
	private static final long serialVersionUID = 1L;

	public MJScrollPane(int x,int y,int w,int h,JPanel panel){
		super(panel);
		this.setBounds(x,y,w,h);
	    this.setBorder(new EmptyBorder(0,0,0,0));
	    this.setOpaque(false);
	    this.getViewport().setOpaque(false);
	}


}
