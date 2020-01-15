package lambda_stream_optional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InMemoryData {
    // zakres widoczności protected -> pakietowy
    protected static List<Project> projects = new ArrayList<>(
            Arrays.asList(
                    new Project("SmartCity", 1_500_000, 15, 85, new HashSet<>(Arrays.asList(Category.IT, Category.ENGINEERING, Category.TELECOMMUNICATION)), LocalDate.of(2020,1,1), 36),
                    new Project("ThermoNuclearCar",40_000_000,250,85.00,new HashSet<>(Arrays.asList(Category.ENGINEERING)), LocalDate.of(2020,12,1), 12),
                    new Project("Formula 1 Poslish Racing Team", 5_000_000, 25, 65, new HashSet<>(Arrays.asList(Category.ENGINEERING)), LocalDate.of(2020,11,1), 24),
                    new Project("BetterThanSmartCity", 1_200_00, 100, 90, new HashSet<>(Arrays.asList(Category.IT)), LocalDate.of(2020,11,1), 26),
                    new Project("CleanAir", 4_000_000, 25,95, new HashSet<>(Arrays.asList(Category.EDUCATION)), LocalDate.of(2020,2,1), 38),
                    new Project("DebtCollection",2_000_000, 6, 100, new HashSet<>(Arrays.asList(Category.FINANCE, Category.IT)), LocalDate.of(2020,3,1), 9),
                    new Project ("EgzoSkeleton", 6000000, 50, 50,new HashSet<>(Arrays.asList(Category.ENGINEERING, Category.IT)), LocalDate.of(2020,5,1), 11),
                    new Project ("Java", 20000,20,50, new HashSet<>(Arrays.asList(Category.IT)), LocalDate.of(2021,1,1), 10)
            )
    );
}
