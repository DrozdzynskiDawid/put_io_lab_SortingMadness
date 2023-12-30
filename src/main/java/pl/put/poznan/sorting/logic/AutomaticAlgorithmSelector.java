package pl.put.poznan.sorting.logic;
import pl.put.poznan.sorting.logic.algorithms.*;


import java.util.*;


public class AutomaticAlgorithmSelector {


    public AutomaticAlgorithmSelector(){
        String name = "auto";
    }
    private static final Map<String, SortingInterface> algorithmMap = initializeAlgorithmMap();

    private static Map<String, SortingInterface> initializeAlgorithmMap() {
        Map<String, SortingInterface> map = new HashMap<>();
        map.put("bubbleSort", new BubbleSort());
        map.put("selectionSort", new SelectionSort());
        map.put("insertionSort", new InsertionSort());
        map.put("mergeSort", new MergeSort());
        map.put("heapSort", new HeapSort());
        map.put("shellSort", new ShellSort());
        return map;
    }




    public static SortingInterface selectAlgorithm(ArrayList<?> data, boolean descendingOrder) {
        if (isSorted(data, descendingOrder)){
            return algorithmMap.get("insertionSort");
        }
        if (isDescending(data) && !descendingOrder) {
            return algorithmMap.get("heapSort");
        }

        if (isAscending(data) && descendingOrder) {
            return algorithmMap.get("heapSort");
        }

        if (hasManyDuplicates(data)) {
            return algorithmMap.get("mergeSort");
        }

        if (hasSmallValueRange(data)) {
            return algorithmMap.get("insertionSort");
        }

        if (data.size() <= 100) {
            return algorithmMap.get("insertionSort");
        }

        if (data.size() <= 1000) {
            return algorithmMap.get("mergeSort");
        }

        return algorithmMap.get("quickSort");
    }

    private static boolean isDescending(ArrayList<?> data) {
        for (int i = 1; i < data.size(); i++) {
            Comparable current = (Comparable) data.get(i);
            Comparable previous = (Comparable) data.get(i - 1);
            if (current.compareTo(previous) > 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAscending(ArrayList<?> data) {
        for (int i = 1; i < data.size(); i++) {
            Comparable current = (Comparable) data.get(i);
            Comparable previous = (Comparable) data.get(i - 1);
            if (current.compareTo(previous) < 0) {
                return false;
            }
        }
        return true;
    }
    private static boolean isSorted(ArrayList<?> data, boolean descendingOrder) {
        for (int i = 1; i < data.size(); i++) {
            Comparable current = (Comparable) data.get(i);
            Comparable previous = (Comparable) data.get(i - 1);
            if (descendingOrder ? current.compareTo(previous) > 0 : current.compareTo(previous) < 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasManyDuplicates(ArrayList<?> data) {

        HashSet<?> set = new HashSet<>(data);
        return set.size() < 0.5 * data.size();
    }

    private static boolean hasSmallValueRange(ArrayList<?> data) {
        Comparable max = Collections.max((Collection<? extends Comparable>) data);
        Comparable min = Collections.min((Collection<? extends Comparable>) data);
        return (Integer) max - (Integer) min <= 100;
    }


}
