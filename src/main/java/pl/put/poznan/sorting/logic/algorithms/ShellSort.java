/**
 * Package for sorting algorithms implementations
 */
package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;
/**
 * That class implements shell sort algorithm as one of strategies used in strategy design pattern
 *
 * @author IdKheh
 * @version 1.1
 */
public class ShellSort implements SortingInterface {
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
     * Constructor that set name of shell sort algorithm
     */
    public ShellSort() {
        setName("shellSort");
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
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < Math.min(n, iterationLimit); i++) {
                T key = data.get(i);
                int j = i;
                while (j >= gap) {
                    int comparisonResult = data.get(j - gap).compareTo(key);
                    if (descOrder ? comparisonResult < 0 : comparisonResult > 0) {
                        data.set(j, data.get(j - gap));
                        j -= gap;
                    } else {
                        break;
                    }
                }
                data.set(j, key);
            }
        }
        return data;
    }
}
