import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    // public static void main(String[] args) throws Exception {
    //     Scanner sc = new Scanner(System.in);

    //     // GettingNumber gn = new GettingNumber();
    //     // System.out.println(gn.translationStringIntoInteger("ert"));

    //     // EmptyStr es = new EmptyStr();
    //     // String str = sc.nextLine();
    //     // es.ChecForEmpty(str);
 
    // }

    public static void main(String[] args){
   try {
       int a = 90;
       int b = 3;
       System.out.println(a / b);
       printSum(23, 234);
       int[] abc = { 1, 2 };
       abc[3] = 9;
   }  catch (NullPointerException ex) {
       System.out.println("Указатель не может указывать на null!");
   } catch (IndexOutOfBoundsException ex) {
       System.out.println("Массив выходит за пределы своего размера!");
   }
}
public static void printSum(Integer a, Integer b) {
   System.out.println(a + b);
}
}
