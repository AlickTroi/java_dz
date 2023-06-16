package sem_3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Пусть дан произвольный список целых чисел.
 * 
 * 1) Нужно удалить из него чётные числа
 * 2) Найти минимальное значение
 * 3) Найти максимальное значение
 * 4) Найти среднее значение
 */
public class dz_1 {

    public static ArrayList<Integer> delEvenNumber(ArrayList<Integer> arrayList) {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
            }
        }
        return arrayList;
    }

    public static Integer minValue(ArrayList<Integer> arrayList) {
        Integer min = arrayList.get(arrayList.size() - 1);
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) < min) {
                min = arrayList.get(i);
            }
        }
        return min;
    }

    public static Integer maxValue(ArrayList<Integer> arrayList) {
        Integer max = arrayList.get(arrayList.size() - 1);
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) > max) {
                max = arrayList.get(i);
            }
        }
        return max;
    }

    public static Integer average(ArrayList<Integer> arrayList) {
        Integer result = arrayList.get(arrayList.size() - 1);
        for (int i = arrayList.size() - 2; i >= 0; i--) {
            result += arrayList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(22, 11, 45, 55, 10, 13, 12, 10, 2, 5));
        delEvenNumber(list);
        System.out.println(list);
        int min = minValue(list);
        System.out.println(min);
        int max = maxValue(list);
        System.out.println(max);
        int median = average(list);
        System.out.println(median);

    }

}