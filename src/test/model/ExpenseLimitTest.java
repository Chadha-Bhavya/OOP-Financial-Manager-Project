package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseLimitTest {


    private ExpenseLimit expenseLimit;



    @BeforeEach

    void runBefore() {

        expenseLimit = new ExpenseLimit();

    }

    @Test
    void testAllMethods() {

        assertEquals(-1, expenseLimit.getExpenseLimit());
        assertFalse(expenseLimit.exceededExpense(-1));
        expenseLimit.setExpenseLimit(200);
        assertEquals(200, expenseLimit.getExpenseLimit());
        assertTrue(expenseLimit.exceededExpense(500));
        assertFalse(expenseLimit.exceededExpense(200));
        assertFalse(expenseLimit.exceededExpense(195));

    }




}