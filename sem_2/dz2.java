// 2) Реализуйте алгоритм сортировки пузырьком
//  числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.FileWriter;
import java.io.IOException;

public class dz2 {

    public static void bubbleSorter(Integer array[]) {

        try {
            FileWriter writer = new FileWriter("sem_2\\log.txt", false);
           
            for (int k = 0; k < array.length; k++) {
                    writer.write(array[k] + " ");
                }
                writer.write("\n");

            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
                for (int k = 0; k < array.length; k++) {
                    writer.write(array[k] + " ");
                }
                writer.write("\n");
            }
            writer.write("логи");
            writer.close();
        } catch (Exception e) {
            System.out.println("Что то тут не так");
        }

    }

    public static void main(String[] args) {
        Integer[] array = { 6, 0, 59, 6, 8, 11, 6, 8, 45, 3, 8, 31, 48, 12, 12, 31, 1 };

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println(" ");
        bubbleSorter(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}