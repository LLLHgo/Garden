package presentation.client.compoment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SearchPanel extends JPanel{
	private ImageIcon imageIcon = null;
	private JTextField searchField;
	private SearchButton searchButton;
	public SearchPanel(){
		imageIcon = new ImageIcon("image/searchPanel.png");
		searchField=new JTextField();
		searchButton=new SearchButton();
		searchField.setBounds(72, 18, 450, 50);
		searchField.setBorder(new EmptyBorder(0,0,0,0));
		searchField.setFont(new java.awt.Font("微软雅黑", 4,  25));
		searchField.setForeground(Color.WHITE);
		searchField.setOpaque(false);
		searchField.setFocusable(true);
		this.add(searchButton);
		this.add(searchField);
		this.setVisible(false);
	    this.setLayout(null);
	    this.setSize(704, 502);
	    this.setOpaque(false);
	}
	private class searchButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String info=searchField.getText();
		}

	}
	@Override
	public void paintComponent(Graphics g) {
		    g.drawImage(imageIcon.getImage(), 0, 0, this);
		    super.paintComponents(g);
		   }
}
