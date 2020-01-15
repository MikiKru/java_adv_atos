package lambda_stream_optional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
    public List<Project> findProjectsOrderByFounds(boolean asc){
        if(!asc) {
            return InMemoryData.projects.stream()                                       // Stream<Project>
                    .sorted(Comparator.comparing(Project::calculateFounds).reversed())  // SortedStream<Project>
                    .collect(Collectors.toList());                                      // List<Project> sorted
        }else {
            return InMemoryData.projects.stream()                                       // Stream<Project>
                    .sorted(Comparator.comparingDouble(Project::calculateFounds))  // SortedStream<Project>
                    .collect(Collectors.toList());                                      // List<Project> sorted
        }
    }
    // metoda zwracająca najdroższy projekt z max wartością dofinansowania
    public Optional<Project> findMaxFinancedProject(){
        return InMemoryData.projects.stream()                                       // Stream<Project>
                .sorted(Comparator.comparing(Project::calculateFounds).reversed())  // SortedStram<Projec>
                .findFirst();                                                       // Optional<Project>
    }
    public Optional<Project> findMaxFinancedProjectMax(){
        // Stream<Project>
        // SortedStram<Projec>
        return InMemoryData.projects.stream().max(Comparator.comparing(Project::calculateFounds));                                                       // Optional<Project>
    }


}
