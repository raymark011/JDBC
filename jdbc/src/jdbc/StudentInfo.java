/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author User
 */
public class StudentInfo {
    private int eid;
    private String efirstname;
    private String elastname;
    private int eage;
    public void askdata(String data){
        System.out.println("Enter " + data + ":");
    }
    public void setID(int id){
        this.eid = id;
    }
    public int getID(){
        return this.eid;
    }
    public void input(){
    Scanner in = new Scanner(System.in);
        askdata("Student ID");
        setID(in.nextInt());
        askdata("Student First Name");
        this.efirstname = in.next();
        askdata("Student Last Name");
        this.elastname = in.next();
        askdata("Student Age");
        this.eage = in.nextInt();
        insert();
    }
    public void insert(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "");
    Statement st = con.createStatement();
    String sql = "insert into studentinfo values(" + getID() + ",'" + this.efirstname + "','" + this.elastname + "'," + this.eage + ")";
    st.executeUpdate(sql);
    con.close();
    }
    catch(Exception e){System.out.println(e);}
    }
}

