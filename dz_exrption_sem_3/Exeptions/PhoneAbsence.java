package Exeptions;

public class PhoneAbsence extends RuntimeException{
    public PhoneAbsence(){
        super("телефон не добавленно в память");
    }
}
