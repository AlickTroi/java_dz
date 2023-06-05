// Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    
import java.util.Scanner;

public class program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: "); 
        Integer num = sc.nextInt();
        Integer result = 1;
        for (int i = 1; i <= num; i++){
            result *= i;
        }
        System.out.println(result);
        
    }
}