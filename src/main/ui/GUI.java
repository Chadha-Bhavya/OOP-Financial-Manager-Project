package ui;

import model.Earning;
import model.EventLog;
import model.Expense;
import model.ExpenseLimit;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

//GUI Class for the Finance Management System
public class GUI implements ActionListener {

    private JLabel earningLabel;
    private JLabel expenseLabel;
    private JLabel expenseLimitLabel;
    private JLabel categoryLabel;
    private JLabel warningLabel;
    private JLabel userOptionLabel;

    private JButton addEarningButton;
    private JButton addExpenseButton;
    private JButton setExpenseLimitButton;
    private JButton viewEarningsButton;
    private JButton viewExpensesButton;
    private JButton viewEarningsAboveButton;
    private JButton viewExpensesAboveButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton netEarningButton;

    private JTextField earningField;
    private JTextField expenseField;
    private JTextField expenseLimitField;
    private JTextField categoryField;
    private JTextField criteriaField;
    private JFrame frame;
    private JPanel panel;

    private Earning earning;
    private Expense expense;
    private ExpenseLimit expenseLimit;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/appdata.json";

    // EFFECTS: initializes frame, panel, labels, buttons, text fields, and data objects
    public GUI() {
        initializeFramePanelLabelField();
        initializeButton();
        addComponentsToPanel();
        addPanelToFrame();
        WindowListenerClass windowListener = new WindowListenerClass();
        frame.addWindowListener(windowListener);
    }

    // MODIFIES: this
    // EFFECTS: initializes labels, text fields, and data objects
    private void initializeFramePanelLabelField() {
        earning = new Earning();
        expense = new Expense();
        expenseLimit = new ExpenseLimit();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        frame = new JFrame("Finance Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 3));

        earningLabel = new JLabel("Earning:");
        expenseLabel = new JLabel("Expense:");
        expenseLimitLabel = new JLabel("Expense Limit:");
        categoryLabel = new JLabel("Category:");
        warningLabel = new JLabel();
        userOptionLabel = new JLabel("Housing, Food, Recreation, Transportation, HealthCare and Insurance,"
                + " Miscellaneous");

        earningField = new JTextField();
        expenseField = new JTextField();
        expenseLimitField = new JTextField();
        categoryField = new JTextField();
        criteriaField = new JTextField();
    }

    // MODIFIES: this
    // EFFECTS: initializes buttons and adds action listeners to them
    private void initializeButton() {

        addEarningButton = new JButton("Add Earning");
        addExpenseButton = new JButton("Add Expense");
        setExpenseLimitButton = new JButton("Set Expense Limit");
        viewEarningsButton = new JButton("View Earnings");
        viewExpensesButton = new JButton("View Expenses");
        viewEarningsAboveButton = new JButton("View Earnings Above Criteria");
        viewExpensesAboveButton = new JButton("View Expenses Above Criteria");
        saveButton = new JButton("Save Data");
        loadButton = new JButton("Load Data");
        netEarningButton = new JButton("Net Earning");

        addEarningButton.addActionListener(this);
        addExpenseButton.addActionListener(this);
        setExpenseLimitButton.addActionListener(this);
        viewEarningsButton.addActionListener(this);
        viewExpensesButton.addActionListener(this);
        viewEarningsAboveButton.addActionListener(this);
        viewExpensesAboveButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        netEarningButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: adds components to panel
    private void addComponentsToPanel() {
        panel.add(earningLabel);
        panel.add(earningField);
        panel.add(addEarningButton);

        panel.add(expenseLabel);
        panel.add(expenseField);
        panel.add(addExpenseButton);
        panel.add(categoryLabel);
        panel.add(categoryField);
        panel.add(userOptionLabel);

        panel.add(expenseLimitLabel);
        panel.add(expenseLimitField);
        panel.add(setExpenseLimitButton);

        panel.add(viewEarningsButton);
        panel.add(viewExpensesButton);
        panel.add(netEarningButton);

        panel.add(criteriaField);
        panel.add(viewEarningsAboveButton);
        panel.add(viewExpensesAboveButton);

        panel.add(warningLabel);
        panel.add(loadButton);
        panel.add(saveButton);

    }

    // MODIFIES: frame
    // EFFECTS: adds panel to frame and makes frame visible
    private void addPanelToFrame() {
        frame.add(panel);
        frame.setVisible(true);
    }

    // EFFECTS: performs actions based on button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addEarningButton) {
            addEarning();
        } else if (e.getSource() == addExpenseButton) {
            addExpense();
        } else if (e.getSource() == setExpenseLimitButton) {
            setExpenseLimit();
        } else if (e.getSource() == viewEarningsButton) {
            viewEarnings();
        } else if (e.getSource() == viewExpensesButton) {
            viewExpenses();
        } else if (e.getSource() == viewEarningsAboveButton) {
            viewEarningsAboveCriteria();
        } else if (e.getSource() == viewExpensesAboveButton) {
            viewExpensesAboveCriteria();
        } else if (e.getSource() == saveButton) {
            saveData();
        } else if (e.getSource() == loadButton) {
            loadData();
        } else if (e.getSource() == netEarningButton) {
            netEarning();
        }
    }


