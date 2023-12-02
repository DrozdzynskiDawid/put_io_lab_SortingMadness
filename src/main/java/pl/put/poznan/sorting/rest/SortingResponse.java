package pl.put.poznan.sorting.rest;

import java.util.ArrayList;

public class SortingResponse<T> {
    String algorithm;

    ArrayList<T> result;

    Long sortingTime;

    public String getAlgorithm() {
        return this.algorithm;
    }

    public ArrayList<T> getResult() {
        return this.result;
    }

    public Long getSortingTime() {
        return this.sortingTime;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public void setResult(ArrayList<T> result) {
        this.result = result;
    }

    public void setSortingTime(Long sortingTime) {
        this.sortingTime = sortingTime;
    }
}
