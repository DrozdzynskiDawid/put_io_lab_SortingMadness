package pl.put.poznan.sorting.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class AutomaticAlgorithmSelectorTest {
    private AutomaticAlgorithmSelector algorithmSelector = null;

    @BeforeEach
    public void setUp() {
        algorithmSelector = new AutomaticAlgorithmSelector();
    }

    @Test
    public void testIsDescendingFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        ArrayList<Integer> array = new ArrayList<>(numbers);

        Method privateMethod = AutomaticAlgorithmSelector.class.getDeclaredMethod("isDescending", ArrayList.class);
        privateMethod.setAccessible(true);

        boolean result = (boolean) privateMethod.invoke(algorithmSelector, array);
        assertFalse(result);
    }

    @Test
    public void testIsDescendingTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> numbers = Arrays.asList(100,50,1);
        ArrayList<Integer> array = new ArrayList<>(numbers);

        Method privateMethod = AutomaticAlgorithmSelector.class.getDeclaredMethod("isDescending", ArrayList.class);
        privateMethod.setAccessible(true);

        boolean result = (boolean) privateMethod.invoke(algorithmSelector, array);
        assertTrue(result);
    }

    @Test
    public void testIsAscendingTrue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> numbers = Arrays.asList(1,546546,99999999);
        ArrayList<Integer> array = new ArrayList<>(numbers);

        Method privateMethod = AutomaticAlgorithmSelector.class.getDeclaredMethod("isAscending", ArrayList.class);
        privateMethod.setAccessible(true);

        boolean result = (boolean) privateMethod.invoke(algorithmSelector, array);
        assertTrue(result);
    }

    @Test
    public void testIsAscendingFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> numbers = Arrays.asList(100,50,1);
        ArrayList<Integer> array = new ArrayList<>(numbers);

        Method privateMethod = AutomaticAlgorithmSelector.class.getDeclaredMethod("isAscending", ArrayList.class);
        privateMethod.setAccessible(true);

        boolean result = (boolean) privateMethod.invoke(algorithmSelector, array);
        assertFalse(result);
    }

    @Test
    public void testIsSortedAsc() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> numbers = Arrays.asList(100,50,1,0);
        ArrayList<Integer> array = new ArrayList<>(numbers);

        Method privateMethod = AutomaticAlgorithmSelector.class.getDeclaredMethod("isSorted", ArrayList.class, boolean.class);
        privateMethod.setAccessible(true);

        boolean result = (boolean) privateMethod.invoke(algorithmSelector, array, false);
        assertFalse(result);
    }

    @Test
    public void testIsSortedDesc() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> words = Arrays.asList("zzzz","yeti","david","algorithm");
        ArrayList<String> array = new ArrayList<>(words);

        Method privateMethod = AutomaticAlgorithmSelector.class.getDeclaredMethod("isSorted", ArrayList.class, boolean.class);
        privateMethod.setAccessible(true);

        boolean result = (boolean) privateMethod.invoke(algorithmSelector, array, true);
        assertTrue(result);
    }

    @Test
    public void testHasManyDuplicates() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        ArrayList<Integer> array = new ArrayList<>(numbers);

        Method privateMethod = AutomaticAlgorithmSelector.class.getDeclaredMethod("hasManyDuplicates", ArrayList.class);
        privateMethod.setAccessible(true);

        boolean result = (boolean) privateMethod.invoke(algorithmSelector, array);
        assertFalse(result);
    }

    @Test
    public void testHasSmallValueRange() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        ArrayList<Integer> array = new ArrayList<>(numbers);

        Method privateMethod = AutomaticAlgorithmSelector.class.getDeclaredMethod("hasSmallValueRange", ArrayList.class);
        privateMethod.setAccessible(true);

        boolean result = (boolean) privateMethod.invoke(algorithmSelector, array);
        assertTrue(result);
    }

    @Test
    public void testHasSmallValueRangeFalse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,9999);
        ArrayList<Integer> array = new ArrayList<>(numbers);

        Method privateMethod = AutomaticAlgorithmSelector.class.getDeclaredMethod("hasSmallValueRange", ArrayList.class);
        privateMethod.setAccessible(true);

        boolean result = (boolean) privateMethod.invoke(algorithmSelector, array);
        assertFalse(result);
    }

}