package model;

import org.json.JSONObject;
import persistence.Writable;

//Represents Expense Limit of the user
public class ExpenseLimit implements Writable {

    private int expenseLimit;


    // REQUIRES: expenseLimit >= 0
    // EFFECTS: The Expense Limit in the app is set to expenseLimit
    public ExpenseLimit(int expenseLimit) {
        this.expenseLimit =  expenseLimit;
    }

    // REQUIRES: expense > 0;
    // EFFECTS: Returns true if expense > expenseLimit, else returns false
    public boolean exceededExpense(int expense) {
        return (expenseLimit < expense);
    }

    public int getExpenseLimit() {
        return expenseLimit;
    }

    public void setExpenseLimit(int expenseLimit) {
        this.expenseLimit = expenseLimit;
    }





}
