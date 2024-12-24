public class Fraction implements FractionInterface {
    // Поля для числителя и знаменателя дроби
    private int numerator;
    private int denominator;

    // Конструктор для создания объекта дроби
    public Fraction(int numerator, int denominator) {
        // Проверяем, что знаменатель не равен нулю
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулевым");
        }
        // Если знаменатель отрицательный, меняем знаки числителя и знаменателя
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        // Устанавливаем значения числителя и знаменателя
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Метод для получения вещественного значения дроби
    @Override
    public double toDouble() {
        return (double) numerator / denominator;
    }

    // Метод для изменения числителя дроби
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    // Метод для изменения знаменателя дроби
    @Override
    public void setDenominator(int denominator) {
        // Проверяем, что знаменатель не равен нулю
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулевым");
        }
        // Если знаменатель отрицательный, меняем знаки числителя и знаменателя
        if (denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -denominator;
        } else {
            // Устанавливаем новый знаменатель
            this.denominator = denominator;
        }
    }

    // Метод для представления дроби в виде строки
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Метод для сравнения двух дробей на равенство
    @Override
    public boolean equals(Object obj) {
        // Проверяем, что сравниваются ссылки на один объект
        if (this == obj) {
            return true;
        }
        // Проверяем, что объект является экземпляром класса Fraction
        if (!(obj instanceof Fraction)) {
            return false;
        }
        // Сравниваем числители и знаменатели дробей
        Fraction other = (Fraction) obj;
        return (this.numerator == other.numerator) && (this.denominator == other.denominator);
    }
}
