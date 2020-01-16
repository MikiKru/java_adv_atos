package innerClasses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OuterClass {
    private String name;

    public  InnerClass getInnerClassInstance(String address){
        return new InnerClass(address);
    }

    @Data
    @AllArgsConstructor
    public class InnerClass{
        private String address;

        public void getAllFields(){
            System.out.println(address);
            System.out.println(name);
        }
    }

}
