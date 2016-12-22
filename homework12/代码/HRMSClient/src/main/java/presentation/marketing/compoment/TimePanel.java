package presentation.marketing.compoment;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TimePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private Font font=new Font("楷体",Font.ITALIC,20);
	private Font font2=new Font("楷体",Font.ITALIC,18);
	private Font font3=new Font("楷体",Font.CENTER_BASELINE,18);
	private Icon yearIcon=new ImageIcon("./src/main/resource/picture/marketing/yearBackground.png");
	private Icon monthIcon=new ImageIcon("./src/main/resource/picture/marketing/monthBackground.png");
	private JTextField yearField=new MJTextField(10,0,50,40,font2);
	private JTextField monthField=new MJTextField(10,0,30,40,font2);
	private JTextField dateField=new MJTextField(10,0,30,40,font2);
	private JTextField hourField=new MJTextField(10,0,30,40,font2);
	private JTextField minuteField=new MJTextField(10,0,30,40,font2);

	public TimePanel(String text,int x,int y,int w,int h){
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		JLabel timeLabel=new MJLabel(text,0,0,100,50,font);

		JLabel yearLabel=new MJLabel(100,5,100,50,yearIcon);
		JLabel monthLabel=new MJLabel(185,5,80,50,monthIcon);
		JLabel dateLabel=new MJLabel(245,5,80,50,monthIcon);
		JLabel hourLabel=new MJLabel(320,5,80,50,monthIcon);
		JLabel minuteLabel=new MJLabel(380,5,80,50,monthIcon);

		yearLabel.add(yearField);
		monthLabel.add(monthField);
		dateLabel.add(dateField);
		hourLabel.add(hourField);
		minuteLabel.add(minuteField);


		JLabel bridge1=new MJLabel("-",170,14,50,20,font3);
		bridge1.setForeground(Color.black);
		JLabel bridge2=new MJLabel("-",230,14,50,20,font3);
		bridge2.setForeground(Color.black);
		JLabel colon=new MJLabel(":",370,14,50,20,font3);
		colon.setForeground(Color.black);

		this.add(timeLabel);
		this.add(yearLabel);
		this.add(monthLabel);
		this.add(dateLabel);
		this.add(hourLabel);
		this.add(minuteLabel);
		this.add(bridge1);
		this.add(bridge2);
		this.add(colon);
	}



	public void setTime(int year,int month,int date,int hour,int minute){
		this.yearField.setText(""+year);
		this.monthField.setText(""+(month));
		this.dateField.setText(""+date);
		this.hourField.setText(""+hour);
		this.minuteField.setText(""+minute);
	}
	public Calendar getTime(){
		int year,month,date,hour,minute;
		String y=yearField.getText(),m=monthField.getText(),d=dateField.getText(),h=hourField.getText(),mi=minuteField.getText();
		String f=y+"-"+m+"-"+d+" "+h+":"+mi+":"+"00";
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c;
		try{
			year=Integer.parseInt(y);
			month=Integer.parseInt(m);
			date=Integer.parseInt(d);
			hour=Integer.parseInt(h);
			minute=Integer.parseInt(mi);
			c=Calendar.getInstance();
			c.set(year,month-1,date,hour,minute);
			format.setLenient(false);
			format.parse(f);
		}catch(NumberFormatException e){
			return null;
		} catch (ParseException e) {
			return null;
		}
		return c;
	}
}

























