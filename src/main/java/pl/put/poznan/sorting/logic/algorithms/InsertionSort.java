package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;

public class InsertionSort implements SortingInterface {
    String name = SortingInterface.name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public InsertionSort() {
        setName("insertionSort");
    }

    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data) {
        int n = data.size();
        for (int i = 1; i < n; ++i) {
            T key = data.get(i);
            int j = i - 1;
            while (j >= 0 && data.get(j).compareTo(key) > 0) {
                data.set(j + 1, data.get(j));
                j = j - 1;
            }
            data.set(j + 1, key);
        }
        return data;
    }
}
