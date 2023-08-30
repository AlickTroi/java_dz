package dz_1;

// Задача 3: Вычисление факториала числа. Напишите программу, которая находит факториал заданного числа N с использованием рекурсии или встроенных функций.

public class declarotiv_dz3 {

    public static int getFactorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * getFactorial(number - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(10));
    }
}
