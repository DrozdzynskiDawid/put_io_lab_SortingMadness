package pl.put.poznan.sorting.logic.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {
    private ShellSort shellSort = null;

    @BeforeEach
    void setUp() {
        shellSort = new ShellSort();
    }

    @Test
    void testGetName() {
        String result = shellSort.getName();
        assertEquals("shellSort", result);
    }

    @Test
    void testSortWithDefaultArguments() {
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(100,50,1,5435,2,7888,890,1));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(1,1,2,50,100,890,5435,7888));
        ArrayList<String> arrayString = new ArrayList<>(Arrays.asList("abc","david","xyz","cow"));
        ArrayList<String> expectedString = new ArrayList<>(Arrays.asList("abc","cow","david","xyz"));

        ArrayList<Integer> resultInt = shellSort.sort(arrayInt,false, Integer.MAX_VALUE);
        assertEquals(expectedInt, resultInt);
        ArrayList<String> resultString = shellSort.sort(arrayString,false, Integer.MAX_VALUE);
        assertEquals(expectedString, resultString);
    }

    @Test
    void testSortDescending() {
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(1,2,6,3,4));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(6,4,3,2,1));
        ArrayList<String> arrayString = new ArrayList<>(Arrays.asList("abc","bcd","aa"));
        ArrayList<String> expectedString = new ArrayList<>(Arrays.asList("bcd","abc","aa"));

        ArrayList<Integer> resultInt = shellSort.sort(arrayInt,true, Integer.MAX_VALUE);
        assertEquals(expectedInt, resultInt);
        ArrayList<String> resultString = shellSort.sort(arrayString,true, Integer.MAX_VALUE);
        assertEquals(expectedString, resultString);
    }

    @Test
    void testSortIterationLimit() {
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(100,50,1,40,5,3,88));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(100,88,50,40,5,3,1));

        ArrayList<Integer> resultInt = shellSort.sort(arrayInt,true, 50);
        assertEquals(expectedInt, resultInt);
    }

}