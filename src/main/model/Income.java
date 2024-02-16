package model;


import java.util.*;

//Represents something related to handling money
public class Income implements Parent {

    private int income;
    private ArrayList<Integer> listOfIncome = new ArrayList<>();


    public Income() {
        income = 0;
    }

    public void addMoney(int income) {
        this.income += income;
        addIncomeToList(income);
    }

    public ArrayList<Integer> view() {
        return listOfIncome;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void addIncomeToList(int income) {

        listOfIncome.add(income);
    }






}