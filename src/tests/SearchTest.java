package tests;
import algorithms.BinarySearch;
import java.util.Comparator;
public class SearchTest {
    public boolean testBinarySearch() {
        try {
            System.out.println("Тест бинарного поиска...");
            BinarySearch<Integer> search = new BinarySearch<>();
            Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

            int index = search.binarySearch(array, 5, Comparator.naturalOrder());

            boolean result = (index == 4); // 5 должно быть на позиции 4
            System.out.println(result ? "✅ PASSED" : "❌ FAILED");
            return result;
        } catch (Exception e) {
            System.out.println("❌ FAILED with exception: " + e.getMessage());
            return false;
        }
    }

    public boolean testSearchNotFound() {
        try {
            System.out.println("Тест поиска отсутствующего элемента...");
            BinarySearch<Integer> search = new BinarySearch<>();
            Integer[] array = {1, 2, 3, 4, 5};

            int index = search.binarySearch(array, 99, Comparator.naturalOrder());

            boolean result = (index < 0); // Должен вернуть отрицательное число
            System.out.println(result ? "✅ PASSED" : "❌ FAILED");
            return result;
        } catch (Exception e) {
            System.out.println("❌ FAILED with exception: " + e.getMessage());
            return false;
        }
    }
}
