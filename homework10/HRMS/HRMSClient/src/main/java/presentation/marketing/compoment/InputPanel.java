package presentation.marketing.compoment;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputPanel extends MJPanel{

	private static final long serialVersionUID = 1L;
	private Font font=new Font("楷体",Font.ITALIC,20);
	private Font font2=new Font("楷体",Font.ITALIC,18);
	private Icon inputIcon=new ImageIcon("./src/main/resource/picture/marketing/yearBackground.png");
	private JTextField valueField=new MJTextField(14,0,40,40,font2);

	public InputPanel(String text,int x, int y, int w, int h) {
		super(x, y, w, h);
		JLabel inputLabel=new MJLabel(text,0,0,105,50,font);
		JLabel valueLabel;
		if(text.length()==2)
			valueLabel=new MJLabel(90,5,100,50,inputIcon);
		else if(text.length()==5)
			valueLabel=new MJLabel(125,5,100,50,inputIcon);
		else
		    valueLabel=new MJLabel(110,5,100,50,inputIcon);

		valueLabel.add(valueField);
		this.add(inputLabel);
		this.add(valueLabel);
	}

	public  void setInput(double dis){
		valueField.setText(""+dis);
	}

	public double getInput(){
		return Double.parseDouble(valueField.getText());
	}
}
