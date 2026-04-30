package menuDriven;

import preparedStatements.*;
import java.sql.*;
import java.util.Scanner;

public class MenuDB {
	
	public static void main(String[] args) {

		MenuDB md = new MenuDB();
		try(Scanner sc = new Scanner(System.in)){
		int choice;
			while (true) {
				System.out.println("\n===== MENU =====");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. Fetch All");
                System.out.println("5. Fetch One");
                System.out.println("6. Exit");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                
				switch(choice) {
                case 1:
                    md.insertData(sc);
                    break;

                case 2:
                    md.updateData(sc);
                    break;

                case 3:
                    md.deleteData(sc);
                    break;

                case 4:
                    md.fetchAll();
                    break;

                case 5:
                    md.fetchOne(sc);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
                
				}
			}

		}

	private void fetchOne(Scanner sc) {
		
		String sqlSelOne = "select * from students where id = ?";
		
		try(Connection con = JDBCUtil.getConnection();  
				PreparedStatement pstmt = con.prepareStatement(sqlSelOne)){
			
			System.out.println("Enter Id to Fetch Record: ");
			int id = sc.nextInt();
			
			pstmt.setInt(1, id);
			
			try (ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getInt("age") + " " +
                            rs.getString("city")
                    );
                } else {
                    System.out.println("No record found");
                }
			}
			
		}catch (SQLException e) {
            e.printStackTrace();
        }
	}

	private void fetchAll() {
		String sqlSelAll = "select * from students";
		
		try(Connection con = JDBCUtil.getConnection();  
				PreparedStatement pstmt = con.prepareStatement(sqlSelAll);
				ResultSet rs = pstmt.executeQuery()){
			
			System.out.println("All Records: ");
			boolean found = false;
			while(rs.next()) {
				 found = true;
				 System.out.println(
                         rs.getInt("id") + " " +
                         rs.getString("name") + " " +
                         rs.getInt("age") + " " +
                         rs.getString("city")
                 );
			}
			if(!found) {
				System.out.println("Record not found");
			}
			
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	private void deleteData(Scanner sc) {

		String sqlDelete = "Delete from students where id = ?";
		
		try(Connection con = JDBCUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sqlDelete)){
			
		
		System.out.println("Enter Id to Delete a Record: ");
		int id = sc.nextInt();
		
		pstmt.setInt(1, id);
		
		int n = pstmt.executeUpdate();
		
		if(n!=0) {
			System.out.println("Record deleted successfully");
		}
		else {
			System.out.println("Record not found");
		}
		} catch(SQLException s) {
			s.printStackTrace();
		}
		
	}

	private void updateData(Scanner sc) {
		String sqlUpdate = "Update students set city=? where id = ?";
		
		try(Connection con = JDBCUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sqlUpdate)){
			
		
		System.out.println("Enter Id to Update a Record: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter City to Update in Record: ");
		String city = sc.nextLine();
		
		pstmt.setString(1, city);
		pstmt.setInt(2, id);
		
		int n = pstmt.executeUpdate();
		
		if(n!=0) {
			System.out.println("Record updated successfully");
		}
		else {
			System.out.println("Record not found");
		}
		} catch(SQLException s) {
			s.printStackTrace();
		}
		
	}

	private void insertData(Scanner sc) {
		
		String sqlInsert = "Insert into students(id,name,age,city) values(?,?,?,?)";
		
		try(Connection con = JDBCUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sqlInsert)){
			
		
		System.out.println("Enter Id: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Name: ");
		String name = sc.nextLine();

		System.out.println("Enter Age: ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter City: ");
		String city = sc.nextLine();
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, age);
		pstmt.setString(4, city);
		
		int n = pstmt.executeUpdate();
		
		if(n!=0) {
			System.out.println("Record inserted successfully");
		}
		else {
			System.out.println("Record not inserted");
		}
		} catch(SQLException s) {
			s.printStackTrace();
		
	}
	}
}
