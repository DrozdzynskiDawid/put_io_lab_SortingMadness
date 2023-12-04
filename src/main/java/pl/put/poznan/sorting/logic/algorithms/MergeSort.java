package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;

public class MergeSort implements SortingInterface {
    String name = SortingInterface.name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public MergeSort() {
        setName("mergeSort");
    }
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
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data, boolean descOrder) {
        // Use a default value for iteration limit (e.g., Integer.MAX_VALUE)
        return sortWithLimit(data, descOrder, Integer.MAX_VALUE);
    }

    @Override
    public <T extends Comparable<T>> ArrayList<T> sortWithLimit(ArrayList<T> data, boolean descOrder, int iterationLimit) {
        int n = data.size();
        if (n < 2 || iterationLimit <= 0) {
            return data;
        }
        int mid = n / 2;
        ArrayList<T> l = new ArrayList<>(data.subList(0, mid));
        ArrayList<T> r = new ArrayList<>(data.subList(mid, n));

        sortWithLimit(l, descOrder, iterationLimit - 1);
        sortWithLimit(r, descOrder, iterationLimit - 1);

        merge(data, l, r, mid, n - mid, descOrder);

        return data;
    }

}
