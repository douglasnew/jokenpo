/**
 * 
 */
package bdutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author douglas
 *
 */
public class BDUtil {
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "root";
	
	/**
	 * Cria conexao com banco de dados MySql
	 */
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jokenpo", USER, PASSWORD);

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	/**
	 * Fechar conexao com banco de dados
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			
			if (conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}

}
