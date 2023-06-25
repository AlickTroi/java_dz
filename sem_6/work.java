package sem_6;

import java.util.Scanner;

public class work {

    public static void main(String[] args) {
        laptop Qwery = new laptop();
        Qwery.laptop("Qwery", "16", "500", "Windows", "Black");
        laptop Dexp = new laptop();
        Dexp.laptop("Dexp", "4", "50", "Windows", "Pink");
        laptop Abc = new laptop();
        Abc.laptop("Abc", "8", "500", "Linux", "White");
        laptop Zenda = new laptop();
        Zenda.laptop("Zenda", "64", "5000", "Linux", "Black");
        laptop Niwer = new laptop();
        Niwer.laptop("Niwer", "32", "1000", "Windows", "Red");
        laptop Ababas = new laptop();
        Ababas.laptop("Ababas", "6", "100", "Windows", "Black");
        laptop Shore = new laptop();
        Shore.laptop("Shore", "32", "2048", "Linux", "White");

        laptop[] arr = { Qwery, Dexp, Abc, Zenda, Niwer, Ababas, Shore };

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].filter("color", "Black")) {
                arr[i].printLaptop();
                System.out.println();
            }

        }

    }

}
