package com.gmail.ahmedded;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 * ===== КОНСПЕКТ: Scanner в Java =====
 *
 * Scanner — это универсальный инструмент для чтения данных из:
 *  - консоли (System.in)
 *  - файлов (File)
 *  - строк (String)
 *
 * Основные возможности:
 *  1. Чтение строк: nextLine(), next()
 *  2. Чтение чисел: nextInt(), nextDouble(), nextFloat(), nextLong()
 *  3. Проверка наличия данных: hasNext(), hasNextLine(), hasNextInt()
 *  4. Разделители: useDelimiter(), по умолчанию — пробел/перенос
 *  5. Локализация: useLocale(Locale)
 *  6. Чтение по regex
 *  7. Закрытие ресурса: close()
 *
 * Важно:
 *  - nextLine() читает всю строку до \n
 *  - next() читает только до пробела
 *  - Если после nextInt() нужно nextLine(), надо дополнительно вызвать scanner.nextLine()
 */

public class Java_Scanner {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("===== SCANNER КОНСПЕКТ =====");

        /* ======================================================
         * 1. Чтение с консоли
         * ====================================================== */
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = consoleScanner.nextLine();
        System.out.println("Привет, " + name);

        System.out.print("Введите возраст: ");
        int age = consoleScanner.nextInt();
        System.out.println("Вам " + age + " лет");

        // Очистка буфера (если после чисел нужно читать строку)
        consoleScanner.nextLine();

        /* ======================================================
         * 2. Чтение из строки
         * ====================================================== */
        String data = "Иван 25 72.5";
        Scanner stringScanner = new Scanner(data);
        String sName = stringScanner.next();
        int sAge = stringScanner.nextInt();
        double weight = stringScanner.nextDouble();
        System.out.println("Имя: " + sName + ", Возраст: " + sAge + ", Вес: " + weight);
        stringScanner.close();

        /* ======================================================
         * 3. Чтение из файла
         * ====================================================== */
        File file = new File("scanner_test.txt");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            System.out.println("Строка из файла: " + fileScanner.nextLine());
        }
        fileScanner.close();

        /* ======================================================
         * 4. Использование разделителей
         * ====================================================== */
        String csvData = "apple,banana,orange";
        Scanner csvScanner = new Scanner(csvData);
        csvScanner.useDelimiter(","); // разделитель — запятая
        while (csvScanner.hasNext()) {
            System.out.println("CSV элемент: " + csvScanner.next());
        }
        csvScanner.close();

        /* ======================================================
         * 5. Чтение с учетом локали
         *
         * Для чисел с запятой вместо точки можно задать Locale
         * ====================================================== */
        String euroNumber = "12,5";
        Scanner euroScanner = new Scanner(euroNumber);
        euroScanner.useLocale(Locale.FRANCE); // теперь запятая = разделитель дроби
        double num = euroScanner.nextDouble();
        System.out.println("Число с запятой: " + num);
        euroScanner.close();

        /* ======================================================
         * 6. Чтение по шаблону (regex)
         * ====================================================== */
        String regexData = "Код: 1234";
        Scanner regexScanner = new Scanner(regexData);
        regexScanner.findInLine("\\d+"); // найдет первую последовательность цифр
        String found = regexScanner.match().group();
        System.out.println("Найдено: " + found);
        regexScanner.close();

        /* ======================================================
         * 7. Методы проверки hasNext()
         *
         * hasNext() — есть ли следующий токен
         * hasNextInt() — следующий токен — int?
         * hasNextDouble() — следующий токен — double?
         * ====================================================== */
        String checkData = "100 test 200";
        Scanner checkScanner = new Scanner(checkData);
        while (checkScanner.hasNext()) {
            if (checkScanner.hasNextInt()) {
                System.out.println("Число: " + checkScanner.nextInt());
            } else {
                System.out.println("Слово: " + checkScanner.next());
            }
        }
        checkScanner.close();

        /* ======================================================
         * 8. Закрытие Scanner
         * ====================================================== */
        consoleScanner.close();

        System.out.println("===== КОНЕЦ КОНСПЕКТА SCANNER =====");
    }
}
