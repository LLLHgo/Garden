package presentation.marketing.compoment;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NamePanel extends MJPanel{
	private static final long serialVersionUID = 1L;
	private Font font=new Font("楷体",Font.ITALIC,20);
	private Font font2=new Font("楷体",Font.ITALIC,18);
	private Icon nameIcon=new ImageIcon(this.getClass().getResource("nameBackground.png"));
	private JTextField valueField=new MJTextField(16,1,300,40,font2);

	public NamePanel(String text,int x, int y, int w, int h) {
		super(x,y,w,h);
		JLabel nameLabel=new MJLabel(text,0,0,105,50,font);
		JLabel valueLabel;
	    valueLabel=new MJLabel(97,5,700,50,nameIcon);
		valueLabel.add(valueField);
		this.add(nameLabel);
		this.add(valueLabel);
	}


	public String getName(){
		return valueField.getText();
	}
}
