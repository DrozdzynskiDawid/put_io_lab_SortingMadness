package pl.put.poznan.sorting.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.sorting.logic.algorithms.*;
import pl.put.poznan.sorting.rest.SortingMadnessController;
import pl.put.poznan.sorting.rest.SortingResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SortingMadnessLogic {
    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    SortingInterface sortingMethod;

    public SortingMadnessLogic(String algorithm) throws Exception {
        chooseAlgorithm(algorithm);
    }

    void chooseAlgorithm(String algo) throws Exception {
        switch (algo) {
            case "bubbleSort":
                sortingMethod = new BubbleSort();
                break;
            case "selectionSort":
                sortingMethod = new SelectionSort();
                break;
            case "insertionSort":
                sortingMethod = new InsertionSort();
                break;
            case "mergeSort":
                sortingMethod = new MergeSort();
                break;
            case "heapSort":
                sortingMethod = new HeapSort();
                break;
            case "shellSort":
                sortingMethod = new ShellSort();
                break;
            default:
                throw new Exception("Wrong algorithm name!");
        }
    }

    public <T extends Comparable<T>> SortingResponse<T> sort(ArrayList <T> data) {
        SortingResponse<T> result = new SortingResponse<>();
        String algorithmName = sortingMethod.getName();
        ArrayList<T> unorderedData = new ArrayList<>();
        unorderedData = (ArrayList<T>) data.clone();
        //sort and measure time
        long start = System.currentTimeMillis();
        ArrayList <T> sortedArray = sortingMethod.sort(unorderedData);
        long stop = System.currentTimeMillis() - start;
        //log and return result
        logger.debug("\nAlgorithm: " + algorithmName
                + "\nSorted array: " + sortedArray
                + "\nSorting time: " + stop + " ms");
        result.setAlgorithm(algorithmName);
        result.setResult(sortedArray);
        result.setSortingTime(stop);
        return result;
    }
}
