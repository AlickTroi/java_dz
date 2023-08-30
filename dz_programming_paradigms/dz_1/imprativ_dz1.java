package dz_1;

// Задача 1: Подсчет суммы четных чисел от 1 до N. Напишите программу, используя цикл, которая находит сумму всех четных чисел в диапазоне от 1 до заданного числа N.

public class imprativ_dz1 {

    public static int evenSum(int numberTail){
        int result = 0;
        for (int i = 0; i <= numberTail; i+=2) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(evenSum(5));
    }
    
}