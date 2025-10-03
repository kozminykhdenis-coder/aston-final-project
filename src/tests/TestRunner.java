package tests;

public class TestRunner {
    public void runAllTests() {
        System.out.println("=== ЗАПУСК ВСЕХ ТЕСТОВ ===");

        BuilderTest builderTest = new BuilderTest();
        SortTest sortTest = new SortTest();
        SearchTest searchTest = new SearchTest();
        StrategyTest strategyTest = new StrategyTest();

        int passed = 0;
        int total = 0;

        // Запускаем тесты билдера
        System.out.println("\n--- Тесты Builder ---");
        if (builderTest.testStudentBuilder()) passed++; total++;
        if (builderTest.testProductBuilder()) passed++; total++;

        // Запускаем тесты сортировки
        System.out.println("\n--- Тесты сортировки ---");
        if (sortTest.testIntegerSort()) passed++; total++;
        if (sortTest.testStringSort()) passed++; total++;
        if (sortTest.testCustomObjectSort()) passed++; total++;

        // Запускаем тесты поиска
        System.out.println("\n--- Тесты поиска ---");
        if (searchTest.testBinarySearch()) passed++; total++;
        if (searchTest.testSearchNotFound()) passed++; total++;

        // Запускаем тесты стратегий
        System.out.println("\n--- Тесты стратегий ввода ---");
        if (strategyTest.testManualInput()) passed++; total++;
        if (strategyTest.testRandomInput()) passed++; total++;

        System.out.println("\n=== РЕЗУЛЬТАТЫ ТЕСТИРОВАНИЯ ===");
        System.out.println("Пройдено: " + passed + "/" + total);
        System.out.println(passed == total ? "✅ ВСЕ ТЕСТЫ ПРОЙДЕНЫ!" : "❌ НЕКОТОРЫЕ ТЕСТЫ ПРОВАЛЕНЫ!");
    }
}
}
