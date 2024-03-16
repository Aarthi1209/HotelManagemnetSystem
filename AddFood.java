
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.awt.event.KeyListener;

public class AddFood extends JFrame implements ActionListener{

    private final JPanel contentPane;
    private final JTextField t2;
    private JTextField t4;
    //private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;
   // Choice c1;

    public static void main(String[] args) {
        new AddFood().setVisible(true);
    }
    public AddFood() {
        setBounds(450, 200, 1000, 450);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/foods.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(400,30,500,370);
                add(l15);
        
        JLabel l10 = new JLabel("Add Food");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
	l10.setBounds(194, 10, 120, 22);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("Food");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(64, 70, 102, 22);
	contentPane.add(l1);
        
        t4 = new JTextField();
	t4.setBounds(174, 70, 156, 20);
	contentPane.add(t4);
        t4.addKeyListener(new KeyAdapter() {
                 @Override
                 public void keyPressed(KeyEvent e) {
               char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                t4.setText("");
                JOptionPane.showMessageDialog(null, "Enter Alphabet Only !");
                                     }
                                            }
    });
		
        

	
	JLabel l4 = new JLabel("Price");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(64, 190, 102, 22);
	contentPane.add(l4);
        
        t2 = new JTextField();
	t2.setBounds(174, 190, 156, 20);
	contentPane.add(t2);
        t2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });

        

	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                conn c = new conn();
                String a = t4.getText();
                //String available = (String)comboBox.getSelectedItem();
                //String status = (String)comboBox_2.getSelectedItem();
                String b  = t2.getText();
                //String type = (String)comboBox_3.getSelectedItem();
                String str = "INSERT INTO foodname values( '"+a+"', '"+b+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Food Successfully Added");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
}
