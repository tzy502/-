package cn.zucc.edu.course.waste;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import com.eltima.components.ui.DatePicker;

import cn.zucc.edu.course.control.CarBaseManage;
import cn.zucc.edu.course.control.CarLineManager;
import cn.zucc.edu.course.control.CarListeingManage;
import cn.zucc.edu.course.model.Carbase;
import cn.zucc.edu.course.model.Carlinformation;
import cn.zucc.edu.course.util.DbException;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewListing {

	private JFrame frame;
	private JTextField textField;
	CarBaseManage cbm=new CarBaseManage();
	CarLineManager clm=new CarLineManager();
	private static final String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
	private Font font=new Font("Times New Roman", Font.BOLD, 14);
	private Dimension dimension=new Dimension(177,24);
	private DatePicker cardtime;	
	CarListeingManage clfm=new CarListeingManage();
	List<Carbase> total=new ArrayList<Carbase>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewListing window = new NewListing();
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
	public NewListing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");

		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");//取消
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8981\u5356\u7684\u8F66");
		lblNewLabel.setBounds(44, 35, 54, 15);
		panel_1.add(lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		
		try {
			total=cbm.QryCarbyuserid("root");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<total.size();i++){
			if (total.get(i).isCaelisting()==false){
				System.out.println(i);
				Carlinformation cl=new Carlinformation();
				try {
					cl=clm.SearchCarlinebyid(total.get(i).getCarlineid());
				} catch (DbException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				comboBox.addItem(cl.getBrand()+"  "+cl.getCarlinename()+"  "+total.get(i).getCarcolor());
			}

		}
		comboBox.setBounds(154, 32, 225, 21);
		
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("\u5356\u8F66\u622A\u81F3\u65F6\u95F4");
		lblNewLabel_1.setBounds(44, 70, 84, 15);
		panel_1.add(lblNewLabel_1);
		
		Date date=new Date();
		cardtime = new DatePicker(date,DefaultFormat,font,dimension);
		cardtime.setBounds(154, 63, 225, 21);
		cardtime.setLocale(Locale.CHINA);
		cardtime.setTimePanleVisible(false);
		panel_1.add(cardtime);
		
		JLabel lblNewLabel_2 = new JLabel("\u770B\u8F66\u65B9\u5F0F");
		lblNewLabel_2.setBounds(44, 105, 54, 15);
		panel_1.add(lblNewLabel_2);
		
		final JRadioButton local = new JRadioButton("\u73B0\u573A\u770B\u8F66");
		local.setSelected(true);
		local.setBounds(115, 101, 90, 23);
		panel_1.add(local);
		
		JRadioButton faraway = new JRadioButton("\u8FDC\u7A0B\u770B\u8F66");
		faraway.setBounds(207, 101, 121, 23);
		panel_1.add(faraway);
		ButtonGroup levelBG=new ButtonGroup();
		levelBG.add(local);
		levelBG.add(faraway);
		
		
		JLabel lblNewLabel_3 = new JLabel("\u8F66\u8F86\u4ECB\u7ECD");
		lblNewLabel_3.setBounds(44, 130, 54, 15);
		panel_1.add(lblNewLabel_3);
		
		final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(44, 155, 340, 124);
		panel_1.add(textArea);
		textArea.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//确定
				int id=comboBox.getSelectedIndex();
				int carid=total.get(id).getCarid();
//				int userid=userid;
				String userid="root";
				String Sellinformation=textArea.getText();
				Date selltime=(Date)cardtime.getValue();
				int realprice=total.get(id).getRealprice();
				int carage=total.get(id).getCarage();
				String transmissiontype=total.get(id).getTransmissiontype();
				String cartype=total.get(id).getCartype();
				int seeway;
				if(local.isSelected()==true){
					seeway=0;
				}
				else
					seeway=1;
				
				try {
					clfm.createcarlisteing(carid, userid, Sellinformation, selltime, realprice, carage,	transmissiontype, cartype, seeway,total.get(id));
					frame.setVisible(false);
				} catch (DbException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
