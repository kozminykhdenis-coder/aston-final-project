package org.team.sorting.io.input;

import java.util.ArrayList;
import java.util.List;

public class InputResult<T> {
    private final List<T> data = new ArrayList<>();
    private final List<String> warnings = new ArrayList<>();
    private final List<String> errors = new ArrayList<>();

    public List<T> getData() { return data; }
    public List<String> getWarnings() { return warnings; }
    public List<String> getErrors() { return errors; }

    public boolean isSuccess() { return errors.isEmpty(); }

    public InputResult<T> addData(List<T> list) { data.addAll(list); return this; }
    public InputResult<T> warn(String msg) { warnings.add(msg); return this; }
    public InputResult<T> error(String msg) { errors.add(msg); return this; }
}
