import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    String type; // "Expense" or "Income"
    double amount;
    String description;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }
}

class Tracker {
    ArrayList<Transaction> transactions;

    public Tracker() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(String type, double amount, String description) {
        Transaction transaction = new Transaction(type, amount, description);
        transactions.add(transaction);
    }

    public double calculateBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            if (transaction.type.equals("Income")) {
                balance += transaction.amount;
            } else {
                balance -= transaction.amount;
            }
        }
        return balance;
    }

    public void displayTransactions() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactions) {
            System.out.println(
                    transaction.type + " - Amount: " + transaction.amount + " - Description: " + transaction.description);
        }
    }
}

public class ExpenseIncomeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();

        while (true) {
            System.out.println("\nExpense/Income Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Add Income");
            System.out.println("3. View Transactions");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter expense amount: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter expense description: ");
                    String expenseDescription = scanner.nextLine();
                    tracker.addTransaction("Expense", expenseAmount, expenseDescription);
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    System.out.print("Enter income amount: ");
                    double incomeAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter income description: ");
                    String incomeDescription = scanner.nextLine();
                    tracker.addTransaction("Income", incomeAmount, incomeDescription);
                    System.out.println("Income added successfully!");
                    break;

                case 3:
                    tracker.displayTransactions();
                    break;

                case 4:
                    double balance = tracker.calculateBalance();
                    System.out.println("Current Balance: " + balance);
                    break;

                case 5:
                    System.out.println("Exiting Expense/Income Tracker. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
