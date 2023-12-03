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
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data, boolean descOrder) {
        int n = data.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                int comparisonResult = data.get(j).compareTo(data.get(j + 1));
                if (descOrder) {
                    if (comparisonResult < 0) {
                        T temp = data.get(j);
                        data.set(j, data.get(j + 1));
                        data.set(j + 1, temp);
                        swapped = true;
                    }
                } else {
                    if (comparisonResult > 0) {
                        T temp = data.get(j);
                        data.set(j, data.get(j + 1));
                        data.set(j + 1, temp);
                        swapped = true;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
        return data;
    }
}
