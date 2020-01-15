package lambda_stream_optional;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ProjectController pc = new ProjectController();
//        pc.getAllProjects();
        Locale locale = new Locale("pl", "PL");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        pc.findProjectsOrderByFounds(true)
            .forEach(project -> System.out.printf("%50s %50s %20s \n",
                    project.getAcronim(),
                    project.getCategories().stream()
                                    .map(Enum::name)
                                    .collect(Collectors.joining(", ")),
                    currencyFormatter.format(project.calculateFounds())));
    }
}
