package interfaces;

public class FileController {
    public static void main(String[] args) {
        FileOperationImpl fo = new FileOperationImpl();
//        System.out.println(fo.getClass().getResource("FileController.class"));
        System.out.println(fo.createFile("C:\\Users\\PROXIMO\\Desktop\\ATOS\\JavaAdvanced\\src\\main\\java\\interfaces\\file.txt"));
        System.out.println(fo.setDataToFile("example data"));
        System.out.println(fo.setDataToFile("example data"));
        System.out.println(fo.setDataToFile("example data"));
        System.out.println(fo.setDataToFile("example data"));
        System.out.println(fo.getDataFromFile());
        System.out.println(fo.closeFile());
    }
}
