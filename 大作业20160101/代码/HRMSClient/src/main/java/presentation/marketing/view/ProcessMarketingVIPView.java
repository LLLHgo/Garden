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
import presentation.marketing.compoment.MJButton;
import presentation.marketing.compoment.MJPanel;
import presentation.marketing.compoment.levelPanel;
import presentation.marketing.controller.ProcessMarketingViewController;
import vo.levelVO.LevelVO;

public class ProcessMarketingVIPView extends JPanel{

	private static final long serialVersionUID = 1L;
	private JScrollPane levelPanel;
	private Icon checkIcon=new ImageIcon(this.getClass().getResource("ensure.png"));
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
                	view.setHint("请重新填写等级信息，请注意数据格式。");
                	return;
                }else{
                	ResultMessage right=check();
                	if(right==ResultMessage.SUCCESS){//检验成功
                		ResultMessage setCredit=controller.updateLevel(levelsPos);
                		if(setCredit==ResultMessage.SUCCESS){//客户信用值充值成功
                			view.setHint("客户信用值更新成功");
                		}else{
                			view.setHint("数据已保存");//客户那边未更新
                		}
                 	}else if(right==ResultMessage.DUPLICATELEVELNAME){//所需信用值有重复
                		view.setHint("等级名称不能重复");
                	}else if(right==ResultMessage.DUPLICATECREDIT){//所需信用值有重复
                		view.setHint("信用值不能重复");
                	}else if(right==ResultMessage.DUPLICATELEVEL){//等级有重复
                		view.setHint("等级层次不能重复");
                	}else if(right==ResultMessage.WRONGLEVEL){//信用值和等级不匹配
                		view.setHint("等级与所需信用值不匹配");
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

	public ResultMessage check(){
		int size=this.levelsPos.size();
		int[] num=new  int[size];
		double[] credit=new double[size];
		String[] name=new String[size];
		int index=0;
		for(LevelVO level:levelsPos){
			num[index]=level.getLevel();
			name[index]=level.getName();
			credit[index++]= level.getCreditNeeded();

		}
		for(int i=0;i<size;i++){
			for(int j=i+1;j<size;j++){
				if(name[i].equals(name[j]))//名字重复
					return ResultMessage.DUPLICATELEVELNAME;
				if(num[i]==num[j])//等级重复
					return ResultMessage.DUPLICATELEVEL;
				if(credit[i]==credit[j])//所需信用值重复
					return ResultMessage.DUPLICATECREDIT;
				if((num[i]>num[j]&&credit[i]<credit[j])||(num[i]<num[j]&&credit[i]>credit[j]))//等级和信用值不匹配
					return ResultMessage.WRONGLEVEL;
			}
		}
		return ResultMessage.SUCCESS;
	}

}




























