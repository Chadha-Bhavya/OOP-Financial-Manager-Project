package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//Represents Expenses of the user along with the category of expense
public class Expense implements Parent, Writable {

    private int expense;
    private ArrayList<Integer> listOfExpense = new ArrayList<>();
    private String category;
    private ArrayList<String> listOfCategory = new ArrayList<>();
    private ArrayList<Integer> listExpenseCategoryWise = new ArrayList<>();


    // EFFECTS: Sets the expense = 0
    public Expense() {
        expense = 0;
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: Adds amount to expense and calls addExpenseToList function with amount
    @Override
    public void addMoney(int amount) {
        this.expense += amount;
        addExpenseToList(amount);
    }


    // EFFECTS: Returns an ArrayList of all the expenses till now, empty list if no expense
    @Override
    public ArrayList<Integer> view() {
        return listOfExpense;
    }


    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }


    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: Adds amount to the listOfExpense
    public void addExpenseToList(int amount) {
        listOfExpense.add(amount);
    }


    // MODIFIES: this
    // EFFECTS: Adds category to the list storing category of all the expenses
    public void addCategoryToList(String category) {
        listOfCategory.add(category);
    }


    // EFFECTS: Returns an ArrayList of categories of all expenses till now
    public ArrayList<String> getCategoryList() {
        return listOfCategory;
    }


    // EFFECTS: Returns a list of expenses which belongs to a specific category,
    //          empty list if no expense belongs to the specific category.
    public ArrayList<Integer> categoryExpense(String category) {
        int i = 0;
        listExpenseCategoryWise.clear();

        for (String s : listOfCategory) {
            if (s == category) {
                listExpenseCategoryWise.add(listOfExpense.get(i));
            }
            i++;
        }

        return listExpenseCategoryWise;

    }

}






