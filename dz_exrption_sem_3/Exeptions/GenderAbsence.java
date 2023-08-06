package Exeptions;

public class GenderAbsence extends RuntimeException{
    public GenderAbsence(){
        super("пол не добавленно в память");
    }
}
