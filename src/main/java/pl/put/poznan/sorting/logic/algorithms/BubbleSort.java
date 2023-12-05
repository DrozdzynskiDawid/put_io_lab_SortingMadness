/**
 * Package for sorting algorithms implementations
 */
package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;

/**
 * That class implements bubble sort algorithm as one of strategies used in strategy design pattern
 *
 * @author jjulkakulkaa
 * @version 1.0
 */
public class BubbleSort implements SortingInterface {
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
     * Constructor that set name of bubble sort algorithm
     */
    public BubbleSort() {
        setName("bubbleSort");
    }

    /**
     * This method is responsible for sorting an array using bubble sort algorithm
     *
     * @param data given array of data
     * @param descOrder if true, data will be sorted in descending order
     * @param iterationLimit maximal number of iterations in algorithm
     * @return returns sorted array or modified array after specified number of iterations
     */
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data, boolean descOrder, int iterationLimit) {
        int n = data.size();
        boolean swapped;
        for (int i = 0; i < Math.min(iterationLimit, n - 1); i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                int comparisonResult = data.get(j).compareTo(data.get(j + 1));
                if (descOrder) {
                    if (comparisonResult < 0) {
                        T temp = data.get(j);
                        data.set(j, data.get(j + 1));
                        data.set(j + 1, temp);
                        swapped = true;
                    }
                } else {
                    if (comparisonResult > 0) {
                        T temp = data.get(j);
                        data.set(j, data.get(j + 1));
                        data.set(j + 1, temp);
                        swapped = true;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
        return data;
    }
}
