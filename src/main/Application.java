package main;
/*
import algorithms.*;
import strategies.*;
import models.Student;
*/
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.Comparator;

public class Application {
    private Object[] data;
    private  Menu menu;
    private AppConfig config;
    private ExecutorService threadPool;

    public Application() {
        this.config = AppConfig.getInstance();
        this.menu = new Menu(this);
        this.threadPool = Executor.newFixedThreadPool(2); // min 2 thread
    }
    public void start() {
        System.out.println("=== ПРИЛОЖЕНИЕ ДЛЯ СОРТИРОВКИ И ПОИСКА ===");
        menu.showMainMenu();
        shutdown();
    }
    public void loadData(int strategyType, int size) {
        try {
            DataInputStrategy<Student> strategy = createStrategy(strategyType);
            this.data = strategy.getData(size, Student.class);
            System.out.println("Данные успешно загружены! Загружено элементов: " + data.length);
        } catch (Exception e) {
            System.out.println("Ошибка при загрузке данных: " + e.getMessage());
        }
    }

    public void sortData(int field) {
        if (data == null || data.length == 0) {
            System.out.println("Нет данных для сортировки! Сначала загрузите данные.");
            return;
        }

        Comparator<Object> comparator = createComparator(field);

        // Запускаем сортировку в ThreadPool
        threadPool.execute(() -> {
            System.out.println("Начата сортировка в потоке: " + Thread.currentThread().getName());
            long startTime = System.currentTimeMillis();

            config.getSorter().sort(data, comparator);

            long endTime = System.currentTimeMillis();
            System.out.println("Сортировка завершена за " + (endTime - startTime) + " мс");
            System.out.println("Данные отсортированы по полю " + field);
        });
    }
    public void searchData(int field, String value) {
        if (data == null || data.length == 0) {
            System.out.println("Нет данных для поиска!");
            return;
        }

        try {
            Comparator<Object> comparator = createComparator(field);
            Object key = createSearchKey(field, value);

            int index = config.getBinarySearch().binarySearch(data, key, comparator);

            if (index >= 0) {
                System.out.println("Элемент найден на позиции: " + index);
                System.out.println("Найденный элемент: " + data[index]);
            } else {
                System.out.println("Элемент не найден!");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при поиске: " + e.getMessage());
        }
    }
    public void displayData() {
        if (data == null || data.length == 0) {
            System.out.println("Нет данных для отображения!");
            return;
        }

        System.out.println("\n=== ДАННЫЕ ===");
        for (int i = 0; i < data.length; i++) {
            System.out.println(i + ": " + data[i]);
        }
    }
    private DataInputStrategy<Student> createStrategy(int type) {
        switch (type) {
            case 1: return new FileInputStrategy<>();
            case 2: return new RandomInputStrategy<>();
            case 3: return new ManualInputStrategy<>();
            default: throw new IllegalArgumentException("Неизвестная стратегия: " + type);
        }
    }
    private Comparator<Object> createComparator(int field) {
        // Эти компараторы должны быть предоставлены Ч2
        // Временная заглушка
        return (o1, o2) -> 0;
    }

    private Object createSearchKey(int field, String value) {
        // Создаем объект-ключ для поиска на основе введенного значения
        // Временная реализация
        return value;
    }

    private void shutdown() {
        threadPool.shutdown();
        System.out.println("Приложение завершило работу.");
    }

    // Для тестирования
    public Object[] getData() {
        return data;
    }
}

