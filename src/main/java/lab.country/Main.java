package lab.country;

import java.util.Scanner;

/**
 * Консольное приложение для работы со странами.
 * Позволяет создавать новые записи, выводить список и завершать программу.
 */

public class Main {

    private static final String COMMAND_EXIT = "exit";
    private static final String COMMAND_CREATE = "create";
    private static final String COMMAND_PRINT = "print";
    private static final String YES = "y";
    private static final String NO = "n";
    private static final int INITIAL_CAPACITY = 10;
    private static final int GROW_FACTOR = 2;

    public static void main(String[] args) {

        Country[] countries = new Country[INITIAL_CAPACITY];
        Scanner scanner = new Scanner(System.in);

        // Инициализация тестовых данных
        countries[0] = new Country("Russia", 17100000, 146700000, "Moscow", 12600000);
        countries[1] = new Country("Finland", 338000, 5500000, "Helsinki", 655000);
        countries[2] = new Country("France", 643800, 67800000, "Paris", 2100000);
        countries[3] = new Country("Andorra", 467, 85400, "Andorra la Vella", 22600);
        countries[4] = new Country("Singapore", 2, 5700000);

        int index = 5;

        // Цикл обработки команд пользователя
        mainLoop:
        while (true) {

            System.out.println("Введите команду:");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case COMMAND_EXIT:

                    System.out.println("Программа завершена.");
                    break mainLoop;

                case COMMAND_CREATE:

                    String name;
                    while (true) {
                        System.out.println("Введите название страны:");
                        name = scanner.nextLine().trim();

                        try {
                            Country.validateName(name);
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    double area;
                    while (true) {
                        System.out.println("Введите площадь (км²):");
                        String input = scanner.nextLine().trim();

                        try {
                            area = Double.parseDouble(input);
                            Country.validateArea(area);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Введите число.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    long population;
                    while (true) {
                        System.out.println("Введите население:");
                        String input = scanner.nextLine().trim();

                        try {
                            population = Long.parseLong(input);
                            Country.validatePopulation(population);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Введите число.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    String answer;
                    Country newCountry;

                    while (true) {
                        System.out.println("Есть ли столица? (y/n):");
                        answer = scanner.nextLine().trim().toLowerCase();

                        if (!answer.equals(YES) && !answer.equals(NO)) {
                            System.out.println("Некорректный ввод. Введите 'y' или 'n'.");
                            continue;
                        }

                        if (answer.equals(NO)) {
                            newCountry = new Country(name, area, population);
                            break;
                        }

                        System.out.println("Введите название столицы:");
                        String capitalName = scanner.nextLine().trim();

                        try {
                            Country.validateCapitalName(capitalName);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Уточните свой выбор.");
                            continue;
                        }

                        long capitalPopulation;
                        while (true) {
                            System.out.println("Введите население столицы:");
                            String input = scanner.nextLine().trim();

                            try {
                                capitalPopulation = Long.parseLong(input);
                                Country.validateCapitalPopulation(capitalPopulation);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Введите число.");
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }

                        }

                        newCountry = new Country(name, area, population, capitalName, capitalPopulation);
                        break;
                    }

                    if (index >= countries.length) {
                        countries = extendArray(countries);
                    }

                    countries[index] = newCountry;

                    System.out.println("Страна добавлена: " + newCountry.getName());
                    index++;
                    break;

                case COMMAND_PRINT:
                    printAll(countries);
                    break;

                default:
                    System.out.println("Неизвестная команда. Доступные: create, print, exit.");
            }

        }
    }

    /**
     * Выводит в консоль информацию о всех непустых элементах массива стран.
     *
     * @param countries массив объектов Country для печати.
     */

    public static void printAll(Country[] countries) {

        if (countries == null || countries.length == 0) {
            return;
        }

        for (Country c : countries) {
            if (c != null) {
                System.out.println(c);
                System.out.println();
            }
        }

    }

    /**
     * Увеличивает размер массива стран, копируя все элементы
     * в новый массив, размер которого в два раза больше.
     *
     * @param oldArray исходный массив
     * @return новый расширенный массив
     */

    private static Country[] extendArray(Country[] oldArray) {
        Country[] newArray = new Country[oldArray.length * GROW_FACTOR];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        return newArray;
    }

}