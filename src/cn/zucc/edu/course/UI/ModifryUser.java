package cn.zucc.edu.course.UI;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import cn.zucc.edu.course.control.UserManager;
import cn.zucc.edu.course.model.User;
import cn.zucc.edu.course.util.BaseException;

public class ModifryUser {
	private JFrame frame;
	private JTextField IDField;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField emailField;
	private JTextField TELField;
	UserManager um=new UserManager();
	public ModifryUser(final User user){
		System.out.println(user.getUserid());
		frame = new JFrame("修改用户");
		frame.setTitle("\u6CE8\u518C");
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		frame.setBounds((int)(width-420)/2, (int)(height-420)/2, 420, 420);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setAlwaysOnTop(true);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		JButton btnNewButton_1 = new JButton("修改");
		panel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("        ");
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("\u53D6\u6D88");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				
			}	
		});	
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel IDlabel = new JLabel("\u5E10\u53F7:");
		IDlabel.setHorizontalAlignment(SwingConstants.LEFT);
		IDlabel.setBounds(40, 30, 54, 15);
		panel_1.add(IDlabel);

		JLabel nameLABEL = new JLabel("\u59D3\u540D:");
		nameLABEL.setBounds(40, 55, 54, 15);
		panel_1.add(nameLABEL);

		JLabel password1 = new JLabel("\u5BC6\u7801:");
		password1.setBounds(40, 80, 54, 15);
		panel_1.add(password1);

		JLabel password2 = new JLabel("\u91CD\u590D\u5BC6\u7801:");
		password2.setBounds(40, 105, 61, 15);
		panel_1.add(password2);

		JLabel emilelabel = new JLabel("E-mail:");
		emilelabel.setBounds(40, 130, 54, 15);
		panel_1.add(emilelabel);

		JLabel TELLabel_5 = new JLabel("TEL:");
		TELLabel_5.setBounds(40, 155, 54, 15);
		panel_1.add(TELLabel_5);

		IDField = new JTextField(user.getUserid());
		IDField.setBounds(111, 30, 234, 21);
		panel_1.add(IDField);
		IDField.setColumns(10);
		IDField.setEnabled(false);
		
		nameField = new JTextField(user.getUsername());
		nameField.setColumns(10);
		nameField.setBounds(111, 55, 234, 21);
		panel_1.add(nameField);
		
		
		
		passwordField = new JPasswordField(user.getPassword());
		passwordField.setBounds(111, 80, 234, 21);
		panel_1.add(passwordField);
		passwordField.setEnabled(false);

		passwordField_1 = new JPasswordField(user.getPassword());
		passwordField_1.setBounds(111, 105, 234, 21);
		panel_1.add(passwordField_1);
		passwordField_1.setEnabled(false);
		
		
		emailField = new JTextField(user.getEmail());
		emailField.setColumns(10);
		emailField.setBounds(111, 130, 234, 21);
		panel_1.add(emailField);

		TELField = new JTextField(user.getTEL());
		TELField.setBounds(111, 155, 234, 21);
		panel_1.add(TELField);
		TELField.setColumns(10);

		JLabel sexLabel = new JLabel("\u6027\u522B");
		sexLabel.setBounds(40, 180, 54, 15);
		panel_1.add(sexLabel);

		final JRadioButton manbutton = new JRadioButton("\u7537");
		manbutton.setBounds(83, 176, 45, 23);
		panel_1.add(manbutton);

		JRadioButton womanbutton = new JRadioButton("\u5973");
		womanbutton.setBounds(130, 176, 45, 23);
		panel_1.add(womanbutton);
		if(user.getUsersex()==1){
			manbutton.setSelected(true);
		}
		else
			manbutton.setSelected(true);
	//	if(user)
		
		ButtonGroup sexBG=new ButtonGroup();
		sexBG.add(manbutton);
		sexBG.add(womanbutton);
		final JComboBox agecomboBox = new JComboBox();
		agecomboBox.setBounds(240, 177, 85, 21);
		for(int i=18;i<=80;i++){
			agecomboBox.addItem(i);
		}
		int age=user.getUserage();
		
		agecomboBox.setSelectedItem(age);
		panel_1.add(agecomboBox);

		JLabel agelabel = new JLabel("\u5E74\u9F84");
		agelabel.setBounds(196, 180, 54, 15);
		panel_1.add(agelabel);

		JLabel addressLabel = new JLabel("\u5730\u5740:");
		addressLabel.setBounds(40, 205, 54, 15);
		panel_1.add(addressLabel);

		final JTextArea textArea = new JTextArea(user.getAddress());
		textArea.setLineWrap(true);
		textArea.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		textArea.setBounds(40, 230, 308, 96);
		panel_1.add(textArea);
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				User newuser=new User();
				newuser.setUserid(user.getUserid());
				String username;
				username=nameField.getText();
				if(username.equals("")){
					username=null;
				}	
				newuser.setUsername(username);
				
				String password=passwordField.getText();
				if(password.equals("")){
					password=null;
				}
				String password2=passwordField_1.getText();
				newuser.setPassword(password);
				
				String tel=TELField.getText();
				if(tel.equals("")){
					tel=null;
				}
				newuser.setTEL(tel);
				String address=textArea.getText();
				if(address.equals("")){
					address=null;
				}
				newuser.setAddress(address);
				String email=emailField.getText();
				if(email.equals("")){
					email=null;
				}
				newuser.setEmail(email);
				newuser.setUsertype(user.getUsertype());
				int sex;
				if(manbutton.isSelected()==true){
					newuser.setUsersex(1);
				}
				else
					newuser.setUsersex(0);
				
				int age=(int) agecomboBox.getSelectedItem();
				newuser.setUserage(age);
				try {
					um.ModfiryUser(newuser);
					frame.setVisible(false);
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}	
		});	
		
		
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
