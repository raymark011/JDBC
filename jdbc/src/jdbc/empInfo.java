package jdbc;

import java.sql.*;
import java.util.Scanner;

public class empInfo{

	int empID;
	String fname;
	String lname;
	int rank;
	String position;
	String department;
	Double salary;


public static void main(String[] args) { 

	empInfo i = new empInfo();
        i.userInput();
        i.insert();
        AnotherClass ac = new AnotherClass();
        System.out.println(ac.getmsg());
	
}

public void userInput(){

	Scanner in = new Scanner(System.in);

	System.out.println("Enter ID: ");
        this.empID = in.nextInt();
        askdata("First Name");
        this.fname = in.next();
        askdata("Last Name");
        this.lname = in.next();
        askdata("Rank");
        this.rank = in.nextInt();
        askdata("Position");
        this.position = in.next();
        askdata("Department");
        this.department = in.next();
        if(rank == 1)
        {
            salary = 25000.0;
        }
        else if(rank == 2)
        {
            salary = 15000.0;
        }
        else if(rank == 3)
        {
            salary = 12000.0;
        }
        else {
            salary = 0.0;
        }
        System.out.println(this.salary);
}
    public void askdata(String data){
        System.out.println("Enter " + data + ":");
    }
    public void insert(){
        try{
            //Establishing a connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost/jdbc","root","");
            Statement st = con.createStatement();
            String sql = "insert into employeetbl values (" + this.empID + ",'" + 
                    this.fname + "','" + this.lname + "'," + this.rank + 
                    ",'" + this.position + "','"+ this.department + "'," + this.salary + ")";
            st.executeUpdate(sql);    
            con.close();
        } catch(Exception e){System.out.print(e);}
    }
}