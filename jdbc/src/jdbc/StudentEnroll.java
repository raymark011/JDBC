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
public class StudentEnroll {
    private int sid;
    private int eid;
    private String section;
    private int grade;
    public void askdata(String data){
        System.out.println("Enter " + data + ":");
    }
    public void input2(){
    Scanner in = new Scanner(System.in);
        askdata("Enrollment ID");
        this.eid = in.nextInt();
        askdata("Student ID");
        this.sid = in.nextInt();
        askdata("Section");
        this.section = in.next();
        askdata("Grade");
        this.grade = in.nextInt();
        insert();
    }
    public void insert(){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "");
    Statement st = con.createStatement();
    String sql = "insert into studentenroll values(" + this.eid + "," + this.sid + ",'" + this.section + "'," + this.grade + ")";
    st.executeUpdate(sql);
    con.close();
    }
    catch(Exception e){System.out.println(e);}
    }
}
