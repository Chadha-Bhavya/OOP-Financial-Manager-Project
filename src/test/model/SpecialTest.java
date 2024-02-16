package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SpecialTest {


    private Special special;



    @BeforeEach

    void runBefore() {

        special = new Special(100);

    }

    @Test
    void testAllMethods() {

        assertEquals(100, special.getBudgetLimit());
        special.setBudgetLimit(200);
        assertEquals(200, special.getBudgetLimit());
        assertTrue(special.exceededBudget(500));
        assertFalse(special.exceededBudget(200));
        assertFalse(special.exceededBudget(195));

    }




}