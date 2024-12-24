import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class GasStationAnalyzer {
    // Метод анализирует данные о заправках из файла и возвращает карту с ключами — марками топлива и значениями — количеством минимальных цен для каждой марки
    public static Map<Integer, Long> analyze(String filePath) throws IOException {
        // Чтение файла и преобразование строк в объекты GasStationData
        List<GasStationData> data = Files.lines(Paths.get(filePath)) // Читаем строки из файла
                .skip(1) // Пропускаем первую строку (если это заголовок)
                .map(line -> {
                    String[] parts = line.split(" "); // Разделяем строку на части
                    return new GasStationData(
                            parts[0], // Компания
                            parts[1], // Улица
                            Integer.parseInt(parts[2]), // Марка
                            Integer.parseInt(parts[3]) // Цена
                    );
                })
                .collect(Collectors.toList()); // Собираем в список

        // Поиск минимальной цены для каждой марки топлива
        Map<Integer, Integer> minPrices = data.stream()
                .collect(Collectors.groupingBy(
                        GasStationData::getGrade, // Группировка по марке топлива
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(GasStationData::getPrice)), // Поиск минимальной цены
                                opt -> opt.map(GasStationData::getPrice).orElse(Integer.MAX_VALUE) // Извлечение минимальной цены
                        )
                ));

        // Подсчет количества заправок с минимальной ценой для каждой марки топлива
        return data.stream()
                .filter(entry -> minPrices.get(entry.getGrade()) == entry.getPrice()) // Фильтруем записи с минимальной ценой
                .collect(Collectors.groupingBy(
                        GasStationData::getGrade, // Группировка по марке топлива
                        Collectors.counting() // Подсчет количества записей
                ));
    }
}
