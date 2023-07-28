// Реализуйте метод, который запрашивает
// у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста
// вместо числа не должно приводить к падению 
// приложения, вместо этого, необходимо повторно запросить
// у пользователя ввод данных.

import java.util.Scanner;

public class GettingNumber {

    private Scanner scanner;

        public GettingNumber(){
        this.scanner = new Scanner(System.in);
    }

    public float translationStringIntoInteger(String parseInt) {
        float integerParse;
        if (isNumeric(parseInt)) {
            integerParse = Float.parseFloat(parseInt);
            return integerParse;
        } else {
            while (!isNumeric(parseInt)) {
                System.out.println("Введите число: ");
                parseInt = scanner.nextLine();
            }
            integerParse = Integer.parseInt(parseInt);
            return integerParse;
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}