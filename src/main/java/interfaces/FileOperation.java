package interfaces;

import java.util.List;

public interface FileOperation {
    // pola -> publiczne, statyczne i finalne
    public static final boolean IS_AUTO_CMOMMIT = true;
    // publiczne metody abstrakcyjne -> bez ciała metody
    public abstract boolean createFile(String path);
    List<String> getDataFromFile();
    boolean setDataToFile(String data);
    boolean closeFile();
    // metody -> publiczne i statyczne
    public static boolean isAutoCommited(){
        return IS_AUTO_CMOMMIT;
    }
}
