/**
 * Package for sorting algorithms implementations
 */
package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;
/**
 * That class implements selection sort algorithm as one of strategies used in strategy design pattern
 *
 * @author IdKheh
 * @version 1.1
 */
public class SelectionSort implements SortingInterface {
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
     * Constructor that set name of selection sort algorithm
     */
    public SelectionSort() {
        setName("selectionSort");
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
        for (int i = 0; i < Math.min(n - 1, iterationLimit); i++) {
            int selectedIdx = i;

            for (int j = i + 1; j < n; j++) {
                boolean shouldSwap = descOrder
                        ? data.get(j).compareTo(data.get(selectedIdx)) > 0
                        : data.get(j).compareTo(data.get(selectedIdx)) < 0;

                if (shouldSwap) {
                    selectedIdx = j;
                }
            }
            T temp = data.get(selectedIdx);
            data.set(selectedIdx, data.get(i));
            data.set(i, temp);
        }
        return data;
    }
}
