package cn.zucc.edu.course.waste;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import cn.zucc.edu.course.control.CarTypeManage;
import cn.zucc.edu.course.util.BusinessException;
import cn.zucc.edu.course.util.DbException;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCartype {

	private JFrame frame;
	private JTextField nametextField;
	private JTextField usetextField;
	CarTypeManage ctm=new CarTypeManage();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCartype window = new NewCartype();
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
	public NewCartype() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("新建车用途");
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");

		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel cartypenameLabel = new JLabel("\u8F66\u8F86\u7C7B\u578B\u540D");
		cartypenameLabel.setBounds(38, 31, 67, 15);
		panel_1.add(cartypenameLabel);
		
		nametextField = new JTextField();
		nametextField.setBounds(115, 28, 153, 21);
		panel_1.add(nametextField);
		nametextField.setColumns(10);
		
		JLabel cartypeuseLabel_1 = new JLabel("\u8F66\u8F86\u7528\u9014");
		cartypeuseLabel_1.setBounds(38, 66, 67, 15);
		panel_1.add(cartypeuseLabel_1);
		
		usetextField = new JTextField();
		usetextField.setColumns(10);
		usetextField.setBounds(115, 63, 153, 21);
		panel_1.add(usetextField);
		
		JLabel cartypeuselabel = new JLabel("\u8F66\u7C7B\u4ECB\u7ECD");
		cartypeuselabel.setBounds(38, 101, 54, 15);
		panel_1.add(cartypeuselabel);
		
		final JTextArea cartypeuseArea = new JTextArea();
		cartypeuseArea.setLineWrap(true);
		cartypeuseArea.setBounds(38, 126, 296, 78);
		panel_1.add(cartypeuseArea);
		cartypeuseArea.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name=nametextField.getText();
					if(name.equals("")){
						name=null;
					}
					ctm.createManage(name, cartypeuseArea.getText(), usetextField.getText());
					frame.setVisible(false);
				
				} catch (BusinessException | DbException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
	}
}
