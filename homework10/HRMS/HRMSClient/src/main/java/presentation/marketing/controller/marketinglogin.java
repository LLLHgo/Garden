package presentation.marketing.controller;

import javax.swing.JFrame;

import presentation.marketing.view.ProcessMarketingProfileView;
import presentation.marketing.view.ProcessMarketingView;
import presentation.marketing.view.ProcessMarketingViewControllerService;

public class marketinglogin {
    public static void main(String[] args){
        JFrame mframe=new JFrame();
        mframe.setSize(1000, 640);
		mframe.setLocation(150, 75);
		mframe.setLayout(null);
		String marketingID="M00010001";
        ProcessMarketingViewControllerService controller=new ProcessMarketingViewController(marketingID);
        ProcessMarketingView view=new ProcessMarketingView(controller);
        controller.setView(view);
        mframe.getContentPane().add(view);
        mframe.setVisible(true);
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
