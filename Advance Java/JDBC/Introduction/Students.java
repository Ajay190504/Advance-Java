package Introduction;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Students {

    public static void main(String[] args) throws Exception {
        
        // 1. Creating a connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
        
        // 2. Creating a statement 
        Statement s = con.createStatement();
        
        // 3. Inserting Data into Table Students
//        int i = s.executeUpdate("insert into students (id, name, age, city) values (1, 'Ajay', 21, 'Pune')");
//        
//        if(i > 0) {
//            System.out.println("Data Added Successfully....");
//        } else {
//            System.err.println("Some Error Occurred! Data not Added!!....");
//        }
        
//        // 4. Deleting data from Table Students
//        int i2 = s.executeUpdate("DELETE FROM students WHERE id=1 LIMIT 1");
//        if(i2 > 0) {
//            System.out.println("Data Deleted Successfully....");
//        } else {
//            System.err.println("Some Error Occurred! Data not deleted!!....");
//        }
        
//        // 5. Updating data in Table Students
        int i3 = s.executeUpdate("UPDATE students SET city='Barshi' WHERE name='Ajay'");
        if(i3 > 0) {
            System.out.println("Data Updated Successfully....");
        } else {
            System.err.println("Some Error Occurred! Data not updated!!....");
        }
        
        // 4. Always close database connection (Moved inside the method)
        con.close();
    }
}
