package Exeptions;

public class BornAbsence extends RuntimeException{
    public BornAbsence(){
        super("дата рождения не добавленно в память");
    }
}