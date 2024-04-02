package model;

import org.json.JSONObject;

//Represents Expense Limit of the user
public class ExpenseLimit {

    private int expenseLimit;


    // EFFECTS: The Expense Limit in the app is set to -1
    public ExpenseLimit() {
        this.expenseLimit =  -1;
    }

    // REQUIRES: expense > 0;
    // EFFECTS: Returns true if expense > expenseLimit, returns false if
    // expenseLimit equals to -1 or expense =< expenseLimit
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
        EventLog.getInstance().logEvent(new Event("New Expense Limit: " + expenseLimit));
    }

    // EFFECTS: returns this as JSON object
    public JSONObject toJson(JSONObject json) {
        json.put("expenseLimit", getExpenseLimit());
        return json;
    }


}
