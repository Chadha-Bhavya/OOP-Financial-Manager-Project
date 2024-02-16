package ui;

import java.util.*;
import model.*;

public class FinanceManagementSystem {

    private Scanner input = new Scanner(System.in);
    private Income income = new Income();
    private Expense expense = new Expense();
    private boolean bool = false;
    private Special special;

    public FinanceManagementSystem() {
        runSystem();
    }




    private void runSystem() {
        boolean keepGoing = true;
        String command = null;
        input.useDelimiter("\n");

        while (keepGoing) {

            if ((bool) &&  (special.exceededBudget(expense.getExpense()))) {
                System.out.println("");
                System.out.println("ALERT! BUDGET LIMIT EXCEDED EITHER SPEND LESS OR INCREASE LIMIT!");
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


    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add Income");
        System.out.println("\ts -> Subtract Expense");
        System.out.println("\ti -> View Income");
        System.out.println("\te -> View Expense");
        System.out.println("\tb-> View Budget");
        System.out.println("\tl-> SetLimit");
        System.out.println("\tc-> categoryExpense");
        System.out.println("\tq -> quit");
    }

    private String displayMenu2() {
        System.out.println("\nSelect from:");
        System.out.println("\th-> Housing");
        System.out.println("\tf -> Food");
        System.out.println("\tr -> Recreation");
        System.out.println("\tt -> Transportation");
        System.out.println("\ti-> HealthCare and Insurance");
        System.out.println("\tm -> Miscellaneous");
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

    private void processCommand(String val) {
        int amount;
        String category;
        if (val.equals("a")) {
            addingIncome();
        } else if (val.equals("s")) {
            subtractingExpense();
        } else if (val.equals("i")) {
            System.out.println(income.view());
        } else if (val.equals("e")) {
            System.out.println(expense.view());
        } else if (val.equals("b")) {
            amount = (income.getIncome() - expense.getExpense());
            System.out.println(amount);
        } else if (val.equals("l")) {
            budgetLimit();
        } else if (val.equals("c")) {
            category = displayMenu2();
            System.out.println(expense.categoryExpense(category));
        } else {
            System.out.println("Please select the right key");
        }

    }

    private void addingIncome() {
        int amount;
        System.out.println("Enter amount to add: $");
        amount = input.nextInt();
        income.addMoney(amount);
        System.out.println("Job Done!");
    }

    private void subtractingExpense() {
        int amount;
        String category;
        System.out.println("Enter amount to subtract: $");
        amount = input.nextInt();
        category = displayMenu2();
        expense.addMoney(amount);
        expense.addCategoryToList(category);
        System.out.println("Job Done!");
    }

    private void budgetLimit() {
        int amount;
        System.out.println("Enter Budget Limit: $");
        amount = input.nextInt();
        special = new Special(amount);
        bool = true;
    }

}
