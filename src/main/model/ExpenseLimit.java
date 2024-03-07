package model;

import org.json.JSONObject;

//Represents Expense Limit of the user
public class ExpenseLimit {

    private int expenseLimit;


    // REQUIRES: expenseLimit >= 0
    // EFFECTS: The Expense Limit in the app is set to expenseLimit
    public ExpenseLimit() {
        this.expenseLimit =  -1;
    }

    // REQUIRES: expense > 0;
    // EFFECTS: Returns true if expense > expenseLimit, else returns false
    public boolean exceededExpense(int expense) {
        if (expenseLimit == -1) {
            return false;
        }
        return (expenseLimit < expense);
    }

    public int getExpenseLimit() {
        return expenseLimit;
    }

    public void setExpenseLimit(int expenseLimit) {
        this.expenseLimit = expenseLimit;
    }


    public JSONObject toJson(JSONObject json) {
        json.put("expenseLimit", getExpenseLimit());
        return json;
    }


}
