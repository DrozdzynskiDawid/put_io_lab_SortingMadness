package pl.put.poznan.sorting.logic.algorithms;

import pl.put.poznan.sorting.logic.SortingInterface;

import java.util.ArrayList;

public class MergeSort implements SortingInterface {
    String name = SortingInterface.name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public MergeSort() {
        setName("mergeSort");
    }
    private <T extends Comparable<T>> void merge(
            ArrayList<T> data, ArrayList<T> l, ArrayList<T> r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right)
            if (l.get(i).compareTo(r.get(j))<=0)
                data.set(k++,l.get(i++));
            else
                data.set(k++,r.get(j++));


        while (i < left)
            data.set(k++,l.get(i++));

        while (j < right)
            data.set(k++,r.get(j++));
    }
    @Override
    public <T extends Comparable<T>> ArrayList<T> sort(ArrayList<T> data) {
        int n = data.size();
        if (n < 2) {
            return data;
        }

        int mid = n / 2;
        ArrayList<T> l = new ArrayList<>();
        ArrayList<T> r = new ArrayList<>();

        for (int i = 0; i < mid; i++)
            l.add(data.get(i));

        for (int i = mid; i < n; i++)
            r.add(data.get(i));

        sort(l);
        sort(r);
        merge(data, l, r, mid, n - mid);
        return data;
    }
}