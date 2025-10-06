package tests;

import algorithms.Sorter;
import algorithms.MergeSorter;
import java.util.Comparator;

public class SortTest {

    public boolean testIntegerSort() {
        try {
            System.out.println("Тест сортировки целых чисел...");
            Sorter<Integer> sorter = new MergeSorter<>();
            Integer[] array = {5, 2, 8, 1, 9};
            Integer[] expected = {1, 2, 5, 8, 9};

            sorter.sort(array, Comparator.naturalOrder());

            boolean result = arraysEqual(array, expected);
            System.out.println(result ? "✅ PASSED" : "❌ FAILED");
            return result;
        } catch (Exception e) {
            System.out.println("❌ FAILED with exception: " + e.getMessage());
            return false;
        }
    }

    public boolean testStringSort() {
        try {
            System.out.println("Тест сортировки строк...");
            Sorter<String> sorter = new MergeSorter<>();
            String[] array = {"banana", "apple", "cherry"};
            String[] expected = {"apple", "banana", "cherry"};

            sorter.sort(array, Comparator.naturalOrder());

            boolean result = arraysEqual(array, expected);
            System.out.println(result ? "✅ PASSED" : "❌ FAILED");
            return result;
        } catch (Exception e) {
            System.out.println("❌ FAILED with exception: " + e.getMessage());
            return false;
        }
    }

    public boolean testCustomObjectSort() {
        try {
            System.out.println("Тест сортировки кастомных объектов...");
            // Этот тест будет дополнен, когда Ч1 предоставит классы
            System.out.println("⏳ PENDING - waiting for custom classes");
            return true; // Временно возвращаем true
        } catch (Exception e) {
            System.out.println("❌ FAILED with exception: " + e.getMessage());
            return false;
        }
    }

    private <T> boolean arraysEqual(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
}
