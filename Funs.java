import java.util.List;

public class Funs {
    // Метод вызывает meow() для каждого объекта в списке
    public static void meowsCare(List<Meowable> cats) {
        for (Meowable cat : cats) {
            cat.meow(); // Вызываем метод meow у каждого кота
        }
    }
}


