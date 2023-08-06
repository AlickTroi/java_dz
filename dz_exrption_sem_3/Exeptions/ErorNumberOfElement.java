package Exeptions;

public class ErorNumberOfElement extends RuntimeException{
    public ErorNumberOfElement(){
        super("Вы ввели не правильное количество элементов");
    }

     public ErorNumberOfElement(int i){
        super("Вы ввели не правильное количество элементов их должно быть " + i);
    }
}