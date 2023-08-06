package Exeptions;

public class FioAbsence extends RuntimeException{
    public FioAbsence(){
        super("Фамилия Имя Отчество не добавленно в память");
    }
}



