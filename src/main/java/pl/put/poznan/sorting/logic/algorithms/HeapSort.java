/**
 * Package for sorting algorithms implementations
 */
package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;
/**
 * That class implements heap sort algorithm as one of strategies used in strategy design pattern
 *
 * @author IdKheh
 * @version 1.1
 */
public class HeapSort implements SortingInterface {
    /**
     * Field for storing name of algorithm
     */
    private String name = SortingInterface.name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Constructor that set name of heap sort algorithm
     */
    public HeapSort() {
        setName("heapSort");
    }
    /**
     * This method build heap
     *
     * @param data given array of data
     * @param descOrder if true, data will be sorted in descending order
     * @param n size of data array and the heap
     * @param i root node in heap
     */
    private <T extends Comparable<T>> void heapify(ArrayList<T> data, int n, int i, boolean descOrder) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (descOrder) {
            if (l < n && data.get(l).compareTo(data.get(largest)) < 0) {
                largest = l;
            }
            if (r < n && data.get(r).compareTo(data.get(largest)) < 0) {
                largest = r;
            }
        } else {
            if (l < n && data.get(l).compareTo(data.get(largest)) > 0) {
                largest = l;
            }
            if (r < n && data.get(r).compareTo(data.get(largest)) > 0) {
                largest = r;
            }
        }
        if (largest != i) {
            T temp = data.get(i);
            data.set(i, data.get(largest));
            data.set(largest, temp);

            heapify(data, n, largest, descOrder);
        }
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

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(data, n, i, descOrder);
        }
        for (int i = n - 1; i >= Math.max(0, n - iterationLimit); i--) {
            T temp = data.get(0);
            data.set(0, data.get(i));
            data.set(i, temp);
            heapify(data, i, 0, descOrder);
        }
        return data;
    }
}
