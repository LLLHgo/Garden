package presentation.marketing.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Enum.ResultMessage;
import presentation.marketing.compoment.MJPanel;
import presentation.marketing.controller.ProcessMarketingViewController;
import presentation.marketing.compoment.*;
import vo.levelVO.LevelVO;

public class ProcessMarketingVIPView extends JPanel{

	private static final long serialVersionUID = 1L;
	private JScrollPane levelPanel;
	private Icon checkIcon=new ImageIcon("./src/main/resource/picture/marketing/ensure.png");
	private JButton checkButton=new MJButton(330,440,60,60,checkIcon);
	private int height=220;
    private List<LevelVO> levels;
    private List<LevelVO> levelsPos;


	public ProcessMarketingVIPView(ProcessMarketingViewController controller,ProcessMarketingView view) {
		this.setBounds(200, 82, 780, 500);
    	this.setLayout(null);
    	this.setOpaque(false);

		levels=controller.findAllLevel();
		JPanel panel=new MJPanel(0,0,200,200);
        panel.setPreferredSize(new Dimension(690,height*levels.size()+70));
		levelPanel=new levelPanel(80,20,820,400,levels,panel);
        this.add(levelPanel);

        checkButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                levelsPos=((levelPanel) levelPanel).getLevels();
                if(levelsPos==null){
                	view.setHint("请重新填写等级信息。");
                	return;
                }else{
	                if(controller.updateLevel(levelsPos)==ResultMessage.SUCCESS){
	                	view.setHint("等级信息保存成功!客户数据更新成功！");
	                }else if(controller.updateLevel(levelsPos)==ResultMessage.FAIL){
	                	view.setHint("等级信息保存失败。");
	                }else if(controller.updateLevel(levelsPos)==ResultMessage.FAULT){
	                	view.setHint("好消息：等级信息已保存成功！坏消息：客户数据更新失败。。。");
	                }
                }
			}
        });
        this.add(checkButton);


		view.add(this);
    	this.revalidate();
    	this.repaint();
	}
	public void hideVIP() {
		this.removeAll();
		this.setVisible(false);
	}



}
