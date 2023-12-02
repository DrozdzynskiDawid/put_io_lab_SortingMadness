package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;

public class SelectionSort implements SortingInterface {
    String name = SortingInterface.name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public SelectionSort() {
        setName("selectionSort");
    }

    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data) {
        return data;
    }
}
