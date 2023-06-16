import java.util.Scanner;

public class sem4 {
    
    public static void main(String[] args) {
        Scanner isScanner = new Scanner(System.in);
        System.out.println("Введите equation ");
        String equation = isScanner.nextLine();

        String message = "Решения нет";
        for (int i = 0; i < 10; i++) {
            String result = equation.replace("?", Integer.toString(i));
            String[] arr = result.split(" ");
            if (Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) == Integer.parseInt(arr[4])) {
                message = result;
            }
        }
        System.out.println(message);
    }

}
