package cn.zucc.edu.course.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.eltima.components.ui.DatePicker;

import cn.zucc.edu.course.control.CarBaseManage;
import cn.zucc.edu.course.control.CarBrandManage;
import cn.zucc.edu.course.control.CarLineManager;
import cn.zucc.edu.course.control.CarTypeManage;
import cn.zucc.edu.course.model.Carbrand;
import cn.zucc.edu.course.model.Carlinformation;
import cn.zucc.edu.course.model.Cartype;
import cn.zucc.edu.course.model.User;
import cn.zucc.edu.course.util.BusinessException;
import cn.zucc.edu.course.util.DbException;

public class NewCar {
	CarBaseManage carbm=new CarBaseManage();
	private JFrame frame;
	private JTextField transmissiontypeField;
	private JTextField carageField;
	private JTextField cardtimeField;
	private JTextField colorField;
	private JTextField suggestedpriceField_4;
	private JTextField displacementField;
	private JTextField productionyearField;
	private JTextField travelmileageField;
	private JTextField realpriceField;
	CarLineManager clm=new CarLineManager();
	CarBrandManage cbm=new CarBrandManage();
	CarTypeManage ctm=new CarTypeManage();
	List<Carlinformation> totalcarline=new ArrayList<Carlinformation>();
	List<Carbrand> totalcabrandr=new ArrayList<Carbrand>();
	private static final String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
	private Font font=new Font("Times New Roman", Font.BOLD, 14);
	private Dimension dimension=new Dimension(177,24);
	private DatePicker cardtime;	
	Date date=new Date();
	
	public NewCar(final User user) {
		frame = new JFrame("新建车辆");
		frame.setBounds(100, 100, 493, 492);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 419, 484, 33);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");

		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		panel.add(btnNewButton);
		
		JLabel CarBrandLabel = new JLabel("\u54C1\u724C");
		CarBrandLabel.setBounds(58, 30, 54, 15);
		frame.getContentPane().add(CarBrandLabel);
		
		JLabel CarLineLabel = new JLabel("\u8F66\u7CFB");
		CarLineLabel.setBounds(235, 30, 54, 15);
		frame.getContentPane().add(CarLineLabel);
		
		final JComboBox brandcomboBox = new JComboBox();
		brandcomboBox.setBounds(107, 30, 105, 21);
		frame.getContentPane().add(brandcomboBox);
		
		try {
			totalcabrandr=cbm.loadCarbrand();
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<totalcabrandr.size();i++){
			brandcomboBox.addItem(totalcabrandr.get(i).getBrandname());
		}
		
		//下拉框操作

		
		final JComboBox linecomboBox = new JComboBox();
		linecomboBox.setBounds(281, 30, 105, 21);
		brandcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				linecomboBox.removeAllItems();
				Carbrand cb=new Carbrand();			
				int id=brandcomboBox.getSelectedIndex()+1;			
				try {
					totalcarline=clm.SearchCarlinebycarband(id);
					for(int i=0;i<totalcarline.size();i++){
						linecomboBox.addItem(totalcarline.get(i).getCarlinename());					
					}
				} catch (DbException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.repaint();

			}
		});
		
		
		final JComboBox cartypecomboBox = new JComboBox();
		List<Cartype> totalcartype=new ArrayList<Cartype>();
		try {
			totalcartype =ctm.LoadCar();
		} catch (DbException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=0;i<totalcartype.size();i++){
			cartypecomboBox.addItem(totalcartype.get(i).getCartypename());		
		}
		cartypecomboBox.setBounds(107, 67, 105, 21);
		frame.getContentPane().add(cartypecomboBox);
		frame.getContentPane().add(linecomboBox);
		
		JLabel transmissiontypeLabel = new JLabel("\u53D8\u901F\u7BB1");
		transmissiontypeLabel.setBounds(58, 190, 54, 15);
		frame.getContentPane().add(transmissiontypeLabel);
		
		JLabel displacementLabel = new JLabel("\u6392\u91CF");
		displacementLabel.setBounds(235, 70, 54, 15);
		frame.getContentPane().add(displacementLabel);
		
		JLabel carageLabel = new JLabel("\u8F66\u9F84");
		carageLabel.setBounds(58, 110, 54, 15);
		frame.getContentPane().add(carageLabel);
		
		JLabel productionyearLabel = new JLabel("\u51FA\u5382\u65F6\u95F4");
		productionyearLabel.setBounds(235, 110, 54, 15);
		frame.getContentPane().add(productionyearLabel);
		
		JLabel cardtimeLabel = new JLabel("\u4E0A\u724C\u65F6\u95F4");
		cardtimeLabel.setBounds(58, 150, 54, 15);
		frame.getContentPane().add(cardtimeLabel);
		
		JLabel travelmileagelabel = new JLabel("\u884C\u9A76\u91CC\u7A0B");
		travelmileagelabel.setBounds(235, 150, 54, 15);
		frame.getContentPane().add(travelmileagelabel);
		
		JLabel carcolorLabel = new JLabel("\u8F66\u8272");
		carcolorLabel.setBounds(235, 230, 54, 15);
		frame.getContentPane().add(carcolorLabel);
		
		JLabel realpricelabel = new JLabel("\u5B9E\u9645\u4EF7\u683C");
		realpricelabel.setBounds(58, 230, 54, 15);
		frame.getContentPane().add(realpricelabel);
		
		JLabel suggestedpricelabel = new JLabel("\u5382\u5546\u5EFA\u8BAE\u4EF7");
		suggestedpricelabel.setBounds(227, 189, 72, 15);
		frame.getContentPane().add(suggestedpricelabel);
		
		JLabel carstatelabel = new JLabel("\u6C7D\u8F66\u72B6\u6001");
		carstatelabel.setBounds(58, 260, 54, 15);
		frame.getContentPane().add(carstatelabel);
		
		final JTextArea carstateArea = new JTextArea();
		carstateArea.setBorder(new LineBorder(new java.awt.Color(127,157,185), 1, false));
		carstateArea.setForeground(Color.BLACK);
		carstateArea.setLineWrap(true);
		carstateArea.setBounds(58, 285, 328, 124);
		frame.getContentPane().add(carstateArea);
		
		transmissiontypeField = new JTextField();
		transmissiontypeField.setBounds(107, 189, 110, 21);
		frame.getContentPane().add(transmissiontypeField);
		transmissiontypeField.setColumns(10);
		
		carageField = new JTextField();
		carageField.setColumns(10);
		carageField.setBounds(107, 104, 110, 21);
		frame.getContentPane().add(carageField);
		
