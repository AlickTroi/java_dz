// Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
// 1) Умножьте два числа и верните произведение в виде связанного списка.
// 2) Сложите два числа и верните сумму в виде связанного списка.
// Одно или два числа могут быть отрицательными.

// Даны два Deque, цифры в обратном порядке.
// [3,2,1,-] - пример Deque
// [5,4,3]- пример второго Deque
// 1) -123 * 345 = -42 435
// Ответ всегда - связный список, в обычном порядке
// [-,4,2,4,3,5] - пример ответа

package sem_4;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * dz
 */
public class dz {

    public static void main(String[] args) {
        ArrayDeque<String> deque1 = new ArrayDeque<>();
        ArrayDeque<String> deque2 = new ArrayDeque<>();

        deque1.add("3");
        deque1.addLast("2");
        deque1.addLast("1");
        deque1.addLast("-");

        deque2.add("5");
        deque2.addLast("4");
        deque2.addLast("3");

        String number1 = "";
        String number2 = "";
        while (deque1.peek() != null) {
            number1 += deque1.pollLast();
        }
        while (deque2.peek() != null) {
            number2 += deque2.pollLast();
        }

        Integer num1 = Integer.parseInt(number1);
        Integer num2 = Integer.parseInt(number2);

        Integer result = num1 * num2;

        String res = String.format("%d", result);

         LinkedList<Character> chars = new LinkedList<>();
 
        for (char ch: res.toCharArray()) {
            chars.add(ch);
        }
        System.out.println(chars);


    }
}