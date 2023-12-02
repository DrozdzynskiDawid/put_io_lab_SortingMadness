package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort implements SortingInterface {
    String name = SortingInterface.name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public BubbleSort() {
        setName("bubbleSort");
    }

    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data) {
        Collections.sort(data);
        return data;
    }
}
