package presentation.marketing.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.marketing.compoment.MJButton;
import presentation.marketing.compoment.MJLabel;
import presentation.marketing.compoment.MJPanel;
import presentation.marketing.compoment.MJTextField;
import presentation.marketing.controller.ProcessMarketingViewController;
import vo.clientVO.ClientVO;

public class ProcessMarketingCreditView extends JPanel{
	private static final long serialVersionUID = 1L;
	private ProcessMarketingViewController controller;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,24);
	private Font font2=new Font("微软雅黑",Font.HANGING_BASELINE,18);
	private Icon searchBar=new ImageIcon("./src/main/resource/picture/marketing/searchBar.png");
	private Icon searchIcon=new ImageIcon("./src/main/resource/picture/marketing/searchKey.png");
	private Icon inputIcon=new ImageIcon("./src/main/resource/picture/marketing/yearBackground.png");
	private Icon checkIcon=new ImageIcon("./src/main/resource/picture/marketing/ensure.png");
	private Image orderBackground=new ImageIcon("./src/main/resource/picture/marketing/orderBackground.png").getImage();
	private JTextField idField=new MJTextField(0,0,200,40,font);
	private JTextField creditField=new MJTextField(12,0,50,40,font2);
	private MJPanel panel=new MJPanel(70,100,600,250,orderBackground);
	private ProcessMarketingView view;
    private MJLabel credit;


	public ProcessMarketingCreditView(ProcessMarketingViewController controller,ProcessMarketingView view) {
		this.controller=controller;
		this.view=view;
		this.setBounds(280, 82, 704, 500);
    	this.setLayout(null);
    	this.setOpaque(false);

    	MJLabel credit=new MJLabel("查询客户",5,35,200,30,font);
    	MJLabel inputLabel=new MJLabel(120,30,500,50,searchBar);
    	idField=new MJTextField(20,2,400,40,font);
    	MJButton searchKey=new MJButton(590,30,60,60,searchIcon);
    	inputLabel.add(idField);

    	searchKey.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                searchKeyClicked();
			}
       	});

    	panel.setVisible(false);
        this.add(credit);
        this.add(inputLabel);
        this.add(searchKey);
    	this.repaint();
    	this.add(panel);
        view.add(this);

        this.revalidate();
        this.repaint();
	}

	private void searchKeyClicked(){
		String clientID=idField.getText();
		ClientVO vo=null;
		if(clientID.length()!=0){//有输入内容
			if(clientID.charAt(0)=='C'){//输入首字母是C，可以进行搜索
                vo=controller.getclient(clientID);
			    if(vo!=null)//ClientVO不为空
			    	showClient(vo);
			    else
			    	((ProcessMarketingView) view).setHint("该用户ID不存在，请继续填写。");
			}
			else{  //输入首字母不是C，应当提示重新输入
				((ProcessMarketingView) view).setHint("请继续填写。");
			}
		}

	}

	private void showClient(ClientVO vo){
		panel.setVisible(true);
		panel.removeAll();
		MJLabel name=new MJLabel(vo.getName(),20,10,200,40,font2);
		MJLabel id=new MJLabel("账号ID:"+vo.getID(),20,40,500,40,font2);
		credit=new MJLabel("信用值："+vo.getCredit(),20,70,200,40,font2);
		MJLabel recharge=new MJLabel("充值额度",20,105,170,40,font2);
		MJLabel inputLabel=new MJLabel(105,105,100,50,inputIcon);
		MJButton check=new MJButton(200,150,60,60,checkIcon);

		check.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                test(vo.getID());
			}
		});

		inputLabel.add(creditField);
		panel.add(name);
		panel.add(id);
		panel.add(credit);
		panel.add(recharge);
		panel.add(inputLabel);
		panel.add(check);

		this.revalidate();
		this.repaint();
	}

	private void test(String clientID){
		String text=this.creditField.getText();
		boolean convertion=true;
		double credit=0;
		try{
			credit=Double.parseDouble(text);
		}catch(NumberFormatException e){
			convertion=false;
		}
		if(convertion){//输入的信用值为小数数字
			if(credit>0){//输入的数字大于0
			    if(controller.setCredit(clientID, credit*100)){//设置信用值成功
				    this.credit.setText("信用值："+(controller.getclient(clientID).getCredit()));
			        this.creditField.setText("");
			        view.setHint("信用值充值成功。");
				}else{//设置信用值失败
					view.setHint("信用值充值失败。");
				}
			}else{//输入的数字小于0
				view.setHint("信用值不能为负数。");
			}
		}else{//输入的信用值为非小数
			view.setHint("请重新输入充值的信用值。");
		}

	}
	public void hideCredit(){
	    	this.removeAll();
	        this.setVisible(false);
     }

}




































