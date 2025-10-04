package org.team.sorting.io.validation;

import java.util.List;

public interface Validator<T> {
    List<String> validate(T value);
}
