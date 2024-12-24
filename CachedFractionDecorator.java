public class CachedFractionDecorator implements FractionInterface {
    // Исходный объект дроби
    private FractionInterface fraction;
    // Кэш для вещественного значения дроби
    private Double cachedValue;

    // Конструктор принимает дробь для декорирования
    public CachedFractionDecorator(FractionInterface fraction) {
        this.fraction = fraction;
    }

    // Метод возвращает вещественное значение дроби с использованием кэша
    @Override
    public double toDouble() {
        if (cachedValue == null) {
            // Если кэш пуст, вычисляем значение и сохраняем его
            cachedValue = fraction.toDouble();
        }
        return cachedValue;
    }

    // Метод для изменения числителя дроби с сбросом кэша
    @Override
    public void setNumerator(int numerator) {
        fraction.setNumerator(numerator);
        invalidateCache();
    }

    // Метод для изменения знаменателя дроби с сбросом кэша
    @Override
    public void setDenominator(int denominator) {
        fraction.setDenominator(denominator);
        invalidateCache();
    }

    // Метод для сброса кэша
    private void invalidateCache() {
        cachedValue = null;
    }

    // Метод возвращает строковое представление дроби
    @Override
    public String toString() {
        return fraction.toString();
    }

    // Метод сравнивает декорированные дроби
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CachedFractionDecorator)) {
            return false;
        }
        CachedFractionDecorator other = (CachedFractionDecorator) obj;
        return this.fraction.equals(other.fraction);
    }
}
