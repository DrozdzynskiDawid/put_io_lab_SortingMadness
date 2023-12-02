package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;

public class SelectionSort implements SortingInterface {
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data) {
        return data;
    }
}
