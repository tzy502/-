package cn.zucc.edu.course.UI;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import cn.zucc.edu.course.UI.*;
import cn.zucc.edu.course.control.CarListeingManage;
import cn.zucc.edu.course.model.Listinginformation;
import cn.zucc.edu.course.model.User;
import cn.zucc.edu.course.util.DbException;
public class MainUi {

	private JFrame frame;
	private JTable table;
	CarListeingManage clm=new CarListeingManage();
	Object tblData[][];
	Object tblTitle[];
	Format format = new SimpleDateFormat("yyyy-MM-dd");
	DefaultTableModel tablmod=new DefaultTableModel();
	List<Listinginformation> lftotal=new ArrayList<Listinginformation>();
	public void reload() throws DbException{
		Listinginformation lf=new Listinginformation();
		lftotal=clm.Loadistinginformation();

		final Object  tblTitle[]={"\u8F66\u8F86\u7F16\u53F7", "\u7528\u6237", "\u51FA\u552E\u4FE1\u606F", "\u622A\u81F3\u65F6\u95F4", "\u4EF7\u683C", "\u8F66\u9F84", "\u53D8\u901F\u7BB1", "\u8F66\u8F86\u7C7B\u578B", "\u770B\u8F66\u65B9\u5F0F"};
		tblData =new Object[lftotal.size()][9];
		for(int i=0;i<lftotal.size();i++){


			tblData[i][0]=lftotal.get(i).getCarid();
			tblData[i][1]=lftotal.get(i).getUserid();
			tblData[i][2]=lftotal.get(i).getSellinformation();
			tblData[i][3]=format.format(lftotal.get(i).getSelltime());
			tblData[i][4]=lftotal.get(i).getRealprice();
			tblData[i][5]=lftotal.get(i).getCarage();
			tblData[i][6]=lftotal.get(i).getTransmissiontype();
			tblData[i][7]=lftotal.get(i).getCartype();
			if(lftotal.get(i).getSeeway()==0){
				tblData[i][8]="现场看车";
			}
			else
				tblData[i][8]="远程看车";

		}
		tablmod.setDataVector(tblData,tblTitle);
		table.validate();
		table.repaint();
	}

	public  MainUi(final User user) {
		frame = new JFrame("二手车交易");
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		frame.setBounds(0,0, (int)width-50, (int)height-50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JButton buycarbutton = new JButton("\u4E70\u8F66");
		panel.add(buycarbutton);

		JButton btnNewButton_2 = new JButton("\u67E5\u627E\u8F66\u8F86");
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u6DFB\u52A0\u8F66\u8F86");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCar newcar=new NewCar(user);
			}
		});
		panel.add(btnNewButton_3);

		JButton btnNewButton = new JButton("\u8F66\u8F86\u6302\u724C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Newlisting nl=new Newlisting(user);
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_4 = new JButton("\u5237\u65B0");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					reload();
				} catch (DbException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_4);
		table = new JTable(tablmod);
		try {
			reload();
		} catch (DbException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);



		//	scrollPane.setViewportView(table);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu buyMenu = new JMenu("\u4E70\u65B9\u64CD\u4F5C");
		menuBar.add(buyMenu);

		JMenuItem Newcarmenu = new JMenuItem("\u4E70\u8F66");
		buyMenu.add(Newcarmenu);

		JMenuItem SearchCarMenu = new JMenuItem("\u67E5\u8BE2");
		buyMenu.add(SearchCarMenu);

		JMenuItem BuyrecordMenu = new JMenuItem("\u4EA4\u6613\u8BB0\u5F55");
		buyMenu.add(BuyrecordMenu);

		JMenu sellMenu = new JMenu("\u5356\u65B9\u64CD\u4F5C");
		menuBar.add(sellMenu);

		JMenuItem addnewcarmeun = new JMenuItem("\u6DFB\u52A0\u8F66\u8F86");
		sellMenu.add(addnewcarmeun);
		addnewcarmeun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCar newcar=new NewCar(user);
			}
		});
		JMenuItem sellcarmeun = new JMenuItem("\u8F66\u8F86\u6302\u724C");
		sellMenu.add(sellcarmeun);

		sellcarmeun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Newlisting nl=new Newlisting(user);
			}
		});
		JMenuItem sellrecordmeun = new JMenuItem("\u8F66\u8F86\u8BB0\u5F55");
		sellMenu.add(sellrecordmeun);

		JMenu useMenu = new JMenu("\u7528\u6237\u64CD\u4F5C");
		menuBar.add(useMenu);

		JMenuItem modifrypasswordmeun = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		useMenu.add(modifrypasswordmeun);

		
		JMenuItem modifryusermeun = new JMenuItem("\u4FEE\u6539\u5E10\u53F7\u4FE1\u606F");
		useMenu.add(modifryusermeun);
		modifryusermeun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifryUser cb=new ModifryUser(user);
			}
		});
		JMenu mnNewMenu = new JMenu("管理员操作");
		menuBar.add(mnNewMenu);

		JMenuItem newbrand = new JMenuItem("\u65B0\u5EFA\u54C1\u724C");
		newbrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCarBrand cb=new NewCarBrand();
			}
		});
		mnNewMenu.add(newbrand);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u65B0\u5EFA\u8F66\u7CFB");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCarLinformation cb=new NewCarLinformation();
			}
		});
		JMenuItem mntmNewMenuItem = new JMenuItem("\u65B0\u5EFA\u8F66\u7C7B\u578B");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u51BB\u7ED3\u7528\u6237");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Newcartpye cb=new Newcartpye();
			}
		});
		frame.setVisible(true);
	}

}
