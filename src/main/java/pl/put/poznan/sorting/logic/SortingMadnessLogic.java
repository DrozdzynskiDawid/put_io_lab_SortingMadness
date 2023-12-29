/**
 * Package for logic of application
 */
package pl.put.poznan.sorting.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.sorting.logic.algorithms.*;
import pl.put.poznan.sorting.rest.SortingMadnessController;
import pl.put.poznan.sorting.rest.SortingResponse;

import java.util.ArrayList;

/**
 * Class responsible for choosing algorithm and performing sort,
 * implements main logic of application
 *
 * @author DrozdzynskiDawid
 * @version 1.0
 */
public class SortingMadnessLogic {
    /**
     * Field used for logging
     */
    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    /**
     * Descending order boolean field,
     * true = descending
     * false = ascending (default)
     */
    private final boolean descOrder;

    /**
     * Iteration limit field,
     * specifies passed from controller maximal number of iterations in algorithm
     */
    private final int iterationLimit;


    /**
     * Object that stores chosen sorting strategy
     */
    SortingInterface sortingMethod;





    /**
     * Constructor of class, responsible for choosing algorithm and setting fields
     *
     * @param algorithm name of algorithm to choose
     * @param descOrder if true, data will be sorted in descending order
     * @param iterationLimit maximal number of iterations in algorithm
     * @throws Exception if algorithm with given name is not implemented
     */

    public SortingMadnessLogic(String algorithm, boolean descOrder, int iterationLimit) throws Exception {
        this.descOrder = descOrder;
        this.iterationLimit = iterationLimit;
        chooseAlgorithm(algorithm);

    }

    /**
     * Method for choosing sorting strategy
     *
     * @param algo name of algorithm
     * @throws Exception if algorithm with given name is not implemented
     */
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

    /**
     * Method that launch sorting and measure time of sorting
     *
     * @param data given array of data
     * @return returns SortingResponse object with sorted array, name of used algorithm and execution time
     */
    public <T extends Comparable<T>> SortingResponse<T> sort(ArrayList <T> data) {
            if(data == null || data.isEmpty()) throw new NullPointerException("Data is null!");

            SortingResponse<T> result = new SortingResponse<>();
            String algorithmName = sortingMethod.getName();
            ArrayList<T> unorderedData = new ArrayList<>();
            unorderedData = (ArrayList<T>) data.clone();
            //sort and measure time
            long start = System.currentTimeMillis();
            ArrayList <T> sortedArray = sortingMethod.sort(unorderedData, descOrder, iterationLimit);
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
