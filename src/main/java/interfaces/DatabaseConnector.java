package interfaces;

import java.util.List;

public interface DatabaseConnector {
    boolean setConnection(String host, int port, String username, String password, String dbName);
    // możeliwa jest metoda domyślna w interfejsie
    default void method2() {
        System.out.println("method2");
    }


    void save(Object o);
    Object delete(Object o);
    boolean deleteById(Long id);
    List<Object> getAll();
    Object getOne(Long id);


}
