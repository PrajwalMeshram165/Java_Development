import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    public void addExpense(Expense expense) throws SQLException {
        String sql = "INSERT INTO expenses (category, description, amount, date) VALUES (?, ?, ?, ?)";  //new
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setString(1, expense.getCategory());                                                  //new
            stmt.setString(2, expense.getDescription());
            stmt.setDouble(3, expense.getAmount());
            stmt.setString(4, expense.getDate());
            stmt.executeUpdate();
        }
    }

    public List<Expense> getAllExpenses() throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Expense expense = new Expense(
                	rs.getString("category"),	
                    rs.getString("description"),
                    rs.getDouble("amount"),
                    rs.getString("date")
                );
                expense.setId(rs.getInt("id"));
                expenses.add(expense);
            }
        }
        return expenses;
    }
}

