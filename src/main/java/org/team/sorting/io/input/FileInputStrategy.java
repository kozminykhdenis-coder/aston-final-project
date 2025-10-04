package org.team.sorting.io.input;

import org.team.sorting.io.validation.Validator;
import org.team.sorting.model.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileInputStrategy implements InputStrategy<Book> {
    private final String path;
    private final Validator<Book> validator;

    public FileInputStrategy(String path, Validator<Book> validator) {
        this.path = path;
        this.validator = validator;
    }

    @Override
    public InputResult<Book> load() {
        InputResult<Book> res = new InputResult<>();
        File file = new File(path);
        if (!file.exists())
            return res.error("Файл не найден: " + path);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {

            String line;
            int row = 0, ok = 0, bad = 0;
            while ((line = br.readLine()) != null) {
                row++;
                var parsed = BookParser.parse(line);
                if (parsed.isEmpty()) {
                    res.warn("Строка " + row + ": не распознана -> \"" + line + "\"");
                    bad++;
                    continue;
                }
                Book candidate = parsed.get();
                List<String> errs = validator.validate(candidate);
                if (errs.isEmpty()) {
                    res.getData().add(candidate);
                    ok++;
                } else {
                    res.warn("Строка " + row + ": " + String.join(", ", errs) + " -> \"" + line + "\"");
                    bad++;
                }
            }
            if (ok == 0 && bad > 0)
                res.error("Все строки отклонены (" + bad + ").");
            if (ok > 0 && bad > 0)
                res.warn("Пропущено строк: " + bad);
        } catch (IOException ioe) {
            res.error("Ошибка чтения файла: " + ioe.getMessage());
        }
        return res;
    }
}
