package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;

public class ShellSort implements SortingInterface {
    String name = SortingInterface.name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public ShellSort() {
        setName("shellSort");
    }

    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data) {
        int n = data.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T key = data.get(i);
                int j = i;
                while (j >= gap && data.get(j - gap).compareTo(key)>0) {
                    data.set(j, data.get(j - gap));
                    j -= gap;
                }
                data.set(j, key);
            }
        }
        return data;
    }
}
