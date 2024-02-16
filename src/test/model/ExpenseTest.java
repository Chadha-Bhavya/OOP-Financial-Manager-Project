package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseTest {
    private Expense expense;
    private ArrayList<Integer> listOfExpense;
    private ArrayList<String> listOfCategory;


    @BeforeEach

    void runBefore() {

        expense = new Expense();
        listOfExpense = new ArrayList<>();
        listOfCategory = new ArrayList<>();

    }

    @Test
    void testAllMethods() {
        assertEquals(0, expense.getExpense());
        assertEquals(listOfExpense, expense.view());
        expense.addMoney(40);
        assertEquals(40, expense.getExpense());
        listOfExpense.add(40);
        assertEquals(listOfExpense, expense.view());
        expense.addExpenseToList(50);
        listOfExpense.add(50);
        assertEquals(listOfExpense, expense.view());
        expense.setExpense(100);
        assertEquals(100, expense.getExpense());
        listOfCategory.add("Housing");
        expense.addCategoryToList("Housing");
        listOfCategory.add("Food");
        expense.addCategoryToList("Food");
        assertEquals(listOfCategory, expense.getCategoryList());
        listOfExpense.remove(1);
        assertEquals(listOfExpense, expense.categoryExpense("Housing"));

    }
}
