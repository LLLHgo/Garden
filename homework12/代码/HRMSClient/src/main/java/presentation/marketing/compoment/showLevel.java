package presentation.marketing.compoment;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vo.levelVO.LevelVO;

public class showLevel extends MJPanel{
private static final long serialVersionUID = 1L;
private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,20);
private Image background=new ImageIcon("./src/main/resource/picture/marketing/showBackground.png").getImage();
private Icon inputIcon=new ImageIcon("./src/main/resource/picture/marketing/levelIcon.png");
private JTextField levelField;
private JTextField nameField;
private JTextField creditField;
private JTextField discountField;

public showLevel(String name,int level,double credit,double discount,int x, int y, int w, int h) {
	super(x, y, w, h);
    JLabel Name=new MJLabel("等级名称 ",25,10,400,30,font);
    JLabel Level=new MJLabel("等级层次 ",25,55,130,30,font);
    JLabel Credit=new MJLabel("所需信用值 ",25,100,130,30,font);
    JLabel Discount=new MJLabel("折扣 ",25,140,130,30,font);

    JLabel nameLabel=new MJLabel(175,10,200,50,inputIcon);
    JLabel levelLabel=new MJLabel(175,50,200,50,inputIcon);
    JLabel creditLabel=new MJLabel(175,90,200,50,inputIcon);
    JLabel discountLabel=new MJLabel(175,130,200,50,inputIcon);
    levelField=new MJTextField(""+level,17,8,160,30,font);
    nameField=new MJTextField(""+name,17,8,160,30,font);
    creditField=new MJTextField(""+credit,17,8,160,30,font);
    discountField=new MJTextField(""+discount,17,8,160,30,font);
    nameLabel.add(nameField);
    levelLabel.add(levelField);
    creditLabel.add(creditField);
    discountLabel.add(discountField);

    this.add(Name);
    this.add(Level);
    this.add(Credit);
    this.add(Discount);

    this.add(nameLabel);
    this.add(levelLabel);
    this.add(creditLabel);
    this.add(discountLabel);
    this.revalidate();
    this.repaint();
}

protected  void paintComponent(Graphics g) {
	g.drawImage(background,0,0,getSize().width,getSize().height,this);
}

public  LevelVO getLevel() {
	String name=nameField.getText();
	if(name.length()==0)//如果名字一栏为空，则需重新输入
		return null;
	int level = 0;
	double credit=0.0;
	double dis=0.0;
	try{
	    level=Integer.parseInt(this.levelField.getText());
	    dis=Double.parseDouble(this.discountField.getText());
	    credit=Double.parseDouble(this.creditField.getText());
	}catch(NumberFormatException e){
		return null;
	}
	return new LevelVO(level,name,credit,dis);
}

public  LevelVO getMyLevel() {
	String name=nameField.getText();
	int level = 0;
	double credit=0.0;
	double dis=0.0;
	try{
	    level=Integer.parseInt(this.levelField.getText());
	    dis=Double.parseDouble(this.discountField.getText());
	    credit=Double.parseDouble(this.creditField.getText());
	}catch(NumberFormatException e){
		return null;
	}
	return new LevelVO(level,name,credit,dis);
}

}
















