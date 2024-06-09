//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLDataException;
//import java.sql.SQLException;
//@SuppressWarnings("unused")
//public class DatabaseConnection { 
//	private static final String URL ="jdbc:mysql://localhost:3306/expense_traker";
//	private static final String USER = "root";
//	private static final String PASSWORD = "Pmking@165";
//	
//	
//	public static Connection getConnection() {
//		try {
//			return DriverManager.getConnection(URL, USER, PASSWORD);
//		}catch(SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
    private static final String USER = "root";
    private static final String PASSWORD = "Pmking@165";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}


