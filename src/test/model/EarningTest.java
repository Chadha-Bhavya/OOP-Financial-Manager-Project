package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

//
public class EarningTest {


    private Earning earning;
    private ArrayList<Integer> listOfIncome;


    @BeforeEach

    void runBefore() {

        earning = new Earning();
        listOfIncome = new ArrayList<>();

    }

    @Test
    void testAllMethods() {
        assertEquals(0, earning.getEarning());
        assertEquals(listOfIncome, earning.view());
        earning.addMoney(40);
        assertEquals(40, earning.getEarning());
        listOfIncome.add(40);
        assertEquals(listOfIncome, earning.view());
        earning.addEarningToList(50);
        listOfIncome.add(50);
        assertEquals(listOfIncome, earning.view());
        earning.setEarning(100);
        assertEquals(100, earning.getEarning());
    }




}
