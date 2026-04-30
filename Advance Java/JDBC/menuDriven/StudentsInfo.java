package menuDriven;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import preparedStatements.JDBCUtil;

public class StudentsInfo {

    // Insert Records
    public void insertData(Scanner sc) {

        String sql = "INSERT INTO students(id, name, age, city) VALUES(?,?,?,?)";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            System.out.print("Enter City: ");
            String city = sc.next();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, city);

            int n = ps.executeUpdate();

            System.out.println(n > 0 ? "Insert successful" : "Insert failed");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Records
    public void updateData(Scanner sc) {

        String sql = "UPDATE students SET name=? WHERE id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter ID to update: ");
            int id = sc.nextInt();

            System.out.print("Enter new Name: ");
            String name = sc.next();

            ps.setString(1, name);
            ps.setInt(2, id);

            int n = ps.executeUpdate();

            System.out.println(n > 0 ? "Update successful" : "No record found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Record
    public void deleteData(Scanner sc) {

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter ID to delete: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            int n = ps.executeUpdate();

            System.out.println(n > 0 ? "Delete successful" : "No record found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch All Records
    public void fetchAll() {

        String sql = "SELECT * FROM students";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- All Records ---");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getInt("age") + " " +
                        rs.getString("city")
                );
            }

            if (!found)
                System.out.println("No data found");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Fetch One Record
    public void fetchOne(Scanner sc) {

        String sql = "SELECT * FROM students WHERE id=?";

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter ID to fetch: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        StudentsInfo st = new StudentsInfo();
        Scanner sc = new Scanner(System.in);

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

            switch (choice) {

                case 1:
                    st.insertData(sc);
                    break;

                case 2:
                    st.updateData(sc);
                    break;

                case 3:
                    st.deleteData(sc);
                    break;

                case 4:
                    st.fetchAll();
                    break;

                case 5:
                    st.fetchOne(sc);
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