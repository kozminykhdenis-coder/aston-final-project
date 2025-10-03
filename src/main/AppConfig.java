package main;
/*
import algorithms.*;
import strategies.*;
import validation.DataValidator;
*/
public class AppConfig {
private static AppConfig instance;
private Sorter<Object> sorter;
private BinarySearch<Object> binarySearch;
private DataValidator validator;

private AppConfig() {

    this.sorter = new MergeSorter<>(); // ч2 создаст MergeSorter
    this.binarySearch = new BinarySearch<>();
    this.validator = new DataValidator();
}
public static  AppConfig getInstance() {
    if(instance ==null) {
        instance = new AppConfig();
    }
    return instance;
}

    public Sorter<Object> getSorter() { return sorter; }
    public BinarySearch<Object> getBinarySearch() { return binarySearch; }
    public DataValidator getValidator() { return validator; }
}
