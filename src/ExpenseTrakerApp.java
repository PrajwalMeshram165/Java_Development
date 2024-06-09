import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ExpenseTrakerApp {

    private static final ExpenseDAO expenseDAO = new ExpenseDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addExpense() {
    	 System.out.print("Enter category: ");
         String category = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.next();
        
        Expense expense = new Expense(category, description, amount, date);
        try {
            expenseDAO.addExpense(expense);
            System.out.println("Expense added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewExpenses() {
        try {
            List<Expense> expenses = expenseDAO.getAllExpenses();
            for (Expense expense : expenses) {
                System.out.println("ID: " + expense.getId());
                System.out.println("Category: " + expense.getCategory());
                System.out.println("Description: " + expense.getDescription());
                System.out.println("Amount: " + expense.getAmount());
                System.out.println("Date: " + expense.getDate());
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
