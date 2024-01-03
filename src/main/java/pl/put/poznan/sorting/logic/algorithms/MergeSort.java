/**
 * Package for sorting algorithms implementations
 */
package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;
/**
 * That class implements merge sort algorithm as one of strategies used in strategy design pattern
 *
 * @author IdKheh
 * @version 1.1
 */
public class MergeSort implements SortingInterface {
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
     * Constructor that set name of merge sort algorithm
     */
    public MergeSort() {
        setName("mergeSort");
    }
    /**
     * This method merge l and r arrays into sorted array data
     *
     * @param data given array of data
     * @param descOrder if true, data will be sorted in descending order
     * @param l left side of merged array
     * @param r right side of merged array
     * @param left amount of the elements of left side array data
     * @param right amount of the elements of right side array data
     */
    private <T extends Comparable<T>> void merge(
            ArrayList<T> data, ArrayList<T> l, ArrayList<T> r, int left, int right, boolean descOrder) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (descOrder ? l.get(i).compareTo(r.get(j)) >= 0 : l.get(i).compareTo(r.get(j)) <= 0) {
                data.set(k++, l.get(i++));
            } else {
                data.set(k++, r.get(j++));
            }
        }
        while (i < left) {
            data.set(k++, l.get(i++));
        }
        while (j < right) {
            data.set(k++, r.get(j++));
        }
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
        if (n < 2 || iterationLimit <= 0) {
            return data;
        }
        int mid = n / 2;
        ArrayList<T> l = new ArrayList<>(data.subList(0, mid));
        ArrayList<T> r = new ArrayList<>(data.subList(mid, n));

        sort(l, descOrder, Math.min(iterationLimit - 1, l.size()-1));
        sort(r, descOrder, Math.min(iterationLimit - 1, r.size()-1));

        merge(data, l, r, mid, n - mid, descOrder);

        return data;
    }


}
