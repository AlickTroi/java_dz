// Вывести все простые числа от 1 до 1000

public class numtwo {
    public static void main(String[] args) {
        Integer n = 1000;
        int j = 0;
        for (int i = 2; i <= n; i++) {
            for (int k = 2; k <= i; k++) {
                if (i % k == 0) {
                    j++;
                }
            }
            if (j == 1) {
                System.out.println(i);
            }
            j = 0;
        }
    }
}
