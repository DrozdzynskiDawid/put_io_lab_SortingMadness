package pl.put.poznan.sorting.logic.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    private BubbleSort bubbleSort = null;

    @BeforeEach
    void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
    void testGetName() {
        String result = bubbleSort.getName();
        assertEquals("bubbleSort", result);
    }

    @Test
    void testSortWithDefaultArguments() {
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(100,50,1,5435,2,7888,890,1));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(1,1,2,50,100,890,5435,7888));
        ArrayList<String> arrayString = new ArrayList<>(Arrays.asList("abc","bcd","aa"));
        ArrayList<String> expectedString = new ArrayList<>(Arrays.asList("aa","abc","bcd"));

        ArrayList<Integer> resultInt = bubbleSort.sort(arrayInt,false, Integer.MAX_VALUE);
        assertEquals(expectedInt, resultInt);
        ArrayList<String> resultString = bubbleSort.sort(arrayString,false, Integer.MAX_VALUE);
        assertEquals(expectedString, resultString);
    }

    @Test
    void testSortDescending() {
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(100,50,1,5435,2,7888,890,1));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(7888,5435,890,100,50,2,1,1));
        ArrayList<String> arrayString = new ArrayList<>(Arrays.asList("abc","bcd","aa"));
        ArrayList<String> expectedString = new ArrayList<>(Arrays.asList("bcd","abc","aa"));

        ArrayList<Integer> resultInt = bubbleSort.sort(arrayInt,true, Integer.MAX_VALUE);
        assertEquals(expectedInt, resultInt);
        ArrayList<String> resultString = bubbleSort.sort(arrayString,true, Integer.MAX_VALUE);
        assertEquals(expectedString, resultString);
    }

    @Test
    void testSortIterationLimit() {
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(100,50,1,40));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(50,1,40,100));

        ArrayList<Integer> resultInt = bubbleSort.sort(arrayInt,false, 1);
        assertEquals(expectedInt, resultInt);
    }
}