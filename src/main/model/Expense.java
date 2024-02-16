package model;

import java.util.ArrayList;


public class Expense implements Parent {

    private int expense;
    private ArrayList<Integer> listOfExpense = new ArrayList<>();
    private String category;
    private ArrayList<String> listOfCategory = new ArrayList<>();
    private ArrayList<Integer> listExpenseCategoryWise = new ArrayList<>();


    public Expense() {
        expense = 0;
    }

    public void addMoney(int expense) {
        this.expense += expense;
        addExpenseToList(expense);
    }

    public ArrayList<Integer> view() {
        return listOfExpense;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public void addExpenseToList(int expense) {
        listOfExpense.add(expense);
    }

    public void addCategoryToList(String category) {
        listOfCategory.add(category);
    }

    public ArrayList<String> getCategoryList() {
        return listOfCategory;
    }

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

