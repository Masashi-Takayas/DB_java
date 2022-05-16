import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbExam4 {

	public static void main(String[] args) {
		String param = "地球儀";
		int param2 = 101;


		Connection con = null;
		PreparedStatement stmt = null;

		try {
			// load JDBC Driver
			Class.forName("org.postgresql.Driver");
			// database connect
			con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

	// SQL query string
			String sql = "SELECT * FROM products WHERE product_name = ? OR product_id = ?";
			// create statement
			stmt = con.prepareStatement(sql);
			stmt.setString(1, param);
			stmt.setInt(2, param2);
			// execute
			ResultSet rs = stmt.executeQuery();

			// output
			while (rs.next()) {
				int product_id = rs.getInt("product_id");
				String product_name = rs.getString("product_name");
				int price = rs.getInt("price");

				
				System.out.print("product_id:"+product_id);
				System.out.print(",product_name:"+product_name);
				System.out.println(",price:"+price);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
