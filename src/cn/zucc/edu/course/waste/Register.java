package cn.zucc.edu.course.waste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class Register {

	private JFrame frame;
	private JTextField IDField;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField emailField;
	private JTextField TELField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6CE8\u518C");
		frame.setBounds(100, 100, 420, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("        ");
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		panel.add(btnNewButton);
		
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
		
		IDField = new JTextField();
		IDField.setBounds(111, 30, 234, 21);
		panel_1.add(IDField);
		IDField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(111, 55, 234, 21);
		panel_1.add(nameField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 80, 234, 21);
		panel_1.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(111, 105, 234, 21);
		panel_1.add(passwordField_1);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(111, 130, 234, 21);
		panel_1.add(emailField);
		
		TELField = new JTextField();
		TELField.setBounds(111, 155, 234, 21);
		panel_1.add(TELField);
		TELField.setColumns(10);
		
		JLabel sexLabel = new JLabel("\u6027\u522B");
		sexLabel.setBounds(40, 180, 54, 15);
		panel_1.add(sexLabel);
		
		JRadioButton manbutton = new JRadioButton("\u7537");
		manbutton.setSelected(true);
		manbutton.setBounds(83, 176, 45, 23);
		panel_1.add(manbutton);
		
		JRadioButton womanbutton = new JRadioButton("\u5973");
		womanbutton.setBounds(130, 176, 45, 23);
		panel_1.add(womanbutton);
		ButtonGroup sexBG=new ButtonGroup();
		sexBG.add(manbutton);
		sexBG.add(womanbutton);
		JComboBox agecomboBox = new JComboBox();
		agecomboBox.setBounds(240, 177, 85, 21);
		for(int i=18;i<=80;i++){
			agecomboBox.addItem(i);
		}
		agecomboBox.setSelectedItem(20);
		panel_1.add(agecomboBox);
		
		JLabel agelabel = new JLabel("\u5E74\u9F84");
		agelabel.setBounds(196, 180, 54, 15);
		panel_1.add(agelabel);
		
		JLabel addressLabel = new JLabel("\u5730\u5740:");
		addressLabel.setBounds(40, 205, 54, 15);
		panel_1.add(addressLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		textArea.setBounds(40, 230, 308, 96);
		panel_1.add(textArea);
	}
}
