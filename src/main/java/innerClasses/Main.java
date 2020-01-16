package innerClasses;


public class Main {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("Michał");
        System.out.println(outerClass.getName());
//        System.out.println(outerClass.getAddress());
        OuterClass.InnerClass innerClass =
                outerClass.new InnerClass("X.X.X.X");
        innerClass.getAllFields();
//        System.out.println(innerClass.getAddress());
//        innerClass.getName();
//        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        OuterClass.InnerClass innerClass1 =
                outerClass.getInnerClassInstance("Y.Y.Y.Y");
    }
}
