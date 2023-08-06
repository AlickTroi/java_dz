

import java.util.Scanner;

public class VerificationInt {
    private Scanner scanner;

        public VerificationInt(){
        this.scanner = new Scanner(System.in);
    }

    public int translationStringIntoInteger(String parseInt) {
        if (isNumeric(parseInt)) {
            int integerParse = Integer.parseInt(parseInt);
            return integerParse;
        } else {
            while (!isNumeric(parseInt)) {
                System.out.println("Введите число: ");
                parseInt = scanner.nextLine();
            }
            int integerParse = Integer.parseInt(parseInt);
            return integerParse;
        }
    }

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
