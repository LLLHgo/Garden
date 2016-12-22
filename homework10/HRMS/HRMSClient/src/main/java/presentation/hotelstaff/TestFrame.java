package presentation.hotelstaff;

import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import presentation.hotelstaff.controller.HotelstaffViewController;
import presentation.hotelstaff.controller.HotelstaffViewControllerService;
import presentation.hotelstaff.view.HotelinfoPanel;
import presentation.hotelstaff.view.HotelstaffView;
import presentation.login.view.ProcessLoginView;

public class TestFrame {
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 618);
		
		Toolkit kit = Toolkit.getDefaultToolkit();    // 定义工具包
		Dimension screenSize = kit.getScreenSize();   // 获取屏幕的尺寸
		int screenWidth = screenSize.width/2;         // 获取屏幕的宽
		int screenHeight = screenSize.height/2;       // 获取屏幕的高
		int height = frame.getHeight();
		int width = frame.getWidth();
		frame.setLocation(screenWidth-width/2, screenHeight-height/2);
		
		

		HotelstaffViewController hotelstaff = HotelstaffViewController.getInstance("H00000001");
		HotelstaffView view = new HotelstaffView(hotelstaff);
		hotelstaff.setView(view);
		frame.getContentPane().add(view);
		
		frame.setVisible(true);
	}
	
}
