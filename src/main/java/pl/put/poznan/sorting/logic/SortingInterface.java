package pl.put.poznan.sorting.logic;

import java.util.ArrayList;

public interface SortingInterface {
    <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data);
}
