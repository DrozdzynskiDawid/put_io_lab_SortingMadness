package pl.put.poznan.sorting.logic.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {
    private HeapSort heapSort = null;

    @BeforeEach
    void setUp() {
        heapSort = new HeapSort();
    }

    @Test
    void testGetName() {
        String result = heapSort.getName();
        assertEquals("heapSort", result);
    }

    @Test
    void testSortWithDefaultArguments() {
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(100,50,1,5435,2,7888,890,1));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(1,1,2,50,100,890,5435,7888));
        ArrayList<String> arrayString = new ArrayList<>(Arrays.asList("abc","bcd","aa"));
        ArrayList<String> expectedString = new ArrayList<>(Arrays.asList("aa","abc","bcd"));

        ArrayList<Integer> resultInt = heapSort.sort(arrayInt,false, Integer.MAX_VALUE);
        assertEquals(expectedInt, resultInt);
        ArrayList<String> resultString = heapSort.sort(arrayString,false, Integer.MAX_VALUE);
        assertEquals(expectedString, resultString);
    }

    @Test
    void testSortDescending() {
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(100,50,1,5435,2,7888,890,1));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(7888,5435,890,100,50,2,1,1));
        ArrayList<String> arrayString = new ArrayList<>(Arrays.asList("abc","bcd","aa"));
        ArrayList<String> expectedString = new ArrayList<>(Arrays.asList("bcd","abc","aa"));

        ArrayList<Integer> resultInt = heapSort.sort(arrayInt,true, Integer.MAX_VALUE);
        assertEquals(expectedInt, resultInt);
        ArrayList<String> resultString = heapSort.sort(arrayString,true, Integer.MAX_VALUE);
        assertEquals(expectedString, resultString);
    }

    @Test
    void testSortIterationLimit() {
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(100,50,1,40,5,7,9,3,5435435,3));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(40,5,9,3,3,7,1,50,100,5435435));

        ArrayList<Integer> resultInt = heapSort.sort(arrayInt,false, 3);
        assertEquals(expectedInt, resultInt);
    }
}