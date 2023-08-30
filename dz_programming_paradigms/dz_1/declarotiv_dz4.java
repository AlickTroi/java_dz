package dz_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// Задача 4: Поиск уникальных элементов в списке. Напишите программу, которая создает новый список, содержащий только уникальные элементы из исходного списка.

public class declarotiv_dz4 {

    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("vasia");
        name.add("Gendelf");
        name.add("ania");
        name.add("vasia");
        name.add("ania");
        name.add("vasia");

        Set<String> uniqueName = new HashSet<>(name);

        System.out.println(uniqueName);
    }
}
