
// Реализовать простой калькулятор
import java.util.Scanner;

public class numthree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число: ");
        Integer num = sc.nextInt();

        System.out.print("Введите знак{+, -, *, /}: ");
        String sign = sc.next();

        System.out.println("Введите число: ");
        Integer numTwo = sc.nextInt();

        switch (sign) {
            case "+":
                System.out.println(num + numTwo);
                break;
            case "-":
                System.out.println(num - numTwo);
                break;
            case "*":
                System.out.println(num * numTwo);
                break;
            case "/":
                System.out.println(num / numTwo);
                break;

            default:
                System.out.println("такой знак пока не доавлен.");
                break;
        }

    }
}
