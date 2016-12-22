package presentation.marketing.compoment;

import java.util.Calendar;

import javax.swing.JPanel;

import Enum.marketingStrategy;
import vo.strategyVO.MarketingStrategyVO;

public class periodPanel extends MJPanel{

	private JPanel namePanel=new NamePanel("策略名称",160,50,660,50);
	private JPanel startPanel=new TimePanel("开始时间",160,120,660,50);
	private JPanel endPanel=new TimePanel("结束时间",160,190,660,50);
	private JPanel discountPanel=new InputPanel("折扣",160,260,300,50);
    private MarketingStrategyVO createdVO;
	private static final long serialVersionUID = 1L;

	public periodPanel(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.setVisible(false);
		this.add(namePanel);
		this.add(startPanel);
    	this.add(endPanel);
    	this.add(discountPanel);

    	this.revalidate();
        this.repaint();
	}

	public MarketingStrategyVO getCreatedVO() {

        String name=namePanel.getName();
        Calendar start=((TimePanel) startPanel).getTime();
        Calendar end=((TimePanel) endPanel).getTime();
        double discount= ((InputPanel)discountPanel).getInput();

        setCreatedVO(new MarketingStrategyVO(name,marketingStrategy.PERIOD,start,end,discount));
		 return createdVO;
	}

	private void setCreatedVO(MarketingStrategyVO createdVO) {
		this.createdVO = createdVO;
	}

	public void setStartTime(int year, int month, int date, int hour, int minute) {
		((TimePanel) startPanel).setTime(year,  month,  date,  hour,  minute);

	}

	public void setEndTime(int year, int month, int date, int hour, int minute) {
		((TimePanel) endPanel).setTime(year,  month,  date,  hour,  minute);

	}

	public void setDiscount(double discount) {
		((InputPanel) discountPanel).setInput(discount);
	}
}
