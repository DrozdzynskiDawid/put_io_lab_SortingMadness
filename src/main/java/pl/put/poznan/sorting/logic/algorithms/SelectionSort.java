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
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data, boolean descOrder, int iterationLimit) {
        int n = data.size();
        for (int i = 0; i < Math.min(n - 1, iterationLimit); i++) {
            int selectedIdx = i;

            for (int j = i + 1; j < n; j++) {
                boolean shouldSwap = descOrder
                        ? data.get(j).compareTo(data.get(selectedIdx)) > 0
                        : data.get(j).compareTo(data.get(selectedIdx)) < 0;

                if (shouldSwap) {
                    selectedIdx = j;
                }
            }
            T temp = data.get(selectedIdx);
            data.set(selectedIdx, data.get(i));
            data.set(i, temp);
        }
        return data;
    }
}
