package persistence;

import model.Earning;
import model.Expense;
import model.ExpenseLimit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {


    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Earning earning = reader.readEarning();
            Expense expense = reader.readExpense();
            ExpenseLimit expenseLimit = reader.readExpenseLimit();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyFinanceManagementSystem() {
        JsonReader reader = new JsonReader("./data/testReaderNoFinancialTransaction.json");
        try {
            Earning earning = reader.readEarning();
            Expense expense = reader.readExpense();
            ExpenseLimit expenseLimit = reader.readExpenseLimit();
            assertEquals(0, earning.view().size());
            assertEquals(0, expense.view().size());
            assertEquals(0, expense.getCategoryList().size());
            assertEquals(-1, expenseLimit.getExpenseLimit());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralFinanceManagementSystem() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFinancialTransaction.json");
        try {
            Earning earning = reader.readEarning();
            Expense expense = reader.readExpense();
            ExpenseLimit expenseLimit = reader.readExpenseLimit();
            assertEquals(900, earning.getEarning());
            assertEquals(2, earning.view().size());
            assertEquals(600, earning.view().get(0));
            assertEquals(300, earning.view().get(1));
            assertEquals(800, expense.getExpense());
            assertEquals(2, expense.view().size());
            assertEquals(500, expense.view().get(0));
            assertEquals(300, expense.view().get(1));
            assertEquals(2, expense.getCategoryList().size());
            assertEquals("Housing", expense.getCategoryList().get(0));
            assertEquals("Recreation", expense.getCategoryList().get(1));
            assertEquals(10000, expenseLimit.getExpenseLimit());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
