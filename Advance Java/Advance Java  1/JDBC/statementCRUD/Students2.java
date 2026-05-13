package statementCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Students2 {

	public void insertData(int id, String name, int age, String city) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
		
		Statement stmt = con.createStatement();
		
		int res = stmt.executeUpdate(
			    "INSERT INTO students VALUES (" + id + ", '" 
			    + name + "', " + age + ", '" 
			    + city + "')"
			);
		
		if(res>0) {
			System.out.println("Data Inserted Successfully !!!!");
		}
		else {
			System.err.println("Data Not Inserted !!!!");
		}
		con.close();
	}
	
	public void updateData(int id, String name, int age, String city) throws Exception {

	    Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection con = DriverManager.getConnection(
	        "jdbc:mysql://localhost:3306/mydb", "root", "root"
	    );

	    Statement stmt = con.createStatement();

	    int res = stmt.executeUpdate(
	        "UPDATE students SET name = '" + name + 
	        "', age = " + age + 
	        ", city = '" + city + 
	        "' WHERE id = " + id
	    );

	    if (res > 0) {
	        System.out.println("Data Updated Successfully !!!!");
	    } else {
	        System.err.println("Data Not Updated !!!!");
	    }

	    con.close();
	}
	
	public void deleteData(int id) throws Exception {

	    Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection con = DriverManager.getConnection(
	        "jdbc:mysql://localhost:3306/mydb", "root", "root"
	    );

	    Statement stmt = con.createStatement();

	    int res = stmt.executeUpdate(
	        "DELETE FROM students WHERE id = " + id
	    );

	    if (res > 0) {
	        System.out.println("Data Deleted Successfully !!!!");
	    } else {
	        System.err.println("Data Not Deleted !!!!");
	    }

	    con.close();
	}

	public static void main(String[] args) throws Exception {

	    // Create object of your class
	    Students2 obj = new Students2();

	    // Insert 5 records
	    obj.insertData(1, "Ajay", 23, "Pune");
	    obj.insertData(2, "Sujay", 24, "Mumbai");
	    obj.insertData(3, "Rohit", 26, "Nagpur");
	    obj.insertData(4, "Virat", 28, "Delhi");
	    obj.insertData(5, "Amit", 25, "Nashik");

	    // Update a record
	    obj.updateData(3, "Rohit Sharma", 27, "Nagpur");

	    // Deleting records
	    obj.deleteData(2);
	    obj.deleteData(5);
	}
}