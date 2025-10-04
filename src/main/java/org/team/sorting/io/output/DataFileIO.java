package org.team.sorting.io.output;

import org.team.sorting.model.Book;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class DataFileIO {
    private DataFileIO() {}

    public static void appendBooks(String path, List<Book> books, boolean writeHeader) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8))) {

            if (writeHeader) {
                bw.write("# title;year;pages");
                bw.newLine();
            }
            for (Book b : books) {
                bw.write(b.getTitle() + ";" + b.getYear() + ";" + b.getPages());
                bw.newLine();
            }
        }
    }

}
