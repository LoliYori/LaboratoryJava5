import java.util.List;
import java.util.stream.Collectors;

public class ListProcessor {
    // Метод возвращает пересечение двух списков без повторений
    public static List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
        return list1.stream() // Преобразуем первый список в поток
                .filter(list2::contains) // Фильтруем элементы, присутствующие во втором списке
                .distinct() // Удаляем дубликаты
                .collect(Collectors.toList()); // Собираем результат в список
    }
}
