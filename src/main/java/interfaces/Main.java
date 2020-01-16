package interfaces;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileOperationImpl foi = new FileOperationImpl();
//        Proxy p = new Proxy(); -> nie można utworzyć instancji kalsy abstrakcyjnej
        Proxy fileOperation = new FileOperationImpl();
        System.out.println(fileOperation.getClass().getName());

        // klasa anonimowa
        DatabaseConnector databaseConnector = new DatabaseConnector() {
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
        };
//        List<String> elements = new List<>();
    }

}
