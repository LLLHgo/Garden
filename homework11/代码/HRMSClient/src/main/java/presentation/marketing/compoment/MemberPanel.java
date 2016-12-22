package presentation.marketing.compoment;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import Enum.VIPType;

public class MemberPanel extends MJPanel {

	private static final long serialVersionUID = 1L;
	private Font font=new Font("楷体",Font.ITALIC,20);
	private JRadioButton ordinary=new MJRadioButton("普通会员",false,100,0,112,50,font);
	private JRadioButton enterprise=new MJRadioButton("企业会员",false,240,0,112,50,font);
	private List<VIPType> buttons=new ArrayList<VIPType>();

	public MemberPanel(String text,int x, int y, int w, int h) {
		super(x, y, w, h);
		JLabel label=new MJLabel(text,0,0,100,50,font);
		this.add(label);
		this.add(ordinary);
		this.add(enterprise);
	}

	public MemberPanel(String text,int x, int y, int w, int h,List<String> list) {
		super(x, y, w, h);
		JLabel label=new MJLabel(text,0,0,100,50,font);
		this.add(label);
		int num=0;
		for(String s:list){
			MJRadioButton button=new MJRadioButton(s,false,100+num*100,0,112,50,font);
			num++;
			this.add(button);
		}
	}

	public List<VIPType> getSelections(){
		if(ordinary.isSelected())
			buttons.add(VIPType.ORDINARYVIP);
		if(enterprise.isSelected())
			buttons.add(VIPType.ENTERPRISEVIP);
		return buttons;
	}

}
