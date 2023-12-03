package pl.put.poznan.sorting.rest;

import java.util.ArrayList;
import java.util.List;

public class SortingRequest<T> {
    ArrayList<T> array;

    List<String> algorithms;

    boolean sortingOrder;

    public ArrayList<T> getArray() {
        return this.array;
    }

    public List<String> getAlgorithms() {
        return this.algorithms;
    }

    public boolean getSortingOrder(){
        return this.sortingOrder;
    }

    public void setArray(ArrayList<T> array) {
        this.array = array;
    }

    public void setAlgorithms(List<String> algorithms) {
        this.algorithms = algorithms;
    }

    public void setSortingOrder(boolean descOrder){
        this.sortingOrder = descOrder;
    }
}
