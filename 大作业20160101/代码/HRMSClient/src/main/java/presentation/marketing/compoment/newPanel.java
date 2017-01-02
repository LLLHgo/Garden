
package presentation.marketing.compoment;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import Enum.MarketingStrategy;
import Enum.VIPType;
import vo.areaVO.AreaVO;
import vo.strategyVO.MarketingStrategyVO;

public class newPanel extends MJPanel{

	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,21);
	private Font font2=new Font("微软雅黑",Font.CENTER_BASELINE,18);
	private JPanel namePanel=new NamePanel("策略名称",160,10,660,50);
	private JPanel startPanel=new TimePanel("开始时间",160,50,660,50);
	private JPanel endPanel=new TimePanel("结束时间",160,90,660,50);
	private JPanel typePanel=new MemberPanel("会员种类",160,130,350,50);
	private JPanel levelPanel=new InputPanel("最低等级",160,170,350,50);
    private JPanel discountPanel=new InputPanel("折扣",420,170,300,50);
    private JPanel roomPanel=new InputPanel("最少房间数",145,210,350,50);
    private JPanel expenditurePanel=new InputPanel("最少消费额",385,210,350,50);
    private JPanel hotelPanel=new HotelPanel("酒店",180,250,300,50);
    private JPanel hotelsPanel;
    private List<String> hotelSelected=new ArrayList<String>();
    private List<VIPType> VIPSelected;
    private MarketingStrategyVO createdVO;
    private List<JRadioButton> hotelButton=new ArrayList<JRadioButton>();

    private static final long serialVersionUID = 1L;

	public newPanel(int x, int y, int w, int h,List<AreaVO> list) {
		super(x, y, w, h);
		this.setVisible(false);
		this.add(namePanel);
		this.add(startPanel);
    	this.add(endPanel);
    	this.add(discountPanel);
    	this.add(hotelPanel);
    	this.add(typePanel);
    	this.add(levelPanel);
    	this.add(roomPanel);
        this.add(expenditurePanel);

        int items=0;//酒店的个数 每个酒店需要30高度
        for(AreaVO vo:list){
        	items+=vo.getHotels().size();
        }
        hotelsPanel=new MJPanel(0, 0, 700,3520);
        hotelsPanel.setPreferredSize(new Dimension(565,10+30*items+40*list.size()));//dimension的高度是酒店占高度和商圈占高度的和,10是下方边距

        int dis=-1;//商圈的个数 每个商圈需要40高度
        items=0;
        for(AreaVO vo:list){
        	items+=vo.getHotels().size();
        	dis++;
        	List<JRadioButton> hotelButtonList =new ArrayList<JRadioButton>();;
        	JRadioButton district=new MJRadioButton(vo.getName(),false,40,dis*40+(items-vo.getHotels().size())*30,400,50,font);
        	district.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(((JRadioButton)e.getSource()).isSelected()){
						for(JRadioButton button:hotelButtonList){
                            button.setSelected(true);;
						}
					}
					else {
						for(JRadioButton button:hotelButtonList){
                            button.setSelected(false);;
						}
                    }
				}
        	});

        	hotelsPanel.add(district);
        	List<String> hotelList=vo.getHotels();
        	int index=-1;
        	for(String s:hotelList){
        		index++;
        		JRadioButton button=new MJRadioButton(s,false,60,dis*40+(items-vo.getHotels().size())*30+40+index*30,
        				400,40,font2);//每个酒店在所对应商圈下方
        		button.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						if(!((JRadioButton)e.getSource()).isSelected()){
                            district.setSelected(false);
						}
					}
        		});
        		hotelButton.add(button);
        		hotelButtonList.add(button);
        		hotelsPanel.add(button);
        	}
        }

        //放置showAbnormalOrderPanel的JScrollPanel
        JScrollPane hotelsScroll = new MJScrollPane(205, 285, 590, 150,hotelsPanel);

        this.add(hotelsScroll);
        this.revalidate();
        this.repaint();

	}
	public MarketingStrategyVO getCreatedVO() {
		hotelSelected=new ArrayList<String>();
		 for(JRadioButton button:hotelButton){
         	if(button.isSelected()==true){
         		hotelSelected.add(button.getText());
         	}
         }
         String name=namePanel.getName();
         Calendar c=Calendar.getInstance();
         Calendar start=((TimePanel) startPanel).getTime();
         Calendar end=((TimePanel) endPanel).getTime();
         VIPSelected=((MemberPanel) typePanel).getSelections();
         int minLevel=(int) ((InputPanel)levelPanel).getInput();
         double discount= ((InputPanel)discountPanel).getInput();
         int minRoom=(int) ((InputPanel)roomPanel).getInput();
         double minExpenditure=((InputPanel)expenditurePanel).getInput();
         if(hotelSelected.size()==0||name.length()==0||start==null||end==null||minLevel==-1||minExpenditure==-1||discount==-1||minRoom==-1)
        	 return null;
         if(c.compareTo(start)>=0||start.compareTo(end)>=0)//输入的日期不符
        	 return null;
         setCreatedVO(new MarketingStrategyVO(name,MarketingStrategy.CREATED,
              start,end,discount,hotelSelected,minExpenditure,minRoom,minLevel,VIPSelected));
		 return createdVO;
	}
	private void setCreatedVO(MarketingStrategyVO createdVO) {
		this.createdVO = createdVO;
	}
	public void setStartTime(int year, int month, int date, int hour, int minute) {
		((TimePanel) startPanel).setTime(year,  month+1,  date,  hour,  minute);

	}
	public void setEndTime(int year, int month, int date, int hour, int minute) {
		((TimePanel) endPanel).setTime(year,  month+1,  date,  hour,  minute);

	}
	public void setDiscount(double discount) {
		((InputPanel) discountPanel).setInput(discount);
	}

}
