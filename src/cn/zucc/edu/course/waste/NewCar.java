package cn.zucc.edu.course.waste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewCar {

	private JFrame frame;
	private JTextField transmissiontypeField;
	private JTextField carageField;
	private JTextField cardtimeField;
	private JTextField textField_3;
	private JTextField suggestedpriceField_4;
	private JTextField displacementField;
	private JTextField productionyearField;
	private JTextField travelmileageField;
	private JTextField realpriceField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCar window = new NewCar();
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
	public NewCar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("ÐÂ½¨³µÁ¾");
		frame.setBounds(100, 100, 493, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 419, 484, 33);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JLabel CarBrandLabel = new JLabel("\u54C1\u724C");
		CarBrandLabel.setBounds(58, 30, 54, 15);
		frame.getContentPane().add(CarBrandLabel);
		
		JLabel CarLineLabel = new JLabel("\u8F66\u7CFB");
		CarLineLabel.setBounds(235, 30, 54, 15);
		frame.getContentPane().add(CarLineLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(107, 30, 105, 21);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(281, 30, 105, 21);
		frame.getContentPane().add(comboBox_1);
		
		JLabel transmissiontypeLabel = new JLabel("\u53D8\u901F\u7BB1");
		transmissiontypeLabel.setBounds(58, 70, 54, 15);
		frame.getContentPane().add(transmissiontypeLabel);
		
		JLabel displacementLabel = new JLabel("\u6392\u91CF");
		displacementLabel.setBounds(235, 70, 54, 15);
		frame.getContentPane().add(displacementLabel);
		
		JLabel carageLabel = new JLabel("\u8F66\u9F84");
		carageLabel.setBounds(58, 110, 54, 15);
		frame.getContentPane().add(carageLabel);
		
		JLabel productionyearLabel = new JLabel("\u51FA\u5382\u5E74\u9F84");
		productionyearLabel.setBounds(235, 110, 54, 15);
		frame.getContentPane().add(productionyearLabel);
		
		JLabel cardtimeLabel = new JLabel("\u4E0A\u724C\u65F6\u95F4");
		cardtimeLabel.setBounds(58, 150, 54, 15);
		frame.getContentPane().add(cardtimeLabel);
		
		JLabel travelmileagelabel = new JLabel("\u884C\u9A76\u91CC\u7A0B");
		travelmileagelabel.setBounds(235, 150, 54, 15);
		frame.getContentPane().add(travelmileagelabel);
		
		JLabel carcolorLabel = new JLabel("\u8F66\u8272");
		carcolorLabel.setBounds(58, 227, 54, 15);
		frame.getContentPane().add(carcolorLabel);
		
		JLabel realpricelabel = new JLabel("\u5B9E\u9645\u4EF7\u683C");
		realpricelabel.setBounds(235, 190, 54, 15);
		frame.getContentPane().add(realpricelabel);
		
		JLabel suggestedpricelabel = new JLabel("\u5382\u5546\u5EFA\u8BAE\u4EF7");
		suggestedpricelabel.setBounds(58, 193, 72, 15);
		frame.getContentPane().add(suggestedpricelabel);
		
		JLabel carstatelabel = new JLabel("\u6C7D\u8F66\u72B6\u6001");
		carstatelabel.setBounds(58, 260, 54, 15);
		frame.getContentPane().add(carstatelabel);
		
		JTextArea carstateArea = new JTextArea();
		carstateArea.setBounds(58, 285, 328, 124);
		frame.getContentPane().add(carstateArea);
		
		transmissiontypeField = new JTextField();
		transmissiontypeField.setBounds(122, 64, 95, 21);
		frame.getContentPane().add(transmissiontypeField);
		transmissiontypeField.setColumns(10);
		
		carageField = new JTextField();
		carageField.setColumns(10);
		carageField.setBounds(122, 104, 95, 21);
		frame.getContentPane().add(carageField);
		
		cardtimeField = new JTextField();
		cardtimeField.setColumns(10);
		cardtimeField.setBounds(122, 144, 95, 21);
		frame.getContentPane().add(cardtimeField);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(122, 221, 95, 21);
		frame.getContentPane().add(textField_3);
		
		suggestedpriceField_4 = new JTextField();
		suggestedpriceField_4.setColumns(10);
		suggestedpriceField_4.setBounds(122, 187, 95, 21);
		frame.getContentPane().add(suggestedpriceField_4);
		
		displacementField = new JTextField();
		displacementField.setColumns(10);
		displacementField.setBounds(291, 67, 95, 21);
		frame.getContentPane().add(displacementField);
		
		productionyearField = new JTextField();
		productionyearField.setColumns(10);
		productionyearField.setBounds(291, 107, 95, 21);
		frame.getContentPane().add(productionyearField);
		
		travelmileageField = new JTextField();
		travelmileageField.setColumns(10);
		travelmileageField.setBounds(291, 147, 95, 21);
		frame.getContentPane().add(travelmileageField);
		
		realpriceField = new JTextField();
		realpriceField.setColumns(10);
		realpriceField.setBounds(291, 187, 95, 21);
		frame.getContentPane().add(realpriceField);
	}
}
