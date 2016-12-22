package presentation.marketing.compoment;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class SelectPanel extends MJPanel{
	private static final long serialVersionUID = 1L;
	private Font font=new Font("楷体",Font.ITALIC,20);
	private JComboBox<String> dbtype = new JComboBox<String>();
	public SelectPanel(String text,int x, int y, int w, int h,List<String> list) {
		super(x, y, w, h);
		JLabel districtLabel=new MJLabel(text,0,50,105,50,font);

		dbtype.setBounds(105,30,315,100);
		for(String s:list){
		    dbtype.addItem(s);;
		}

		this.add(districtLabel);
		this.add(dbtype);

	}

	public String getName(){
		return dbtype.getSelectedItem().toString();

	}
}
