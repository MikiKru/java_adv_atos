package oracleExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseList {
    public static void main(String[] args) {
        List<Integer> p = new ArrayList<>();
        p.add(7);
        p.add(7);
        p.add(1);
        p.add(5);
        p.add(1);
//        p.remove(1);
//        p.removeAll(new ArrayList<>(Arrays.asList(1,7)));
        p  = p.stream().filter(o -> (!o.equals(1)) && (!o.equals(7))).collect(Collectors.toList());
        System.out.println(p);
    }
}
