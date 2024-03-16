
package hotel.management.system;
import java.sql.*;  
public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/hotelmanagementsystem"; 
            c =DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","Aarthipoornimaa51827");             
            s =c.createStatement();  
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  