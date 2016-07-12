package cn.zucc.edu.course.waste;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import cn.zucc.edu.course.control.CarBrandManage;
import cn.zucc.edu.course.util.BaseException;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCarBrand {

	private JFrame frame;
	private JTextField nameField;
	private JTextField country;
	CarBrandManage cbm=new CarBrandManage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCarBrand window = new NewCarBrand();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewCarBrand() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("ÐÂ½¨Æ·ÅÆ");
		frame.setBounds(100, 100, 280, 230);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		frame.setLocation((int) (width - frame.getWidth()) / 2,
				(int) (height - frame.getHeight()) / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("\u6DFB\u52A0");


		panel.add(okButton);
		
		JButton cancel = new JButton("\u53D6\u6D88");
		panel.add(cancel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u54C1\u724C\u540D\uFF1A");
		lblNewLabel.setBounds(23, 17, 54, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u54C1\u724C\u56FD\u5BB6\uFF1A");
		lblNewLabel_1.setBounds(23, 42, 70, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u54C1\u724C\u4ECB\u7ECD\uFF1A");
		label.setBounds(23, 67, 70, 15);
		panel_1.add(label);
		
		nameField = new JTextField();
		nameField.setBounds(87, 17, 153, 21);
		panel_1.add(nameField);
		nameField.setColumns(10);
		
		country = new JTextField();
		country.setColumns(10);
		country.setBounds(87, 42, 153, 21);
		panel_1.add(country);
		
		final JTextArea introduct = new JTextArea();
		introduct.setLineWrap(true);
		introduct.setBounds(21, 92, 219, 57);
		panel_1.add(introduct);
		introduct.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=nameField.getText();
			String Courtry=country.getText();
			String Introduct=introduct.getText();
			try {
				cbm.createCarBrand(name, Courtry, Introduct);
				frame.setVisible(false);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
	}
}
