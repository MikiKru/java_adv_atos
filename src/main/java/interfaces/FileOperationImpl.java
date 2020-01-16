package interfaces;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperationImpl implements FileOperation {
    File file;
    BufferedWriter bw;
    Scanner s;
    @Override
    public boolean createFile(String path) {
        file = new File(path);
        return file.exists();
    }
    @Override
    public List<String> getDataFromFile() {
        List<String> result = new ArrayList<>();
        try {
            s = new Scanner(file);
            while(s.hasNext()){
                result.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public boolean setDataToFile(String data) {
        boolean flag = false;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(data); // zapis do bufora
            bw.flush();     // zapis do pliku
            flag = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean closeFile() {
        boolean isClosed = true;
        s.close();
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            isClosed = false;
        }
        return isClosed;
    }
}
