package org.team.sorting.util;

import java.util.Scanner;

public final class ConsoleUtils {
    private ConsoleUtils() {}

    public static int safeInt(Scanner sc) {
        while (true) {
            String v = sc.nextLine().trim();
            try {
                return Integer.parseInt(v);
            } catch (NumberFormatException e) {
                System.out.print("Нужно целое число, попробуйте ещё раз: ");
            }
        }
    }
}
