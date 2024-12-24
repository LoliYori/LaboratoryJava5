public class GasStationData {
    // Название компании, адрес улицы, марка топлива и цена
    private String company;
    private String street;
    private int grade;
    private int price;

    // Конструктор принимает данные о заправке
    public GasStationData(String company, String street, int grade, int price) {
        this.company = company;
        this.street = street;
        this.grade = grade;
        this.price = price;
    }

    // Геттер для марки топлива
    public int getGrade() {
        return grade;
    }

    // Геттер для цены топлива
    public int getPrice() {
        return price;
    }

    // Переопределение метода toString для строкового представления данных о заправке
    @Override
    public String toString() {
        return "Компания: " + company + ", Улица: " + street + ", Марка: " + grade + ", Цена: " + price;
    }
}
