package persistence;

import model.Earning;
import model.Expense;
import model.ExpenseLimit;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest{

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
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderNoFinancialTransaction.json");
        try {
            Earning earning = reader.readEarning();
            Expense expense = reader.readExpense();
            ExpenseLimit expenseLimit = reader.readExpenseLimit();
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFinancialTransaction.json");
        try {
            Earning earning = reader.readEarning();
            Expense expense = reader.readExpense();
            ExpenseLimit expenseLimit = reader.readExpenseLimit();
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
