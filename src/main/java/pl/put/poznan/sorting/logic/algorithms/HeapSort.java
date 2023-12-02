package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;

public class HeapSort implements SortingInterface {
    String name = SortingInterface.name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public HeapSort () {
        setName("heapSort ");
    }
    private <T extends Comparable<T>> void heapify(ArrayList<T> data, int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && data.get(l).compareTo(data.get(largest))>0)
            largest = l;

        if (r < n && data.get(l).compareTo(data.get(largest))>0)
            largest = r;

        if (largest != i) {
            T temp = data.get(i);
            data.set(i,data.get(largest));
            data.set(largest, temp);

            heapify(data, n, largest);
        }
    }
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data) {
        int n = data.size();

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(data, n, i);

        for (int i = n - 1; i >= 0; i--) {
            T temp = data.get(0);
            data.set(0,data.get(i));
            data.set(i, temp);
            heapify(data, i, 0);
        }
        return data;
    }
}
