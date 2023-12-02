package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingTest {
    public static void main(String[] args) {
        // Int sorting test
        testSortingAlgorithm(new BubbleSort(), createIntegerList());
        testSortingAlgorithm(new InsertionSort(), createIntegerList());
        testSortingAlgorithm(new SelectionSort(), createIntegerList());
        // Strings sorting test
        testSortingAlgorithm(new InsertionSort(), createStringList());
        testSortingAlgorithm(new BubbleSort(), createStringList());
        testSortingAlgorithm(new SelectionSort(), createStringList());


    }

    private static <T extends Comparable<T>> void testSortingAlgorithm(SortingInterface sortingAlgorithm, List<T> data) {
        List<T> originalData = new ArrayList<>(data);
        List<T> sortedData = sortingAlgorithm.sort(new ArrayList<>(data));

        System.out.println(sortingAlgorithm.getName() + " Result: " + sortedData);

        System.out.println("Original Data: " + originalData);
        System.out.println("-------------------------------------------------");
    }


    private static List<Integer> createIntegerList() {
        return new ArrayList<>(Arrays.asList(2, 1, 3, 7, 4, 2, 0, 6, 9));
    }

    private static List<String> createStringList() {
        return new ArrayList<>(Arrays.asList("dupka", "kupa", "dupa", "dżem", "bigos" ));
    }

}
