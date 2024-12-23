import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        // Задание 1: Работа с дробями
        FractionInterface fraction = FractionFactory.createFraction(4, 5); // Создаем дробь 4/5
        FractionInterface fraction2 = FractionFactory.createFraction(1, 3); // Создаем дробь 1/3
        System.out.println("Дробь 1: " + fraction); // Выводим дробь 1
        System.out.println("Дробь 2: " + fraction2); // Выводим дробь 2
        System.out.println("Вещественное значение дроби 1: " + fraction.toDouble()); // Получаем вещественное значение дроби 1

        System.out.println("Дробь 1 равна дроби 2: " + fraction.equals(fraction2)); // Сравниваем дробь 1 и дробь 2

        fraction.setNumerator(1); // Устанавливаем числитель дроби 1 в 1
        System.out.println("Изменённая дробь 1: " + fraction); // Выводим измененную дробь 1
        System.out.println("Вещественное значение измененной дроби 1: " + fraction.toDouble()); // Получаем вещественное значение измененной дроби 1

        fraction.setDenominator(3); // Устанавливаем знаменатель дроби 1 в 3
        System.out.println("Изменённая дробь 1: " + fraction); // Выводим измененную дробь 1
        System.out.println("Вещественное значение измененной дроби 1: " + fraction.toDouble()); // Получаем вещественное значение измененной дроби 1

        System.out.println("Дробь 1 равна дроби 2: " + fraction.equals(fraction2)); // Повторно сравниваем дробь 1 и дробь 2

        // Задание 2: Работа с котами
        Meowable cat1 = new Cat("Барсик"); // Создаем объект кота "Барсик"
        Meowable cat2 = new Cat("Мурзик"); // Создаем объект кота "Мурзик"

        // Оборачиваем котов в декораторы для подсчета мяуканий
        Meowable decoratedCat1 = new MeowCountDecorator(cat1); // Оборачиваем "Барсика"
        Meowable decoratedCat2 = new MeowCountDecorator(cat2); // Оборачиваем "Мурзика"

        // Создаем список котов
        List<Meowable> cats = new ArrayList<>();
        cats.add(decoratedCat1); // Добавляем "Барсика"
        cats.add(decoratedCat2); // Добавляем "Мурзика"

        // Передаем список котов в метод meowsCare
        Funs.meowsCare(cats); // Кормим котов и они мяукают

        // Выводим количество мяуканий каждого кота
        MeowCountDecorator countDecorator1 = (MeowCountDecorator) decoratedCat1; // Получаем декоратор для "Барсика"
        MeowCountDecorator countDecorator2 = (MeowCountDecorator) decoratedCat2; // Получаем декоратор для "Мурзика"

        System.out.println("Барсик мяукал " + countDecorator1.getMeowCount() + " раз"); // Выводим количество мяуканий "Барсика"
        System.out.println("Мурзик мяукал " + countDecorator2.getMeowCount() + " раз"); // Выводим количество мяуканий "Мурзика"

        // Задание 3: Формирование списка L
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5); // Список 1
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7); // Список 2
        List<Integer> intersection = ListProcessor.intersection(list1, list2); // Находим пересечение двух списков
        System.out.println("Пересечение списков: " + intersection); // Выводим пересечение списков

        // Задание 4
        try {
            // Анализируем файл с ценами на бензин
            Map<Integer, Long> result = GasStationAnalyzer.analyze("gas_prices.txt"); 
            System.out.println("Результаты анализа цен на бензин:");
            // Выводим марки и количество АЗС
            result.forEach((grade, count) -> System.out.println("Марка: " + grade + ", Количество АЗС: " + count));
        } catch (IOException e) {
            System.err.println("Ошибка при анализе цен на бензин: " + e.getMessage()); // Обрабатываем ошибку при чтении файла
        }

        // ЗАДАНИЕ 5
        try {
            // Читаем текст из файла
            String text = Files.readString(Paths.get("text.txt"));

            // Оставляем только русские буквы и переводим их в нижний регистр
            Set<Character> uniqueLetters = new HashSet<>();
            for (char c : text.toLowerCase().toCharArray()) { 
                if (Character.isLetter(c) && (c >= 'а' && c <= 'я')) { 
                    uniqueLetters.add(c); // Добавляем уникальные буквы в множество
                }
            }

            // Выводим количество уникальных букв
            System.out.println("Количество уникальных букв в тексте: " + uniqueLetters.size());
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage()); // Обрабатываем ошибку чтения файла
        }

        // ЗАДАНИЕ 6: Построение очереди из списка
        List<Integer> inputList = Arrays.asList(1, 2, 3); // Исходный список
        Queue<Integer> queue = buildQueue(inputList); // Формируем очередь
        System.out.println("Построенная очередь: " + queue); // Выводим очередь

        // ЗАДАНИЕ 7.1

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество точек"); // Просим ввести количество точек
        int N = scanner.nextInt(); // Читаем количество точек
        scanner.nextLine();  // Переход на новую строку после ввода чисел

        Map<String, Integer> athleteScores = new HashMap<>();
        List<Point> points = new ArrayList<>(); // Список точек

        for (int i = 0; i < N; i++) {
            System.out.println("Введите X для точки " + (i + 1) + ":"); 
            int X = scanner.nextInt(); // Читаем X
            System.out.println("Введите Y для точки " + (i + 1) + ":"); 
            int Y = scanner.nextInt(); // Читаем Y
            points.add(new Point(X, Y)); // Добавляем точку в список
        }

        // Преобразование и обработка данных с использованием Stream API
        Polyline polyline = new Polyline(
                points.stream()
                        .map(point -> new Point(point.x, Math.abs(point.y))) // Преобразуем отрицательные Y в положительные
                        .distinct() // Убираем дублирующиеся точки
                        .sorted(Comparator.comparingInt(point -> point.x)) // Сортируем по координате X
                        .collect(Collectors.toList()) // Собираем результат в список
        );

        // Вывод результата
        System.out.println(polyline); 
        scanner.close();

        // ЗАДАНИЕ 7.2
        Path path = Paths.get("name.txt");

        try {
            Map<Integer, List<String>> groupedPeople = Files.lines(path)
                    .filter(line -> line.contains(":")) // Фильтруем строки с разделителем ':'
                    .map(line -> {
                        String[] parts = line.split(":"); // Разбиваем строку на части
                        if (parts.length != 2) return null; // Игнорируем некорректные строки

                        String name = parts[0].trim(); // Убираем пробелы в имени
                        String numberStr = parts[1].trim(); // Убираем пробелы в номере

                        try {
                            int number = Integer.parseInt(numberStr); // Преобразуем номер в число
                            String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase(); 
                            return new AbstractMap.SimpleEntry<>(formattedName, number); // Форматируем имя
                        } catch (NumberFormatException e) {
                            return null; // Игнорируем некорректные строки
                        }
                    })
                    .filter(Objects::nonNull) // Убираем null значения
                    .collect(Collectors.groupingBy(
                            Map.Entry::getValue, // Группируем по номеру
                            Collectors.mapping(Map.Entry::getKey, Collectors.toList()) // Собираем имена в список
                    ));

            // Выводим результат
            System.out.println(groupedPeople);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Построение очереди из списка
    public static Queue<Integer> buildQueue(List<Integer> list) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(list); // Добавляем элементы списка в очередь
        for (int i = list.size() - 1; i >= 0; i--) {
            queue.add(list.get(i)); // Добавляем элементы в обратном порядке
        }
        return queue;
    }

    // Проверка, является ли строка числом
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
