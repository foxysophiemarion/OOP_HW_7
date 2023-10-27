package HW_OOP_Seminar7.Model;

/** Класс для математических операций с комплексными числами
 *
 */
public class ComplexNumMath {
    ComplexNumber number;

    /**Сложение двух комплексных чисел
     * @param a1 первое число
     * @param b1 второе число
     * @return результат сложения комплексных чисел (a1 + b1)
     */
    public static ComplexNumber add(ComplexNumber a1, ComplexNumber b1)
    {
        return new ComplexNumber(a1.getReal() + b1.getReal(), a1.getImaginary() + b1.getImaginary());
    }

    /**Вычитание из первого комплексного числа второго
     * @param a1 первое число
     * @param b1 второе число
     * @return результат вычитания комплексных чисел (a1 - b1)
     */
    public static ComplexNumber subtract(ComplexNumber a1, ComplexNumber b1)
    {
        return new ComplexNumber(a1.getReal() - b1.getReal(), a1.getImaginary() - b1.getImaginary());
    }
    /**Умножение первого комплексного числа на второе
     * @param a1 первое число
     * @param b1 второе число
     * @return результат умножения комплексных чисел (a1 * b1)
     */
    public static ComplexNumber multiply(ComplexNumber a1, ComplexNumber b1)
    {
        return new ComplexNumber(a1.getReal() * b1.getReal() - a1.getImaginary() * b1.getImaginary(),
                                a1.getReal() * b1.getImaginary() + a1.getImaginary() * b1.getReal());
    }
    /**
     * Деление первого комплексного числа на второе
     * @param a1 первое число
     * @param b1 второе число
     * @return результат деления комплексных чисел (a1 / b1)
     */
    public static ComplexNumber divide(ComplexNumber a1, ComplexNumber b1)
    {
        return new ComplexNumber((a1.getReal() * b1.getReal() + a1.getImaginary() * b1.getImaginary()) / (b1.getReal() * b1.getReal() + b1.getImaginary() * b1.getImaginary()),
                                (a1.getImaginary() * b1.getReal() - a1.getReal() * b1.getImaginary()) / (b1.getReal() * b1.getReal() + b1.getImaginary() * b1.getImaginary()));
    }
}
