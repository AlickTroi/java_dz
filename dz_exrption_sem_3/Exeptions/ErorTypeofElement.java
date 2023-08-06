package Exeptions;

public class ErorTypeofElement extends RuntimeException{
    public ErorTypeofElement(){
        super("Вы ввели не верные типы элементов");
    }
}
