package statementCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Students {

    public void insertData() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "root", "root"
        );

        Statement stmt = con.createStatement();

        int res = stmt.executeUpdate(
                "INSERT INTO students VALUES (101, 'Ajay', 23, 'Male', 'Pune', 'Maharashtra', 'India', " +
                "'ajay@gmail.com', 9876543210, 'BCA', 78.5, '2023-06-01')"
        );

        if (res > 0) {
            System.out.println("Default Data Inserted !!!!");
        } else {
            System.err.println("Insert Failed !!!!");
        }

        con.close();
    }

   
    public void updateData() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "root", "root"
        );

        Statement stmt = con.createStatement();

        int res = stmt.executeUpdate(
                "UPDATE students SET name='Ajay Patil', age=24, city='Mumbai' WHERE id=101"
        );

        if (res > 0) {
            System.out.println("Default Data Updated !!!!");
        } else {
            System.err.println("Update Failed !!!!");
        }

        con.close();
    }

    
    public void deleteData() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "root", "root"
        );

        Statement stmt = con.createStatement();

        int res = stmt.executeUpdate(
                "DELETE FROM students WHERE id = 101"
        );

        if (res > 0) {
            System.out.println("Default Data Deleted !!!!");
        } else {
            System.err.println("Delete Failed !!!!");
        }

        con.close();
    }

    
    public static void main(String[] args) throws Exception {

        Students obj = new Students();

        obj.insertData();
        obj.updateData();
        obj.deleteData();
    }
}