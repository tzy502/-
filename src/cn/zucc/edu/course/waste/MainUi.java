package cn.zucc.edu.course.waste;

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
import java.awt.event.ActionEvent;
import cn.zucc.edu.course.UI.*;
public class MainUi {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUi window = new MainUi();
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
	public MainUi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JButton btnNewButton_1 = new JButton("\u5356\u8F66");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u627E\u8F66\u8F86");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u6DFB\u52A0\u8F66\u8F86");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//		NewCar newcar=new NewCar();
			}
		});
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("\u8F66\u8F86\u6302\u724C");
		panel.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("\u5237\u65B0");
		panel.add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
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
		
		JMenuItem sellcarmeun = new JMenuItem("\u8F66\u8F86\u6302\u724C");
		sellMenu.add(sellcarmeun);
		
		JMenuItem sellrecordmeun = new JMenuItem("\u4EA4\u6613\u8BB0\u5F55");
		sellMenu.add(sellrecordmeun);
		
		JMenu useMenu = new JMenu("\u7528\u6237\u64CD\u4F5C");
		menuBar.add(useMenu);
		
		JMenuItem modifrypasswordmeun = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		useMenu.add(modifrypasswordmeun);
		
		JMenuItem modifryusermeun = new JMenuItem("\u4FEE\u6539\u5E10\u53F7");
		useMenu.add(modifryusermeun);
	}

}
