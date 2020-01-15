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
//        pc.findProjectsOrderByFounds(true)
//            .forEach(project -> System.out.printf("%50s %50s %20s \n",
//                    project.getAcronim(),
//                    project.getCategories().stream()
//                                    .map(Enum::name)
//                                    .collect(Collectors.joining(", ")),
//                    currencyFormatter.format(project.calculateFounds())));
//        pc.findMaxFinancedProject().ifPresent(project -> System.out.println(project));
        pc.findMaxFinancedProject().ifPresent(System.out::println);
        pc.getMaxFounds().ifPresent(System.out::println);
        pc.getAverageFounds().ifPresent(System.out::println);
        System.out.println(pc.countProjectsByCategory(Category.IT));
        System.out.println(pc.countProjectsByCategory(Category.GOTOWANIE));
        System.out.println("===========================================");
        pc.groupProjectByCategory()
                .forEach((key, value) -> System.out.printf(
                        "%50s | %d | %-30s\n",
                        key,
                        value.size(),
                        value.stream()
                                .map(project -> project.getAcronim() + " " + project.getCategories())
                                .collect(Collectors.joining(", "))
                ));
//        System.out.println(pc.existsProjectByAcronim("XXX"));
        System.out.println(pc.existsProjectByAcronim("City"));
    }
}
