package tests;

import strategies.DataInputStrategy;
import strategies.ManualInputStrategy;
import strategies.RandomInputStrategy;
import models.Student;
public class StrategyTest {
    public boolean testManualInput() {
        try {
            System.out.println("Тест ручного ввода...");
            DataInputStrategy<Student> strategy = new ManualInputStrategy<>();
            // Тест будет дополнен
            System.out.println("⏳ PENDING - need to implement manual input simulation");
            return true;
        } catch (Exception e) {
            System.out.println("❌ FAILED with exception: " + e.getMessage());
            return false;
        }
    }

    public boolean testRandomInput() {
        try {
            System.out.println("Тест случайного ввода...");
            DataInputStrategy<Student> strategy = new RandomInputStrategy<>();
            Student[] students = strategy.getData(5, Student.class);

            boolean result = students != null && students.length == 5;
            System.out.println(result ? "✅ PASSED" : "❌ FAILED");
            return result;
        } catch (Exception e) {
            System.out.println("❌ FAILED with exception: " + e.getMessage());
            return false;
        }
    }
}
