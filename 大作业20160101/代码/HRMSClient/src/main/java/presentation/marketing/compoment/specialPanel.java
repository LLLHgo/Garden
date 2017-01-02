package presentation.marketing.compoment;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Enum.MarketingStrategy;
import vo.strategyVO.MarketingStrategyVO;

public class specialPanel extends MJPanel{

	private Font font=new Font("楷体",Font.ITALIC,20);
	private Icon addIcon=new ImageIcon(this.getClass().getResource("addIcon.png"));
	private Icon deleteIcon=new ImageIcon(this.getClass().getResource("delete.png"));
	private JPanel namePanel=new NamePanel("策略名称",160,10,660,50);
	private JPanel startPanel=new TimePanel("开始时间",160,50,660,50);
	private JPanel endPanel=new TimePanel("结束时间",160,90,660,50);
	private JPanel districtPanel;
	private JLabel addLabel=new MJLabel("等级折扣",160,170,200,50,font);
	private JPanel Apanel=new MJPanel(0,0,200,200);
	private JScrollPane addPane;
	private JButton addButton=new MJButton(230,10,60,60,addIcon);
	private int[] levels;
	private double[] discounts;
    private List<MakePanel> makePanels=new ArrayList<MakePanel>();
	private static final long serialVersionUID = 1L;

	public specialPanel(int x, int y, int w, int h,List<String> list) {
		super(x, y, w, h);

		districtPanel=new SelectPanel("商圈",160,80,660,200,list);
		this.setVisible(false);
		this.add(namePanel);
		this.add(startPanel);
    	this.add(endPanel);
    	this.add(districtPanel);
    	this.add(addLabel);
    	Apanel.setPreferredSize(new Dimension(200,60));

    	addButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel makePanel=new MakePanel(100,10+50*makePanels.size(),400,40);
				makePanels.add((MakePanel) makePanel);

				MJButton delete=new MJButton(290,5,70,40,deleteIcon);
				delete.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						//找到被删除的Item的位置
						int index=makePanels.indexOf(makePanel);
						makePanel.removeAll();
						makePanels.remove(makePanel);
						//从index开始的每个item，包括addButton都往下移50.
						for(int i=index;i<makePanels.size();i++){
							MakePanel panel=makePanels.get(i);
							panel.setLocation(100, 10+50*i);
						}
						addButton.setLocation(230, 50*makePanels.size()+10);
						Apanel.setPreferredSize(new Dimension(300,60+50*makePanels.size()+10));
						refresh();
					}


				});
				makePanel.add(delete);

                Apanel.add(makePanel);
                Apanel.setPreferredSize(new Dimension(300,60+50*makePanels.size()+10));
                addButton.setLocation(230,50*makePanels.size()+10);
                refresh();
			}
    	});

    	Apanel.add(addButton);
    	addPane=new MJScrollPane(160,210,650,240,Apanel);
    	this.add(addPane);
        refresh();

	}

	public void refresh(){
		this.revalidate();
		this.repaint();
	}

	public MarketingStrategyVO getSpecialVO() {
        String name=namePanel.getName();
        Calendar start=((TimePanel) startPanel).getTime();
        Calendar end=((TimePanel) endPanel).getTime();
        Calendar c=Calendar.getInstance();
        String districtName=districtPanel.getName();
        levels=new int[makePanels.size()];
        discounts=new double[makePanels.size()];
        int i=0;
        for(MakePanel m:makePanels){
        	levels[i]=m.getLevel();
        	discounts[i++]=m.getDiscount();
        	if(m.getLevel()<0||m.getDiscount()<0)
        		return null;
        }
        if(name.length()==0||c.compareTo(start)>=0||start.compareTo(end)>=0||districtName==null)
        	return null;

        MarketingStrategyVO vo= new MarketingStrategyVO(name,MarketingStrategy.VIPSPECIAL,start,end,districtName,levels,discounts);
		return vo;
	}

	public void setStartTime(int year, int month, int date, int hour, int minute) {
		((TimePanel) startPanel).setTime(year,  month+1,  date,  hour,  minute);

	}
	public void setEndTime(int year, int month, int date, int hour, int minute) {
		((TimePanel) endPanel).setTime(year,  month+1,  date,  hour,  minute);

	}


}
