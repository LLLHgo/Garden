package presentation.marketing.compoment;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Enum.MarketingStrategy;
import vo.strategyVO.MarketingStrategyVO;

public class browsePanel extends MJScrollPane{
	private static final long serialVersionUID = 1L;
    private List<MarketingStrategyVO> list;
    private JPanel panel;
    private Icon deleteIcon=new ImageIcon("./src/main/resource/picture/marketing/delete.png");
    private List<String> deleteList=new ArrayList<String>();

    private static int[] height={145,200,280};
	public browsePanel(int x, int y, int w, int h,List<MarketingStrategyVO> list,JPanel panel) {
		super(x, y, w, h,panel);
		this.list=list;
		this.panel=panel;
		//特定期间的策略高度为140，专属商圈的折扣为150，其他的策略高度为200.
        refresh();
	}
	private void refresh(){
		panel.removeAll();
		int period=0,special=0,others=0;
		for(MarketingStrategyVO vo:list){
			if(vo.getType()==(MarketingStrategy.CREATED))
				others++;
			else if(vo.getType()==(MarketingStrategy.PERIOD))
				period++;
			else if(vo.getType()==(MarketingStrategy.VIPSPECIAL))
			    special++;
		}
        panel.setPreferredSize(new Dimension(690,height[0]*period+height[1]*special+height[2]*others+30));

        int position=30;//记录当前panel排版的位置
        for(MarketingStrategyVO vo:list){
        	Calendar start = vo.getStartTime();
        	Calendar end=vo.getEndTime();
    		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:MM");// 设置Calendar的格式
            if(vo.getType()==MarketingStrategy.PERIOD){
            	JPanel showPeriod=new showPeriod(vo.getName(),"开始时间："+df.format(start.getTime()),"结束时间："+df.format(end.getTime()),
        				vo.getDiscount(),60,position,600,height[0]);
            	position+=height[0];
            	JButton delete=new MJButton(260,height[0]-45,70,40,deleteIcon);
                delete.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e) {
                        list.remove(vo);
                        deleteList.add(vo.getName());
                        refresh();
        			}
                 });
                showPeriod.add(delete);
            	panel.add(showPeriod);
            }else if(vo.getType()==MarketingStrategy.VIPSPECIAL){
            	JPanel showSpecial=new showSpecial(vo.getName(),"开始时间："+df.format(start.getTime()),"结束时间："+df.format(end.getTime()),
        				vo.getBusinessDistrict(),vo.getLevels(),vo.getDiscounts(),60,position,600,height[1]);
            	position+=height[1];
            	JButton delete=new MJButton(260,height[1]-45,70,40,deleteIcon);
                delete.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e) {
                        list.remove(vo);
                        deleteList.add(vo.getName());
                        refresh();
        			}
                 });
                showSpecial.add(delete);
            	panel.add(showSpecial);

            }else if (vo.getType()==MarketingStrategy.CREATED){
            	JPanel showNew=new showNew(vo.getName(),"开始时间："+df.format(start.getTime()),"结束时间："+df.format(end.getTime()),
        				vo.getVipKinds(),vo.getDiscount(),vo.getMinLevel(),vo.getMinRooms(),vo.getMinSum(),vo.getHotels(),60,position,600,height[2]);
            	position+=height[2];
            	JButton delete=new MJButton(260,height[2]-45,70,40,deleteIcon);
                delete.addActionListener(new ActionListener(){
        			@Override
        			public void actionPerformed(ActionEvent e) {
                        list.remove(vo);
                        deleteList.add(vo.getName());
                        refresh();
        			}
                 });
                showNew.add(delete);
            	panel.add(showNew);
            }
        }
        this.revalidate();
        this.repaint();
	}

	public List<String> getDelete(){
		List<String> d=deleteList;
		deleteList=new ArrayList<String>();
		return d;
	}

}



























