package persistence;

import model.*;
import org.json.JSONObject;


import java.io.*;

// Represents a writer that writes JSON representation of Finance Management System to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of Earning, Expense and ExpenseLimit to file
    public void write(Earning earning, Expense expense, ExpenseLimit expenseLimit) {
        JSONObject json = earning.toJson();
        json = expense.toJson(json);
        json = expenseLimit.toJson(json);
        saveToFile(json.toString(TAB));
        EventLog.getInstance().logEvent(new Event("Saved the Data"));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
