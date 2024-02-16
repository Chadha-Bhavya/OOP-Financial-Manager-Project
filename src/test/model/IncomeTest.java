package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IncomeTest {


    private Income income;
    private ArrayList<Integer> listOfIncome;


    @BeforeEach

    void runBefore() {

        income = new Income();
        listOfIncome = new ArrayList<>();

    }

    @Test
    void testAllMethods() {
        assertEquals(0, income.getIncome());
        assertEquals(listOfIncome, income.view());
        income.addMoney(40);
        assertEquals(40, income.getIncome());
        listOfIncome.add(40);
        assertEquals(listOfIncome, income.view());
        income.addIncomeToList(50);
        listOfIncome.add(50);
        assertEquals(listOfIncome, income.view());
        income.setIncome(100);
        assertEquals(100, income.getIncome());
    }




}
