package presentation.marketing.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Enum.ResultMessage;
import presentation.marketing.compoment.MJButton;
import presentation.marketing.compoment.MJPanel;
import presentation.marketing.compoment.*;
import vo.areaVO.AreaVO;
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
	private JPanel view;

	public ProcessMarketingStrategyView(ProcessMarketingViewControllerService controller,JPanel view){
		this.controller=controller;
		this.view=view;
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
    	view.add(this);
	}

	public void periodButtonClicked(){
		hideGroup();
		periodPanel=new periodPanel(0,0,780,500);
		periodPanel.setVisible(true);
	    Calendar c=Calendar.getInstance();
	    periodPanel.setStartTime(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE),c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE));
	    periodPanel.setEndTime(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE),c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE));
	    periodPanel.setDiscount(0.00);

	  //确认Button及其监听
        JButton check=new MJButton(385,350,60,60,ensureIcon);
        check.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
              MarketingStrategyVO periodVO= periodPanel.getCreatedVO();
              if(periodVO==null){//vo为空 说明信息还未填写完全
            	  ((ProcessMarketingView)view).setHint("请继续填写.");
              }else{
            	  if(controller.addMarketingStrategy(periodVO)==ResultMessage.SUCCESS){//保存新增策略成功
                	  ((ProcessMarketingView)view).setHint("保存新增策略成功.");
                  }else {//保存新增策略失败
                	  ((ProcessMarketingView)view).setHint("保存新增策略失败.");
                  }
              }
			}

        });

        JButton back1=new MJButton(80,8,85,50,backIcon);
        back1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				groupPanel.setVisible(true);
				periodPanel.removeAll();
				periodPanel.setVisible(false);
				periodPanel=null;
			}

        });
        periodPanel.add(back1);

        periodPanel.add(check);
	    this.add(periodPanel);
	    this.revalidate();
		this.repaint();
  	}


	public void specialButtonClicked(){
		hideGroup();
		List<String> districts=Arrays.asList(controller.getDistrictNames());
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
				if(specialVO==null){//从specialPanel处得到空的VO，说明有项目还未填写完全
	            	  ((ProcessMarketingView)view).setHint("请继续填写.");
	            	  return;
	              }
	              if(controller.addMarketingStrategy(specialVO)==ResultMessage.SUCCESS){//保存新增策略成功
	            	  ((ProcessMarketingView)view).setHint("保存新增策略成功.");
	              }else {//保存新增策略失败
	            	  ((ProcessMarketingView)view).setHint("保存新增策略失败.");
	              }
			}

        });

        JButton back2=new MJButton(80,8,85,50,backIcon);
        back2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				groupPanel.setVisible(true);
				specialPanel.removeAll();
				specialPanel.setVisible(false);
				specialPanel=null;
			}

        });
        specialPanel.add(back2);

        specialPanel.add(check);
	    this.add(specialPanel);
	    this.revalidate();
		this.repaint();
	}
	public void newButtonClicked(){
		hideGroup();
		List<AreaVO> districts=controller.getDistricts();//调用controller得到商圈及其酒店信息列表
		newPanel=new newPanel(0,0,780,500,districts);
	    newPanel.setVisible(true);
	    Calendar c=Calendar.getInstance();
	    newPanel.setStartTime(c.get(Calendar.YEAR),(c.get(Calendar.MONTH)),c.get(Calendar.DATE),c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE));
	    newPanel.setEndTime(c.get(Calendar.YEAR),(c.get(Calendar.MONTH)),c.get(Calendar.DATE),c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE));
	    newPanel.setDiscount(0.00);

	    //确认Button及其监听
        JButton check=new MJButton(385,435,60,60,ensureIcon);
        check.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
              MarketingStrategyVO cratedVO= newPanel.getCreatedVO();
              if(cratedVO==null){//从newPanel处得到空的VO，说明有项目还未填写完全
            	  ((ProcessMarketingView)view).setHint("请继续填写.");
            	  return;
              }
              if(controller.addMarketingStrategy(cratedVO)==ResultMessage.SUCCESS){//保存新增策略成功
            	  ((ProcessMarketingView)view).setHint("保存新增策略成功.");
              }else {//保存新增策略失败
            	  ((ProcessMarketingView)view).setHint("保存新增策略失败.");
              }
			}

        });

        JButton back3=new MJButton(80,8,85,50,backIcon);
        back3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				groupPanel.setVisible(true);
				newPanel.removeAll();
				newPanel.setVisible(false);
				newPanel=null;
			}

        });
        newPanel.add(back3);

        newPanel.add(check);
	    this.add(newPanel);
	    this.revalidate();
		this.repaint();
	}

	public void browseButtonClicked(){
		hideGroup();
		List<MarketingStrategyVO> strategys=controller.getMarketingStrategy(controller.getMarketingID());
		JPanel panel=new MJPanel(0,0,200,200);
        panel.setPreferredSize(new Dimension(690,690));
		browsePanel=new browsePanel(80,0,820,500,strategys,panel);
		browsePanel.setVisible(true);

		JButton back4=new MJButton(2,8,85,50,backIcon);

		back4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                List<String> delete=browsePanel.getDelete();
                for(String s:delete){
                	if(controller.deleteMarketingStrategy(s)==ResultMessage.SUCCESS){//删除策略成功
                		//((ProcessMarketingView)view).setHint("删除策略成功.");
                	}else{//删除策略失败
                		((ProcessMarketingView)view).setHint("删除策略失败.");
                	}
                }
                groupPanel.setVisible(true);
				browsePanel.removeAll();
				browsePanel.setVisible(false);
				browsePanel=null;
			}
		});

		browsePanel.add(back4);
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
	}


}
