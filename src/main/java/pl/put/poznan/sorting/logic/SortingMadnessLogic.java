package pl.put.poznan.sorting.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.sorting.logic.algorithms.BubbleSort;
import pl.put.poznan.sorting.logic.algorithms.SelectionSort;
import pl.put.poznan.sorting.rest.SortingMadnessController;

import java.util.ArrayList;

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
            default:
                throw new Exception("Wrong algorithm name!");
        }
    }

    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList <T> data) {
        long start = System.currentTimeMillis();
        ArrayList<T> result = sortingMethod.sort(data);
        long stop = System.currentTimeMillis() - start;
        logger.info("Sorting time: " + stop + " ms");
        return result;
    }
}
