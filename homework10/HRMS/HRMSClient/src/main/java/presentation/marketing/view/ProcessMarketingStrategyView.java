package presentation.marketing.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.marketing.compoment.MJButton;
import presentation.marketing.compoment.MJPanel;
import presentation.marketing.compoment.*;
import vo.districtVO.DistrictVO;
import vo.strategyVO.MarketingStrategyVO;;

public class ProcessMarketingStrategyView extends JPanel{

	private static final long serialVersionUID = 1L;

	private ProcessMarketingViewControllerService controller;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,28);
	private Icon strategyPreIcon=new ImageIcon("./src/main/resource/picture/marketing/strategyPreIcon.png");
	private Icon backIcon=new ImageIcon("./src/main/resource/picture/marketing/backIcon.png");
	private Icon ensureIcon=new ImageIcon("./src/main/resource/picture/marketing/littleCheck.png");


	private JPanel groupPanel=new MJPanel(0,0,780,500);
	private newPanel newPanel;
	private periodPanel periodPanel;
	private specialPanel specialPanel;
	private browsePanel browsePanel;

	private JButton back=new MJButton(80,8,85,50,backIcon);
	public ProcessMarketingStrategyView(ProcessMarketingViewControllerService controller,JPanel panel){
		this.controller=controller;
		this.setBounds(200, 82, 780, 500);
    	this.setLayout(null);
    	this.setOpaque(false);

    	JButton periodButton=new MJButton("特定期间",250,50,400,100,font,strategyPreIcon);
    	JButton specialButton=new MJButton ("商圈专属",250,155,400,100,font,strategyPreIcon);
    	JButton newButton=new MJButton("制定新策略",250,260,400,100,font,strategyPreIcon);
    	JButton browseButton=new MJButton("查看策略",250,365,400,100,font,strategyPreIcon);

    	groupPanel.add(periodButton);
    	groupPanel.add(specialButton);
    	groupPanel.add(newButton);
    	groupPanel.add(browseButton);


    	back.addActionListener(new ActionListener(){
    		@Override
			public void actionPerformed(ActionEvent e) {
               groupPanel.setVisible(true);
               if(periodPanel!=null){
            	   periodPanel.setVisible(false);
            	   periodPanel.removeAll();
            	   periodPanel=null;
               }
               if(specialPanel!=null){
            	   specialPanel.setVisible(false);
            	   specialPanel.removeAll();
            	   specialPanel=null;
               }

               if(newPanel!=null){
            	   newPanel.setVisible(false);
            	   newPanel.removeAll();
            	   newPanel=null;
               }

               if(browsePanel!=null){
            	   browsePanel.setVisible(false);
            	   browsePanel.removeAll();
            	   browsePanel=null;
               }
			}
    	});

    	periodButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                periodButtonClicked();
			}
       	});

    	specialButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                specialButtonClicked();
			}
       	});

    	newButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                newButtonClicked();
			}
       	});
    	browseButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                browseButtonClicked();
			}
       	});
    	this.add(groupPanel);
    	panel.add(this);
	}

	public void periodButtonClicked(){
		hideGroup();
		periodPanel=new periodPanel(0,0,780,500);
		periodPanel.setVisible(true);
	    Calendar c=Calendar.getInstance();
	    periodPanel.setStartTime(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE),c.get(Calendar.HOUR),c.get(Calendar.MINUTE));
	    periodPanel.setEndTime(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE),c.get(Calendar.HOUR),c.get(Calendar.MINUTE));
	    periodPanel.setDiscount(0.00);

	  //确认Button及其监听
        JButton check=new MJButton(385,350,60,60,ensureIcon);
        check.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
              MarketingStrategyVO periodVO= periodPanel.getCreatedVO();
              controller.addMarketingStrategy(periodVO);
			}

        });

        periodPanel.add(check);
	    this.add(periodPanel);
	    this.revalidate();
		this.repaint();
  	}


	public void specialButtonClicked(){
		hideGroup();
		List<String> districts=controller.getDistrictNames();
		specialPanel=new specialPanel(0,0,780,500,districts);
		specialPanel.setVisible(true);
	    Calendar c=Calendar.getInstance();
	    specialPanel.setStartTime(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE),c.get(Calendar.HOUR),c.get(Calendar.MINUTE));
	    specialPanel.setEndTime(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE),c.get(Calendar.HOUR),c.get(Calendar.MINUTE));

	    //确认Button及其监听
        JButton check=new MJButton(385,440,60,60,ensureIcon);
        check.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
              MarketingStrategyVO specialVO= specialPanel.getSpecialVO();
              controller.addMarketingStrategy(specialVO);
			}

        });

        specialPanel.add(check);
	    this.add(specialPanel);
	    this.revalidate();
		this.repaint();
	}
	public void newButtonClicked(){
		hideGroup();
		List<DistrictVO> districts=controller.getDistricts();
		newPanel=new newPanel(0,0,780,500,districts);
	    newPanel.setVisible(true);
	    Calendar c=Calendar.getInstance();
	    newPanel.setStartTime(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE),c.get(Calendar.HOUR),c.get(Calendar.MINUTE));
	    newPanel.setEndTime(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE),c.get(Calendar.HOUR),c.get(Calendar.MINUTE));
	    newPanel.setDiscount(0.00);

	    //确认Button及其监听
        JButton check=new MJButton(385,435,60,60,ensureIcon);
        check.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
              MarketingStrategyVO cratedVO= newPanel.getCreatedVO();
              controller.addMarketingStrategy(cratedVO);
			}

        });

        newPanel.add(check);
	    this.add(newPanel);
	    this.revalidate();
		this.repaint();
	}

	public void browseButtonClicked(){
		hideGroup();
		List<MarketingStrategyVO> strategys=controller.getMarketingStrategy(controller.getMarketingID());
		browsePanel=new browsePanel(80,0,690,500,strategys);
		browsePanel.setVisible(true);
        this.add(browsePanel);
	    this.revalidate();
		this.repaint();
	}

	public void hideStrategy() {
		this.removeAll();
		this.setVisible(false);
	}
	public void hideGroup(){
		groupPanel.setVisible(false);
		this.add(back);
	}

}
