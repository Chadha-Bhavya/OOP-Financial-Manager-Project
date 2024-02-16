package model;

public class Special {

    private int budgetLimit;

    public Special(int budgetLimit) {
        this.budgetLimit =  budgetLimit;
    }

    public boolean exceededBudget(int expense) {
        return (budgetLimit < expense);
    }

    public int getBudgetLimit() {
        return budgetLimit;
    }

    public void setBudgetLimit(int budgetLimit) {
        this.budgetLimit = budgetLimit;
    }




}
