package pl.put.poznan.sorting.logic.algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;
class InsertionSortTest {

    @Test
    public void getNameTest(){
        InsertionSort mockSort = mock(InsertionSort.class);
        when(mockSort.getName()).thenReturn("inserionSort");
    }
    @Test
    public void sortTestWithDefaultArguments(){
        InsertionSort mockSort = mock(InsertionSort.class);
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(100,50,1,5435,2,7888,890,1));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(1,1,2,50,100,890,5435,7888));
        ArrayList<String> arrayString = new ArrayList<>(Arrays.asList("abc","bcd","aa"));
        ArrayList<String> expectedString = new ArrayList<>(Arrays.asList("aa","abc","bcd"));

        when(mockSort.sort(arrayInt,false,Integer.MAX_VALUE)).thenReturn(expectedInt);
        when(mockSort.sort(arrayString,false,Integer.MAX_VALUE)).thenReturn(expectedString);
    }
    @Test
    void testSortDescending() {
        InsertionSort mockSort = mock(InsertionSort.class);
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(100,50,1,5435,2,7888,890,1));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(7888,5435,890,100,50,2,1,1));
        ArrayList<String> arrayString = new ArrayList<>(Arrays.asList("abc","bcd","aa"));
        ArrayList<String> expectedString = new ArrayList<>(Arrays.asList("bcd","abc","aa"));

        when(mockSort.sort(arrayInt,false,Integer.MAX_VALUE)).thenReturn(expectedInt);
        when(mockSort.sort(arrayString,false,Integer.MAX_VALUE)).thenReturn(expectedString);
    }

    @Test
    void testSortIterationLimit() {
        InsertionSort mockSort = mock(InsertionSort.class);
        ArrayList<Integer> arrayInt = new ArrayList<>(Arrays.asList(100,50,1,40,5,7,9,3,5435435,3));
        ArrayList<Integer> expectedInt = new ArrayList<>(Arrays.asList(40,5,9,3,3,7,1,50,100,5435435));

        when(mockSort.sort(arrayInt,false,3)).thenReturn(expectedInt);
    }

}