package preparedStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsInfo {

	// Insert Records
	public void insertData() {

		String sql = "INSERT INTO students(id, name, age, city) VALUES(?,?,?,?)";

		try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, 1);
			ps.setString(2, "Ajay");
			ps.setInt(3, 21);
			ps.setString(4, "Barshi");
			ps.addBatch();

			ps.setInt(1, 2);
			ps.setString(2, "Jay");
			ps.setInt(3, 21);
			ps.setString(4, "Pune");
			ps.addBatch();

			ps.setInt(1, 4);
			ps.setString(2, "Danny");
			ps.setInt(3, 21);
			ps.setString(4, "Dharashiv");
			ps.addBatch();

			int[] result = ps.executeBatch();

			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i] == 0 ? "Insert failed at batch " + i : "Insert success at batch " + i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Records
	public void updateData() {

		String sql = "UPDATE students SET name=? WHERE id=?";

		try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, "Sujay");
			ps.setInt(2, 2);
			ps.addBatch();

			ps.setString(1, "Danny Updated");
			ps.setInt(2, 4);
			ps.addBatch();

			int[] result = ps.executeBatch();

			for (int i = 0; i < result.length; i++) {
				System.out.println(result[i] == 0 ? "Update failed at batch " + i : "Update success at batch " + i);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete Records
	public void deleteData(int id) {

		String sql = "DELETE FROM students WHERE id=?";

		try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			int n = ps.executeUpdate();

			System.out.println(n == 0 ? "Delete failed" : "Delete successful");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Fetch all Records
	public void fetchAll() {

		String sql = "SELECT * FROM students";

		try (Connection con = JDBCUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			System.out.println("\n--- All Records ---");

			boolean found = false;

			while (rs.next()) {
				found = true;
				System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age") + " "
						+ rs.getString("city"));
			}

			if (!found) {
				System.out.println("No data found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Fetch one Record
	public void fetchOne(int id) {

		String sql = "SELECT * FROM students WHERE id=?";

		try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				System.out.println("\n--- Fetch Record ID = " + id + " ---");

				if (rs.next()) {
					System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age") + " "
							+ rs.getString("city"));
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

		// Insert Records
		st.insertData();

		// Update Records
		st.updateData();

		// Fetch All Records
		st.fetchAll();

		// Fetch One Record
		st.fetchOne(1);

		// Delete Record
		st.deleteData(2);
	}
}