public class MeowCountDecorator implements Meowable {
    // Исходный объект, который декорируется
    private Meowable cat;
    // Счетчик количества вызовов метода meow
    private int meowCount = 0;

    // Конструктор принимает объект для декорирования
    public MeowCountDecorator(Meowable cat) {
        this.cat = cat;
    }

    // Переопределение метода meow
    @Override
    public void meow() {
        cat.meow();
        meowCount++; 
    }

    // Метод для получения количества вызовов метода meow
    public int getMeowCount() {
        return meowCount;
    }
}
