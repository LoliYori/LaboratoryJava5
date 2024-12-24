public class Cat implements Meowable {
    // Имя кота
    private String name;

    // Конструктор принимает имя кота
    public Cat(String name) {
        this.name = name;
    }

    // Метод, выводящий сообщение о мяуканье
    @Override
    public void meow() {
        System.out.println(name + ": Мяу!");
    }

    // Метод для строкового представления объекта кота
    @Override
    public String toString() {
        return "Кот " + name;
    }
}
