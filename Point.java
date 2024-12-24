import java.util.Objects;

public class Point {
    // Координаты точки
    int x, y;

    // Конструктор принимает координаты x и y
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Переопределение метода equals для сравнения объектов точек
    @Override
    public boolean equals(Object obj) {
        // Если ссылки на объекты совпадают, они равны
        if (this == obj) return true;
        // Если объект null или не является точкой, они не равны
        if (obj == null || getClass() != obj.getClass()) return false;
        // Приводим объект к типу Point и сравниваем координаты
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    // Переопределение метода hashCode для корректной работы в коллекциях
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // Метод для строкового представления точки
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
