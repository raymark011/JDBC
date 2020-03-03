/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;
import java.sql.*;
/**
 *
 * @author User
 */
public class jdbctestA {
    
    
    public static void main(String[] args){
    
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JDBC", "root", "");
            
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("select * from emptable");
            while(rs.next()){
            System.out.println(rs.getInt(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4));
            }
            con.close();
        }
        catch(Exception e){System.out.print(e);}
    }
}
