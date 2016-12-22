package presentation.marketing.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import presentation.marketing.compoment.MJButton;
import presentation.marketing.compoment.MJTextField;
import presentation.marketing.compoment.MJLabel;
import vo.marketingVO.MarketingVO;

public class ProcessMarketingProfileView extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Font font=new Font("微软雅黑",Font.HANGING_BASELINE,22);
	private Font font2=new Font("楷体",Font.ITALIC,20);
	private String MarketingID;
	private MarketingVO Mvo;

	private MJLabel nameLabel =new MJLabel("姓名",100, 40, 60, 60,font);
	private MJLabel accountLabel =new MJLabel("账号",100, 120, 60, 60,font);
	private MJLabel TELLabel =new MJLabel("TEL",100, 200, 60, 60,font);
	private MJLabel passwordLabel =new MJLabel("密码",100, 280, 60, 60,font);

	private Icon modifyIcon=new ImageIcon("./src/main/resource/picture/marketing/modify.png");
    private Icon ensureIcon=new ImageIcon("./src/main/resource/picture/marketing/ensure.png");

    private MJTextField nameField=new MJTextField(250, 46, 200, 48,font2);
    private MJTextField accountField =new MJTextField(250, 126, 200, 48,font2);
    private MJTextField TELField=new MJTextField(250, 206, 200, 48,font2);
    private MJTextField passwordField=new MJTextField(250, 286, 200, 48,font2);

    public ProcessMarketingProfileView(ProcessMarketingViewControllerService controller,JPanel panel){
     	this.MarketingID=controller.getMarketingID();
        this.Mvo=controller.init(MarketingID);
    	this.setBounds(200, 82, 704, 500);
    	this.setLayout(null);
    	this.setOpaque(false);

        //将五个Label加到panel上
        this.add(nameLabel);
        this.add(accountLabel);
        this.add(TELLabel);
        this.add(passwordLabel);

        // 设置JTextField
        nameField.setText(Mvo.getName());
        accountField.setText(MarketingID);
        TELField.setText(Mvo.getTelephone());
        passwordField.setText(Mvo.getPassword());

        nameField.setEditable(false);;
        accountField.setEditable(false);;
        TELField.setEditable(false);;
        passwordField.setEditable(false);;


        this.add(nameField);
        this.add(accountField);
        this.add(TELField);
        this.add(passwordField);

        //加入确认图标
        MJButton ensureLabel=new MJButton(344,390, 60, 60,ensureIcon);
        ensureLabel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String newTEL=TELField.getText(),newPassword=passwordField.getText();
                Mvo.setTelephone(newTEL);Mvo.setPassword(newPassword);
                controller.MarketingAccountUpdate(Mvo);
                ensureLabel.setEnabled(false);
			}
           });
        ensureLabel.setEnabled(false);
        this.add(ensureLabel);

        //设置TELmodifyJButton图标与监听
        MJButton modifyLabelForTEL=new MJButton(550, 215, 60, 60,modifyIcon);
        modifyLabelForTEL.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ensureLabel.setEnabled(true);
				TELField.setEditable(true);
			}
        });
        this.add(modifyLabelForTEL);

        //设置PasswordmodifyMJButton图标与监听
        MJButton modifyLabelForPassword=new MJButton(550, 293, 60, 60,modifyIcon);
        modifyLabelForPassword.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ensureLabel.setEnabled(true);
				passwordField.setEditable(true);
			}
        });
        this.add(modifyLabelForPassword);

        this.repaint();
        panel.add(this);
	}

	public void profileButtonClicked() {
        this.setVisible(true);
        this.revalidate();
        this.repaint();
	}

    public void hideProfile(){
    	this.removeAll();
        this.setVisible(false);
    }
}
