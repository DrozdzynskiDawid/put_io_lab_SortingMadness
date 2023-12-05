/**
 * Package for sorting algorithms implementations
 */
package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;

/**
 * That class implements insertion sort algorithm as one of strategies used in strategy design pattern
 *
 * @author jjulkakulkaa
 * @version 1.0
 */
public class InsertionSort implements SortingInterface {
    /**
     * Field for storing name of algorithm
     */
    String name = SortingInterface.name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Constructor that set name of insertion sort algorithm
     */
    public InsertionSort() {
        setName("insertionSort");
    }

    /**
     * This method is responsible for sorting an array using insertion sort algorithm
     *
     * @param data given array of data
     * @param descOrder if true, data will be sorted in descending order
     * @param iterationLimit maximal number of iterations in algorithm
     * @return returns sorted array or modified array after specified number of iterations
     */
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data, boolean descOrder, int iterationLimit) {
        int n = data.size();
        for (int i = 1; i < Math.min(n, iterationLimit); ++i) {
            T key = data.get(i);
            int j = i - 1;
            while (j >= 0) {
                int comparisonResult = data.get(j).compareTo(key);

                if (descOrder ? comparisonResult < 0 : comparisonResult > 0) {
                    data.set(j + 1, data.get(j));
                    j = j - 1;
                } else {
                    break;
                }
            }
            data.set(j + 1, key);
        }
        return data;
    }
}
