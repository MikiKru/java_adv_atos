package lambda_stream_optional;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
public class Project {
    private String acronim;
    private double budget;
    private int employeesNo;
    private double percentFounds;
    private Set<Category> categories; // ALT + Enter - auto podpowiedź
    private LocalDate startDate;
    private Month timeline;

    public static void main(String[] args) {
        new Project("X", 2_000_000, 20, 85,
                new HashSet<>(Arrays.asList(Category.IT, Category.EDUCATION)),
                LocalDate.of(2020, 1, 1), Month.of(36));
    }


}
