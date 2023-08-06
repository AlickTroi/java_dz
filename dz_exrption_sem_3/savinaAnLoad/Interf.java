package savinaAnLoad;

import Exeptions.NotFile;

public interface Interf<E> {
    void loadFile(String nameFile) throws NotFile;
    boolean saveFile(E Object, String nameFile);
}