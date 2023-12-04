package pl.put.poznan.sorting.logic;

import java.util.ArrayList;


public interface SortingInterface {
    String name = "";

    String getName();

    void setName(String name);

    <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data, boolean descOrder);

    <T extends Comparable<T>> ArrayList<T> sortWithLimit(ArrayList<T> data, boolean descOrder, int iterationLimit);
}
