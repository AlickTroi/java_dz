package sem5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

// Пример:
// Иванов 1231234
// Иванов 3456345
// Иванов 5676585
// Петров 12345
// Петров 82332

public class dz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp866");

        Map<String, ArrayList<String>> nameAndNumber = new HashMap<>();
        Boolean goOn = true;
        String d = "";
        do {
            System.out.println("Введите фамилию и номер телефона: ");
            String nameNum = sc.nextLine();
            String[] nameNumber = nameNum.split(" ");

            if (!nameAndNumber.containsKey(nameNumber[0])) {
                ArrayList<String> nw = new ArrayList<>();
                nw.add(nameNumber[1]);
                nameAndNumber.put(nameNumber[0], nw);
            } else {
                ArrayList<String> nw = new ArrayList<>();
                nw = nameAndNumber.get(nameNumber[0]);
                nw.add(nameNumber[1]);
                nameAndNumber.put(nameNumber[0], nw);
            }

            System.out.println("если хотите продолжить нажмите (y/n): ");
            d = sc.nextLine();
            if (!d.equals("y")) {
                goOn = false;
            }
            System.out.println(goOn);

        } while (goOn);

        System.out.println(nameAndNumber);

        String[][] arrayWithDict = new String[nameAndNumber.size()][2];

        for (HashMap.Entry name : nameAndNumber.entrySet()) {

            for (int i = 0; i < nameAndNumber.size(); i++) {
                for (int j = 0; j < 1; j++) {
                    arrayWithDict[i][j] = name.getKey();
                    arrayWithDict[i][j] = name.getValue().length;
                }
            }

            for (int k = 0; k < arrayWithDict.length; k++) {
                for (int i = 0; i < arrayWithDict.length - 1; i++) {
                    for (int j = 0; j < arrayWithDict.length - i - 1; j++) {
                        if (arrayWithDict[k][j] > arr[k][j + 1]) {
                            int tmp = arrayWithDict[k][j];
                            arrayWithDict[k][j] = arrayWithDict[k][j + 1];
                            arrayWithDict[k][j + 1] = tmp;
                        }
                    }
                }
            }

            for (int i = 0; i < arrayWithDict.length; i++) {
                System.out.println(arrayWithDict[i][1], arrayWithDict[i][1]);
                System.out.println();
            }

        }

    }
}
