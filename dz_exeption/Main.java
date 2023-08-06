import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        GettingNumber gn = new GettingNumber();
        System.out.println(gn.translationStringIntoInteger("ert"));

        EmptyStr es = new EmptyStr();
        String str = sc.nextLine();
        es.ChecForEmpty(str);
 
     }
}