//		cardtimeField = new JTextField();
//		cardtimeField.setColumns(10);
//		cardtimeField.setBounds(107, 144, 110, 21);
//		add(cardtimeField);
		
		Date date=new Date();
		cardtime = new DatePicker(date,DefaultFormat,font,dimension);
		cardtime.setBounds(107, 144, 110, 21);
		cardtime.setLocale(Locale.CHINA);
		cardtime.setTimePanleVisible(false);
		frame.getContentPane().add(cardtime);
		
		
		colorField = new JTextField();
		colorField.setColumns(10);
		colorField.setBounds(291, 227, 95, 21);
		frame.getContentPane().add(colorField);
		
		suggestedpriceField_4 = new JTextField();
		suggestedpriceField_4.setColumns(10);
		suggestedpriceField_4.setBounds(291, 186, 95, 21);
		frame.getContentPane().add(suggestedpriceField_4);
		
		displacementField = new JTextField();
		displacementField.setColumns(10);
		displacementField.setBounds(291, 67, 95, 21);
		frame.getContentPane().add(displacementField);
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(291, 107, 95, 21);
		for(int i=2000;i<2051;i++){
			comboBox.addItem(i);
		}
		frame.getContentPane().add(comboBox);
		
//		productionyearField = new JTextField();
//		productionyearField.setColumns(10);
//		productionyearField.setBounds(291, 107, 95, 21);
//		frame.getContentPane().add(productionyearField);
		
		travelmileageField = new JTextField();
		travelmileageField.setColumns(10);
		travelmileageField.setBounds(291, 147, 95, 21);
		frame.getContentPane().add(travelmileageField);
		
		realpriceField = new JTextField();
		realpriceField.setColumns(10);
		realpriceField.setBounds(107, 227, 110, 21);
		frame.getContentPane().add(realpriceField);
		
		JLabel cartypelabel = new JLabel("\u8F66\u7C7B\u578B");
		cartypelabel.setBounds(58, 70, 54, 15);
		frame.getContentPane().add(cartypelabel);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cartypeid=cartypecomboBox.getSelectedIndex()+1;
				int carlineboxid=linecomboBox.getSelectedIndex();
				int carlineid=totalcarline.get(carlineboxid).getCarlineid();
				String transmissiontype=transmissiontypeField.getText();
				if(transmissiontype.equals(""))
					transmissiontype=null;
				String cartype=(String) cartypecomboBox.getSelectedItem();
				String displacementstring=displacementField.getText();
				int displacement;
				if(displacementstring.equals("")){
					displacement=-1;
				}
				else{
					displacement=Integer.valueOf(displacementstring);
				}
				int carage;
				String carageString=carageField.getText();
				if(carageString.equals("")){
					carage=-1;
				}
				else{
					carage=Integer.valueOf(carageField.getText());
				}
				int productionyear=(int)comboBox.getSelectedItem();
				System.out.println(productionyear);
				Date cardtime1=(Date)cardtime.getValue();
				String travelmileageString=travelmileageField.getText();
				int travelmileage;
				if(travelmileageString.equals("")){
					travelmileage=-1;
				}
				else{
					travelmileage=Integer.valueOf(travelmileageField.getText());
				}
				String carcolor=colorField.getText();
				if(carcolor.equals(""))
					carcolor=null;
				String suggestedpriceString=suggestedpriceField_4.getText();
				int suggestedprice;
				if(suggestedpriceString.equals("")){
					suggestedprice=-1;
				}
				else{
					suggestedprice=Integer.valueOf(suggestedpriceField_4.getText());
				}
				String realpriceString=realpriceField.getText();
				int realprice;
				if(realpriceString.equals("")){
					realprice=-1;
				}
				else{
					realprice=Integer.valueOf(realpriceField.getText());
				}
				String carstate=carstateArea.getText();
				try {
					carbm.createcar(user.getUserid(),cartypeid, carlineid, transmissiontype, cartype, displacement,carage, productionyear, cardtime1, travelmileage, carcolor, suggestedprice,realprice, carstate);
					frame.setVisible(false);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DbException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
