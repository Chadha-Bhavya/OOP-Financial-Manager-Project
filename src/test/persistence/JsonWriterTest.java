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

    Earning earning;
    Expense expense;
    ExpenseLimit expenseLimit;

    @BeforeEach

    void runBefore() {
        earning = new Earning();
        expense = new Expense();
        expenseLimit = new ExpenseLimit();
    }

    @Test
    void testWriterInvalidFile() {
        try {
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
            writer.write(earning, expense,expenseLimit);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterNoFinancialTransaction.json");
            Earning readEarning = reader.readEarning();
            Expense readExpense = reader.readExpense();
            ExpenseLimit readExpenseLimit = reader.readExpenseLimit();
            assertEquals(0, readEarning.view().size());
            assertEquals(0, readExpense.view().size());
            assertEquals(0, readExpense.getCategoryList().size());
            assertEquals(-1, readExpenseLimit.getExpenseLimit());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralEarning() {
        try {
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
            Earning readEarning = reader.readEarning();
            assertEquals(900, readEarning.getEarning());
            assertEquals(2, readEarning.view().size());
            assertEquals(400, readEarning.view().get(0));
            assertEquals(500, readEarning.view().get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralExpense() {
        try {
            earning.addMoney(400);
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
            Expense readExpense = reader.readExpense();
            assertEquals(1000, readExpense.getExpense());
            assertEquals(2, readExpense.view().size());
            assertEquals(800, readExpense.view().get(0));
            assertEquals(200, readExpense.view().get(1));
            assertEquals(2, readExpense.getCategoryList().size());
            assertEquals("Housing", readExpense.getCategoryList().get(0));
            assertEquals("Food", readExpense.getCategoryList().get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralExpenseLimit() {
        try {
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
            ExpenseLimit readExpenseLimit = reader.readExpenseLimit();
            assertEquals(1000, readExpenseLimit.getExpenseLimit());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