    // MODIFIES: Earning
    // EFFECTS: adds earning based on user input
    private void addEarning() {
        int earningAmount = Integer.parseInt(earningField.getText());
        earning.addMoney(earningAmount);
        earningField.setText("");
    }

    // MODIFIES: Expense, ExpenseLimit
    // EFFECTS: adds expense based on user input and checks expense limit
    private void addExpense() {
        int expenseAmount = Integer.parseInt(expenseField.getText());
        String category = categoryField.getText();
        expense.addMoney(expenseAmount);
        expense.addCategoryToList(category);
        expenseField.setText("");
        categoryField.setText("");
        checkExpenseLimit();
    }

    // MODIFIES: ExpenseLimit
    // EFFECTS: sets expense limit based on user input and checks expense limit
    private void setExpenseLimit() {
        int expenseLimitAmount = Integer.parseInt(expenseLimitField.getText());
        expenseLimit.setExpenseLimit(expenseLimitAmount);
        expenseLimitField.setText("");
        checkExpenseLimit();
    }

    // EFFECTS: displays net earning
    private void netEarning() {
        int netEarning = earning.getEarning() - expense.getExpense();
        JOptionPane.showMessageDialog(frame,
                "Net Earning: " + netEarning,
                "Net Earning ",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // EFFECTS: checks if expense limit is exceeded or not
    private void checkExpenseLimit() {
        if (expenseLimit.exceededExpense(expense.getExpense())) {
            warningLabel.setText("WARNING: Expense limit exceeded!");
        } else {
            warningLabel.setText("");
        }
    }

    // EFFECTS: displays earnings
    private void viewEarnings() {
        JOptionPane.showMessageDialog(frame,
                "Earnings: " + earning.view(),
                "View Earnings",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // EFFECTS: displays expenses
    private void viewExpenses() {
        JOptionPane.showMessageDialog(frame,
                "Expenses: " + expense.view(),
                "View Expenses",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // EFFECTS: displays earnings above a certain criteria
    private void viewEarningsAboveCriteria() {
        int criteria = Integer.parseInt(criteriaField.getText());
        StringBuilder earningsAboveCriteria = new StringBuilder();
        for (int earningAmount : earning.view()) {
            if (earningAmount > criteria) {
                earningsAboveCriteria.append(earningAmount).append(" ");
            }
        }
        JOptionPane.showMessageDialog(frame,
                "Earnings Above Criteria: " + earningsAboveCriteria.toString(),
                "View Earnings Above Criteria",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // EFFECTS: displays expenses above a certain criteria
    private void viewExpensesAboveCriteria() {
        int criteria = Integer.parseInt(criteriaField.getText());
        StringBuilder expensesAboveCriteria = new StringBuilder();
        for (int expenseAmount : expense.view()) {
            if (expenseAmount > criteria) {
                expensesAboveCriteria.append(expenseAmount).append(" ");
            }
        }
        JOptionPane.showMessageDialog(frame,
                "Expenses Above Criteria: " + expensesAboveCriteria.toString(),
                "View Expenses Above Criteria",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // MODIFIES: JsonWriter
    // EFFECTS: saves data to file
    private void saveData() {
        try {
            jsonWriter.open();
            jsonWriter.write(earning, expense, expenseLimit);
            jsonWriter.close();
            JOptionPane.showMessageDialog(frame,
                    "Data saved successfully!",
                    "Save Data",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(frame,
                    "No data found!",
                    "Load Data",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads data from file
    private void loadData() {
        try {
            earning = jsonReader.readEarning();
            expense = jsonReader.readExpense();
            expenseLimit = jsonReader.readExpenseLimit();
            JOptionPane.showMessageDialog(frame,
                    "Data loaded successfully!",
                    "Load Data",
                    JOptionPane.INFORMATION_MESSAGE);
            checkExpenseLimit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame,
                    "No data found!",
                    "Load Data",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
