
package hotel.management.system;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FoodOrder extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,r1;
      
        JComboBox comboBox;
        
        Choice c1,cn;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodOrder frame = new FoodOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FoodOrder() throws SQLException {
		
                setBounds(530, 200, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/2.jpg"));
                Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(480,10,300,500);
                add(l1);
                JLabel lblName = new JLabel("FOOD ORDER");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);
		
		
		JLabel lblNewLabel = new JLabel("Room Number:");
		lblNewLabel.setBounds(35, 76, 200, 14);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from customer");
                    while(rs.next()){
                        c1.add(rs.getString("roomnumber"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(271, 76, 150, 20);
		contentPane.add(c1);
                
    
                JLabel lblFood = new JLabel("Food:");
		lblFood.setBounds(35, 111, 200, 14);
		contentPane.add(lblFood);
                
                cn = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from foodname");
                    while(rs.next()){
                        cn.add(rs.getString("food"));    
                    }
                }catch(Exception e){ }
                cn.setBounds(271, 111, 150, 20);
		contentPane.add(cn);
              
		JLabel lblName_1 = new JLabel("Quantity :");
		lblName_1.setBounds(35, 151, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);
                  t2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });
                

                
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(35, 191, 200, 14);
		contentPane.add(lblDate);
                
                r1 = new JTextField();
		r1.setBounds(271, 191, 150, 20);
		contentPane.add(r1);
		r1.setColumns(10);
                
                
                JLabel lblTime = new JLabel("Time :");
		lblTime.setBounds(35, 231, 200, 14);
		contentPane.add(lblTime);
                
                t5 = new JTextField();
		t5.setBounds(271, 231, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);
                
                JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setBounds(35, 271, 200, 14);
		contentPane.add(lblAmount);
                
                t4 = new JTextField();
		t4.setBounds(271, 271, 150, 20);
		contentPane.add(t4);
		t4.setColumns(10);
                t4.addKeyListener(new KeyAdapter() {
                   
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });
        

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            conn c = new conn();
                            String radio = null;
                            
                            
                            String s6 = c1.getSelectedItem();
                            String s1 = cn.getSelectedItem();
                          
                            try{
	    			
	    			String s3 =  t2.getText();
                      
	    			String s5 =  r1.getText();
	    			String s7 =  t5.getText();
                                String s8 =  t4.getText();
                                
                                String q1 = "insert into FoodOrder values('"+s6+"','"+s1+"','"+s3+"','"+s5+"','"+s7+"','"+s8+"')";
                              
                                c.s.executeUpdate(q1);
                               
	    			JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                                new Reception().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}
		});
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new Reception().setVisible(true);
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}
