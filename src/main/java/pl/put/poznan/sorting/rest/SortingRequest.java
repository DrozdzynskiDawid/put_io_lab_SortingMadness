package pl.put.poznan.sorting.rest;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.util.HttpCookieStore.Empty;


public class SortingRequest<T> {
    
    ArrayList<T> array;

    List<String> algorithms;

    boolean descendingOrder = false;

    int iterationLimit = Integer.MAX_VALUE;

    public ArrayList<T> getArray() {
        return this.array;
    }

    public List<String> getAlgorithms() {
        return this.algorithms;
    }

    public boolean getSortingOrder(){
        return this.descendingOrder;
    }

    public int getIterationLimit(){
        return this.iterationLimit;
    }
    public int getCheckedIterationLimit(){
        if (this.iterationLimit <= 0) return Integer.MAX_VALUE;
        else
        return this.iterationLimit;
    }

    public void setArray(ArrayList<T> array) {
        this.array = array;
    }

    public void setAlgorithms(List<String> algorithms) {
        this.algorithms = algorithms;
    }

    public void setSortingOrder(boolean descOrder){
        this.descendingOrder = descOrder;
    }

    public void setIterationLimit(int iterationLimit){
        this.iterationLimit = iterationLimit;
    }
    public void setCheckedIterationLimit(int iterationLimit){
        if (iterationLimit <= 0) this.iterationLimit = Integer.MAX_VALUE;
        else
        this.iterationLimit = iterationLimit;
    }
}
