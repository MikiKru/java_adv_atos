package lambda_stream_optional;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectController {
    // metoda wypisującą na konoli wszystkie projekty
    public void getAllProjects(){
        InMemoryData.projects.stream()  // zamiana List<Project> na Stream<Project>
                .forEach(project -> System.out.println(project));
        // można krócej
        // InMemoryData.projects.stream().forEach(System.out::println);
        // można jeszcze krócej
        // InMemoryData.projects.forEach(System.out::println);
    }
    public List<Project> findProjectsByCategory(Category category){
        return InMemoryData.projects.stream()
                                        .filter(project -> project.getCategories().contains(category))
                                        .collect(Collectors.toList());
    }
}
