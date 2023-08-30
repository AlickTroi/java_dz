package dz_1;

// Задача 2: Поиск наименьшего числа в списке. Напишите программу, которая находит наименьшее число в заданном списке с помощью цикла.

public class imprativ_dz2 {

    public static int minimalNumberFromList(int[] numberTail){
        int result = numberTail[0];
        for (int i = 1; i < numberTail.length; i++) {
            if (result > numberTail[i]) {
                result = numberTail[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] res = new int[]{5, 2, 5, 0, -3, 45, 30, -2}; 
        System.out.println(minimalNumberFromList(res));
    }
    
}
