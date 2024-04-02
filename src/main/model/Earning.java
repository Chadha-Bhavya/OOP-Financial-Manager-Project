package model;


import org.json.JSONObject;

import java.util.*;

//Represents Earning of the user
public class Earning implements Parent {

    private int earning;
    private ArrayList<Integer> listOfEarning = new ArrayList<>();



    // EFFECTS: Sets earning = 0;
    public Earning() {
        earning = 0;
    }

    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: Adds amount to earning and calls addEarningToList function with amount
    @Override
    public void addMoney(int amount) {
        this.earning += amount;
        addEarningToList(amount);
        EventLog.getInstance().logEvent(new Event("Added " + amount + " to Earning"));
    }

    // EFFECTS: Returns an ArrayList of all the earning added till now, empty list if no earning
    @Override
    public ArrayList<Integer> view() {
        return listOfEarning;
    }

    public int getEarning() {
        return earning;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }


    // REQUIRES: amount > 0
    // MODIFIES: this
    // EFFECTS: Adds amount to the listOfEarning
    public void addEarningToList(int amount) {
        listOfEarning.add(amount);
    }


    // EFFECTS: returns this as JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("listOfEarning", listOfEarning);
        return json;
    }
}