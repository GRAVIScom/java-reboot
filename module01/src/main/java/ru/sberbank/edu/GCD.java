package ru.sberbank.edu;

public class GCD implements CommonDivisor {
    @Override
    /** Метод вычисления НОД
     * @param - firstNumber - первое число
     * @param - secondNumber - второе число
     * @return НОД
     */
    public int getDivisor(int firstNumber, int secondNumber) {
        while (secondNumber !=0) {
            int tmp = firstNumber%secondNumber;
            firstNumber = secondNumber;
            secondNumber = tmp;
        }
        return firstNumber;
    }
}
