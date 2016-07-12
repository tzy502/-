package cn.zucc.edu.course.UI;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import cn.zucc.edu.course.control.CarBrandManage;
import cn.zucc.edu.course.control.CarLineManager;
import cn.zucc.edu.course.model.Carbrand;
import cn.zucc.edu.course.util.BusinessException;
import cn.zucc.edu.course.util.DbException;

public class NewCarLinformation {
	private JFrame frame;
	private JTextField carlineField;
	CarLineManager clm=new CarLineManager();
	CarBrandManage cbm=new CarBrandManage();
	public NewCarLinformation(){
		frame = new JFrame("增加车系");
		frame.setBounds(100, 100, 374, 278);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		frame.setLocation((int) (width - frame.getWidth()) / 2,
				(int) (height - frame.getHeight()) / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		JButton okButton = new JButton("\u786E\u5B9A");

		panel.add(okButton);

		JLabel label = new JLabel("             ");
		panel.add(label);

		JButton cancel = new JButton("\u53D6\u6D88");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		panel.add(cancel);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel brandlabel = new JLabel("\u54C1\u724C\uFF1A");
		brandlabel.setBounds(30, 13, 54, 15);
		panel_1.add(brandlabel);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(94, 10, 88, 21);
		panel_1.add(comboBox);
		List<Carbrand> totalcabrandr=new ArrayList<Carbrand>();
		try {
			totalcabrandr=cbm.loadCarbrand();
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<totalcabrandr.size();i++){
			comboBox.addItem(totalcabrandr.get(i).getBrandname());
		}
		JLabel lblNewLabel_1 = new JLabel("\u8F66\u7CFB\u4ECB\u7ECD\uFF1A");
		lblNewLabel_1.setBounds(30, 80, 119, 15);
		panel_1.add(lblNewLabel_1);

		carlineField = new JTextField();
		carlineField.setBounds(94, 45, 110, 21);
		panel_1.add(carlineField);
		carlineField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("\u8F66\u7CFB\u540D\uFF1A");
		lblNewLabel_2.setBounds(30, 48, 54, 15);
		panel_1.add(lblNewLabel_2);

		final JTextArea carlineArea = new JTextArea();
		carlineArea.setLineWrap(true);
		carlineArea.setBounds(30, 105, 308, 83);
		panel_1.add(carlineArea);
		carlineArea.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carbrand cb=new Carbrand();
				String brandname= (String) comboBox.getSelectedItem();
				int id=comboBox.getSelectedIndex()+1;

				try {
					clm.createCarLine(carlineField.getText(), id,carlineArea.getText(), brandname);
					frame.setVisible(false);
				} catch (BusinessException | DbException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}
}
