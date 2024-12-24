import java.util.List;

public class Polyline {
    // Список точек, составляющих ломаную линию
    private List<Point> points;

    // Конструктор принимает список точек
    public Polyline(List<Point> points) {
        this.points = points;
    }

    // Переопределение метода toString для строкового представления ломаной линии
    @Override
    public String toString() {
        return "Ломаная линия: " + points;
    }
}
