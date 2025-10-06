package tests;
import models.Student;
public class BuilderTest {

    public boolean testStudentBuilder() {
        try {
            System.out.println("Тест Student Builder...");
            // Этот тест будет дополнен, когда Ч1 предоставит класс Student
            Student student = new Student.Builder()
                    .setName("John")
                    .setAge(20)
                    .setGrade(4.5)
                    .build();

            boolean result = student != null;
            System.out.println(result ? "✅ PASSED" : "❌ FAILED");
            return result;
        } catch (Exception e) {
            System.out.println("❌ FAILED with exception: " + e.getMessage());
            return false;
        }
    }

    public boolean testProductBuilder() {
        try {
            System.out.println("Тест Product Builder...");
            // Аналогично для Product
            System.out.println("⏳ PENDING - waiting for Product class");
            return true;
        } catch (Exception e) {
            System.out.println("❌ FAILED with exception: " + e.getMessage());
            return false;
        }
    }
}
