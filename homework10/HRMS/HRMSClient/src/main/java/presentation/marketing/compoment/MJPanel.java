package presentation.marketing.compoment;

import javax.swing.JPanel;

public class MJPanel extends JPanel{
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MJPanel(int x,int y,int w,int h){
    	this.setBounds(x, y, w, h);
    	this.setLayout(null);
    	this.setOpaque(false);
    }
}
