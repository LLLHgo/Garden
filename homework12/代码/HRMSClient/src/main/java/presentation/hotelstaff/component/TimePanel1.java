package presentation.hotelstaff.component;

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

import presentation.hotelstaff.component.TextField;
import presentation.hotelstaff.component.TextLabel;
import presentation.marketing.compoment.MJLabel;
/**
 * 生日特惠折扣和合作企业折扣使用
 * @author liuyu
 * @since 16.12.5
 *
 */
public class TimePanel1 extends JPanel{

	private static final long serialVersionUID = 1L;

	Calendar c=Calendar.getInstance();
	private TextField yearField=new TextField(
			String.valueOf(c.get(Calendar.YEAR)),3,0,70,40,4);
	private TextField monthField=new TextField(
			String.valueOf(c.get(Calendar.MONTH)+1),97,0,38,40,2);
	private TextField dateField=new TextField(
			String.valueOf(c.get(Calendar.DATE)),153,0,38,40,2);
	private TextField hourField=new TextField(
			String.valueOf(c.get(Calendar.HOUR_OF_DAY)),212,0,38,40,2);
	private TextField minuteField=new TextField(
			String.valueOf(c.get(Calendar.MINUTE)),272,0,38,40,2);

	public TimePanel1(int x,int y,int w,int h){
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.setOpaque(false);
		Font font = new Font("微软雅黑",Font.BOLD,20);
		yearField.setForeground(Color.white);
		monthField.setForeground(Color.white);
		dateField.setForeground(Color.white);
		hourField.setForeground(Color.white);
		minuteField.setForeground(Color.white);
		yearField.setFont(font);;
		monthField.setFont(font);
		dateField.setFont(font);
		hourField.setFont(font);
		minuteField.setFont(font);
		this.add(yearField);
		this.add(monthField);
		this.add(dateField);
		this.add(hourField);
		this.add(minuteField);
		
		JLabel bridge1=new TextLabel(70,8,50,20,"-");
		bridge1.setForeground(Color.lightGray);
		bridge1.setFont(font);
		JLabel bridge2=new TextLabel(130,8,50,20,"-");
		bridge2.setForeground(Color.lightGray);
		bridge2.setFont(font);
		JLabel colon=new TextLabel(250,8,50,20,":");
		colon.setForeground(Color.lightGray);
		colon.setFont(font);
		this.add(bridge1);
		this.add(bridge2);
		this.add(colon);
	}

	public void setTime(int year,int month,int date,int hour,int minute){
		this.yearField.setText(""+year);
		this.monthField.setText(""+(month+1));
		this.dateField.setText(""+date);
		this.hourField.setText(""+hour);
		this.minuteField.setText(""+minute);
	}
	public Calendar getTime(){
//		int year=Integer.parseInt(yearField.getText());
//		int month=Integer.parseInt(monthField.getText())-1;
//		int date=Integer.parseInt(dateField.getText());
//		int hour=Integer.parseInt(hourField.getText());
//		int minute=Integer.parseInt(minuteField.getText());
//		Calendar c=Calendar.getInstance();
//		c.set(year,month,date,hour,minute);
//		return c;
		int year,month,date,hour,minute;
		String y=yearField.getText(),m=monthField.getText(),d=dateField.getText(),h=hourField.getText(),mi=minuteField.getText();
		String f=y+"-"+m+"-"+d+" "+h+":"+mi+":"+"00";
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c;
		try{
			year=Integer.parseInt(y);
			month=Integer.parseInt(m)-1;
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
