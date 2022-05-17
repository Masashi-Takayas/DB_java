import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbExam5 {
	public static void main(String[] args) {

		String insert = "INSERT INTO products(product_name,price) values ('ボールペン',200);";


		Connection con = null;
		PreparedStatement stmt = null;

		try {
			// load JDBC Driver
			Class.forName("org.postgresql.Driver");
			// database connect
			con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");

			// SQL query string
			String sql = "SELECT * FROM products";
			
			// create statement
			stmt = con.prepareStatement(sql);

		
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

