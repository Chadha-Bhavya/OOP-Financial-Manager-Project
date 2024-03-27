package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

// Finance Management System
public class FinanceManagementSystem {

    private Scanner input = new Scanner(System.in);
    private Earning earning = new Earning();
    private Expense expense = new Expense();
    private boolean bool = false;
    private ExpenseLimit expenseLimit = new ExpenseLimit();
    private JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private JsonReader jsonReader = new JsonReader(JSON_STORE);
    private static final String JSON_STORE = "./data/appdata.json";


    //EFFECTS: runs the FinanceManagement System Application
    public FinanceManagementSystem() {
        runSystem();
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    private void runSystem() {
        boolean keepGoing = true;
        String command = null;
        input.useDelimiter("\n");

        while (keepGoing) {

            if ((bool) &&  (expenseLimit.exceededExpense(expense.getExpense()))) {
                System.out.println("ALERT! EXPENSE LIMIT EXCEEDED EITHER SPEND LESS OR INCREASE LIMIT!");
            }

            displayMenu();
            command = input.next();
            command = command.toLowerCase();


            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("GoodBye!");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add Earning");
        System.out.println("\ts -> Add Expense");
        System.out.println("\ti -> View Earning");
        System.out.println("\te -> View Expense");
        System.out.println("\tb-> View Net Earning");
        System.out.println("\tl-> Set Expense Limit");
        System.out.println("\tc-> View Expenses by Category");
        System.out.println("\t1 -> save work room to file");
        System.out.println("\t2 -> load work room to file");
        System.out.println("\tq -> Quit");
    }


    // EFFECTS: displays menu of category to user and returns the result of processCategory() method
    private String displayMenu2() {
        System.out.println("\nSelect from:");
        System.out.println("\th-> Housing");
        System.out.println("\tf -> Food");
        System.out.println("\tr -> Recreation");
        System.out.println("\tt -> Transportation");
        System.out.println("\ti-> HealthCare and Insurance");
        System.out.println("\tm -> Miscellaneous");
        return processCategory();
    }

    // EFFECTS: takes input from user and returns the category selected by user
    private String processCategory() {
        String command2 = null;
        command2 = input.next();
        command2 = command2.toLowerCase();
        if (command2.equals("h")) {
            return "Housing";
        } else if (command2.equals("f")) {
            return "Food";
        } else if (command2.equals("r")) {
            return "Recreation";
        } else if (command2.equals("t")) {
            return "Transportation";
        } else if (command2.equals("i")) {
            return "HealthCare and Insurance";
        } else {
            return "Miscellaneous";
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String val) {
        String category;
        if (val.equals("a")) {
            addEarning();
        } else if (val.equals("s")) {
            addExpense();
        } else if (val.equals("i")) {
            System.out.println(earning.view());
        } else if (val.equals("e")) {
            System.out.println(expense.view());
        } else if (val.equals("b")) {
            System.out.println((earning.getEarning() - expense.getExpense()));
        } else if (val.equals("l")) {
            expenseLimit();
        } else if (val.equals("c")) {
            category = displayMenu2();
            System.out.println(expense.categoryExpense(category));
        } else if (val.equals("1")) {
            saveExpense();
        } else if (val.equals("2")) {
            loadExpense();
        } else {
            System.out.println("Please select the right key");
        }

    }

    // MODIFIES: this
    // EFFECTS: adds user earning to the system
    private void addEarning() {
        int amount;
        System.out.print("Enter amount to add to earning: $");
        amount = input.nextInt();
        earning.addMoney(amount);
        System.out.println("Job Done!");
    }

    // MODIFIES: this
    // EFFECTS: adds user expense to the system
    private void addExpense() {
        int amount;
        String category;
        System.out.print("Enter amount to add to expense: $");
        amount = input.nextInt();
        category = displayMenu2();
        expense.addMoney(amount);
        expense.addCategoryToList(category);
        System.out.println("Job Done!");
    }

    // MODIFIES: this
    // EFFECTS: sets user expense limit in the system
    private void expenseLimit() {
        int amount;
        System.out.print("Enter Expense Limit: $");
        amount = input.nextInt();
        expenseLimit.setExpenseLimit(amount);
        bool = true;
    }

    // EFFECTS: saves the data to file
    private void saveExpense() {
        try {
            jsonWriter.open();
            jsonWriter.write(earning, expense, expenseLimit);
            jsonWriter.close();
            System.out.println("Saved your Financial Transaction to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads data from file
    private void loadExpense() {
        try {
            earning = jsonReader.readEarning();
            expense = jsonReader.readExpense();
            expenseLimit = jsonReader.readExpenseLimit();
            bool = true;
        } catch (IOException e) {
            System.out.println("Loaded your Financial Transaction from" + JSON_STORE);
        }
    }

}