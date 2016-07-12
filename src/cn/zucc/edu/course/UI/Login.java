package cn.zucc.edu.course.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.zucc.edu.course.control.UserManager;
import cn.zucc.edu.course.util.BaseException;

public class Login {
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	public Login(){
		frame = new JFrame("µÇÂ¼");
		frame.setBounds(100, 100, 320, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel ID = new JLabel("\u5E10\u53F7");
		ID.setBounds(42, 20, 54, 15);
		panel.add(ID);
		
		JLabel passwordl = new JLabel("\u5BC6\u7801");
		passwordl.setBounds(42, 58, 54, 15);
		panel.add(passwordl);
		
		textField = new JTextField();
		textField.setBounds(80, 15, 196, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(80, 53, 196, 25);
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton RegisterButton = new JButton("\u6CE8\u518C");
		panel_1.add(RegisterButton);
		RegisterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				Register rs=new Register();				
			}	
		});	

		
		JButton LoginButton = new JButton("\u767B\u5165");
		panel_1.add(LoginButton);
		LoginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				UserManager um=new UserManager();
				String userid=textField.getText();
				if (userid.equals("")){
					userid=null;
				}
				String password=passwordField.getText();
				try {
					if(um.loginuser(userid, password)==true){
						frame.setVisible(false);
						MainUi ui=new MainUi();
						String[] args = null;
						MainUi.main(args);
					}
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		});	
		JButton ForgetpasswordButton_2 = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		panel_1.add(ForgetpasswordButton_2);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		frame.setLocation((int) (width - frame.getWidth()) / 2,
				(int) (height - frame.getHeight()) / 2);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

