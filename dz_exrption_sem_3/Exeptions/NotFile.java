package Exeptions;

import java.io.FileNotFoundException;

public class NotFile extends FileNotFoundException{
    public NotFile(String name) {
        super("файл " + name + " не найден");
    }

    public NotFile() {
        super("файл не найден");
    }
}
