package interfaces;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperationImpl implements FileOperation, DatabaseConnector {
    private File file;
    private BufferedWriter bw;
    private Scanner s;
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
            FileWriter pw = new FileWriter(file, true);
            bw = new BufferedWriter(pw);
            bw.write(data + "\n"); // zapis do bufora
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

    @Override
    public boolean setConnection(String host, int port, String username, String password, String dbName) {
        return false;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public Object delete(Object o) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

    @Override
    public Object getOne(Long id) {
        return null;
    }
}
