package hotel.management.system;
import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import java.sql.*;	
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FoodInfo extends JFrame {
	Connection conn = null;
	private JPanel contentPane;
	private JLabel lblRoom;
	private JLabel lblFood;
	private JLabel lblQuantity;
        private JTable table;
	private JLabel lblDate;
	private JLabel lblTime;
	private JLabel lblAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodInfo frame = new FoodInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		this.dispose();
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FoodInfo() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(450, 510, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
                                    conn c  = new conn();
                                    
				String displayCustomersql = "select * from FoodOrder";
				ResultSet rs = c.s.executeQuery(displayCustomersql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
			
		});
		btnLoadData.setBounds(300, 510, 120, 30);
                btnLoadData.setBackground(Color.BLACK);
                btnLoadData.setForeground(Color.WHITE);
		contentPane.add(btnLoadData);
		
		lblRoom = new JLabel("Room number");
		lblRoom.setBounds(70, 20, 65, 14);
		contentPane.add(lblRoom);
                
                /*JLabel l1 = new JLabel("Number");
		l1.setBounds(150, 11, 46, 14);
		contentPane.add(l1);*/
		
		lblFood = new JLabel("Food");
		lblFood.setBounds(230, 20, 46, 14);
		contentPane.add(lblFood);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(340, 20, 65, 14);
		contentPane.add(lblQuantity);
		
		table = new JTable();
		table.setBounds(0, 40, 900, 450);
		contentPane.add(table);
		
		lblDate = new JLabel("Date");
		lblDate.setBounds(460, 20, 46, 14);
		contentPane.add(lblDate);
		
		lblTime = new JLabel("Time");
		lblTime.setBounds(620, 20, 65, 14);
		contentPane.add(lblTime);
		
		lblAmount = new JLabel("Amount");
		lblAmount.setBounds(770, 20, 100, 14);
		contentPane.add(lblAmount);             
                getContentPane().setBackground(Color.WHITE);
	}
}
