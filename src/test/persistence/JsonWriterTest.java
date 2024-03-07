package persistence;

import model.Earning;
import model.Expense;
import model.ExpenseLimit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.



    @Test
    void testWriterInvalidFile() {
        try {
            Earning earning = new Earning();
            Expense expense = new Expense();
            ExpenseLimit expenseLimit = new ExpenseLimit();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterNoFinancialTransaction.json");
            writer.open();
            writer.write(new Earning(), new Expense(), new ExpenseLimit());
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterNoFinancialTransaction.json");
            Earning earning = reader.readEarning();
            Expense expense = reader.readExpense();
            ExpenseLimit expenseLimit = reader.readExpenseLimit();
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Earning earning = new Earning();
            Expense expense = new Expense();
            ExpenseLimit expenseLimit = new ExpenseLimit();
            earning.addMoney(400);
            earning.addMoney(500);
            expense.addMoney(800);
            expense.addMoney(200);
            expense.addCategoryToList("Housing");
            expense.addCategoryToList("Food");
            expenseLimit.setExpenseLimit(1000);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralFinancialTransaction.json");
            writer.open();
            writer.write(earning, expense, expenseLimit);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralFinancialTransaction.json");
            reader.readEarning();
            reader.readExpense();
            reader.readExpenseLimit();
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
