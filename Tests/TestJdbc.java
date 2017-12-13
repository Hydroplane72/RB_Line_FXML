

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class TestJdbc {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//database connection variables
		String jdbcUrl = "jdbc:mysql://localhost:3306/rockbottom_line?useSSL=false";
		String user = "regUser";
		String pass = "bn400446";
		
		
		//Try catch to catch any errors
		try {
			System.out.println("Connecting to database: " +jdbcUrl);
			
			Connection myConn = 
					(Connection) DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection Successful");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
