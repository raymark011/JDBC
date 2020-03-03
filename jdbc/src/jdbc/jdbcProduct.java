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
public class jdbcProduct {
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
    
    System.out.println("Enter User ID: ");
        int uid = in.nextInt();
        System.out.println("Enter Username: ");
        String username = in.next();
        System.out.println("Enter Amount: ");
        double amount = in.nextDouble();
        System.out.println("Enter Quantity: ");
        int quantity = in.nextInt();
        System.out.println("Enter Cash: ");
        double cash = in.nextDouble();
        double total = amount * quantity;
        double changed = cash - total;
        insert(uid, username, amount, quantity, cash, total, changed);
    }
    
    static void insert(int uid, String username, double amount, int quantity, double cash, double total, double changed){
    
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "");
            Statement st = con.createStatement();
            String sql = "insert into jdbcproduct values(" + uid + ",'" + username + "'," + amount + "," + quantity + "," + cash + "," +  total + "," + changed + ")";
            st.executeUpdate(sql);
            con.close();
        }catch(Exception e){System.out.print(e);}
    }
}
