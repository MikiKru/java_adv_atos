package lambda_stream_optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oop.UserRegistration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@Data                   // lombok -> dodane get/set toString
@AllArgsConstructor     // lombok -> dodaje kontruktor z wszystkimi polami niestatycznymi
@NoArgsConstructor      // lombok -> dodaje konstruktor domyślny
public class Project {
    private String acronim;
    private double budget;
    private int employeesNo;
    private double percentFounds;
    private Set<Category> categories; // ALT + Enter - auto podpowiedź
    private LocalDate startDate;
    private int timeline;


    public double calculateFounds(){
        return budget * percentFounds / 100;
    }

    public static void main(String[] args) {
//        System.out.println(new Project("X", 2_000_000, 20, 85,
//                new HashSet<>(Arrays.asList(Category.IT, Category.EDUCATION)),
//                LocalDate.of(2020, 1, 1), 36));
    }



}
