package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseLimitTest {


    private ExpenseLimit expenseLimit;



    @BeforeEach

    void runBefore() {

        expenseLimit = new ExpenseLimit(100);

    }

    @Test
    void testAllMethods() {

        assertEquals(100, expenseLimit.getExpenseLimit());
        expenseLimit.setExpenseLimit(200);
        assertEquals(200, expenseLimit.getExpenseLimit());
        assertTrue(expenseLimit.exceededExpense(500));
        assertFalse(expenseLimit.exceededExpense(200));
        assertFalse(expenseLimit.exceededExpense(195));

    }




}