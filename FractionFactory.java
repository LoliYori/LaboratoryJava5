public class FractionFactory {
    // Метод создает дробь и оборачивает ее в кэширующий декоратор
    public static FractionInterface createFraction(int numerator, int denominator) {
        return new CachedFractionDecorator(new Fraction(numerator, denominator));
    }
}
