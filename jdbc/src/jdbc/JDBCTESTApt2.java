/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class JDBCTESTApt2 {
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
    
        System.out.println("Enter User ID: ");
        int uid = in.nextInt();
        System.out.println("Enter First Name: ");
        String fname = in.next();
        System.out.println("Enter Last Name: ");
        String lname = in.next();
        System.out.println("Enter Adress: ");
        String address = in.next();
        insert(uid, fname, lname, address);
    }
    
    static void insert(int uid, String fname, String lname, String address){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "");
            Statement st = con.createStatement();
            String sql = "insert into jdbctesta values(" + uid + ",'" + fname + "','" + lname + "','" + address + "')";
            st.executeUpdate(sql);
            con.close();
        }
        catch(Exception e){System.out.print(e);}
    }
}
