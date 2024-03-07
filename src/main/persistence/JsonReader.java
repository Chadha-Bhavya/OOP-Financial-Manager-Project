package persistence;

import model.Earning;
import model.Expense;
import model.ExpenseLimit;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Earning readEarning() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseEarning(jsonObject);
    }

    public Expense readExpense() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseExpense(jsonObject);
    }

    public ExpenseLimit readExpenseLimit() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseExpenseLimit(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Earning parseEarning(JSONObject jsonObject) {
        JSONArray listOfEarning = (JSONArray) jsonObject.get("listOfEarning");

        Earning earning = new Earning();

        for (Object e: listOfEarning) {
            earning.addMoney((Integer) e);
        }

        return earning;


    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Expense parseExpense(JSONObject jsonObject) {

        JSONArray listOfExpenses = (JSONArray) jsonObject.get("listOfExpenses");
        JSONArray listOfCategory = (JSONArray) jsonObject.get("listOfCategory");
        Expense expense = new Expense();

        for (Object e: listOfExpenses) {
            expense.addMoney((Integer) e);
        }

        for (Object c: listOfCategory) {
            expense.addCategoryToList((String) c);
        }

        return expense;

    }

    // EFFECTS: parses workroom from JSON object and returns it
    private ExpenseLimit parseExpenseLimit(JSONObject jsonObject) {

        int limit = (int) jsonObject.get("expenseLimit");
        ExpenseLimit expenseLimit = new ExpenseLimit();
        expenseLimit.setExpenseLimit(limit);

        return expenseLimit;

    }

}
