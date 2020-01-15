package pizza;

import java.util.*;
import java.util.stream.Collectors;

public class PizzaController {
    // List<Pizza> getAllSpicy() - wypisz wszystkie pizzy ostre
    List<Pizza> getAllSpicy(){
        return Arrays.stream(Pizza.values())                            // Stream<Pizza>
                    .filter(pizza -> pizza.getIngredients().stream()    // Stream<Pizza> -> isSpicy() -> true
                                        .anyMatch(Ingredient::isSpicy)
                    )
                    .collect(Collectors.toList());                      // List<Pizza>
    }
    int getPizzaPrice(Pizza pizza){
        return pizza.getIngredients().stream().mapToInt(Ingredient::getPrice).sum();
    }
    // Pizza findCheapestSpicy() - metoda zwracająca najtańszą ostrą pizzę.
    Pizza findCheapestSpicy(){
        return Arrays.stream(Pizza.values())                                // Stream<Pizza>
                .filter(pizza -> pizza.getIngredients().stream()            // Stream<Pizza> -> isSpicy() -> true
                        .anyMatch(Ingredient::isSpicy)
                ).min(Comparator.comparing(pizza -> getPizzaPrice(pizza))   // sortowanie po sumie cen składników
                ).get();                                                    // pobranie wartości min
    }

    List<Pizza> getAllVegetarian(){
        return Arrays.stream(Pizza.values()).filter(pizza ->
                pizza.getIngredients().stream()
                        .noneMatch(Ingredient::isMeat))
                .collect(Collectors.toList());
    }
    // Pizza findMostExpensiveVegetarian() - metoda zwracająca najdroższą pizzę wegetariańską.
    Pizza findMostExpensiveVegetarian(){
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream()
                        .noneMatch(Ingredient::isMeat))
                .max(Comparator.comparing(this::getPizzaPrice))
                .get();
    }
// List iLikeMeat() - metoda zwracająca same pizzę mięsne, posortowane malejąco po liczbie składników mięsnych.
    List<Pizza> iLikeMeat(){
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream()
                        .anyMatch(Ingredient::isMeat)                   // filtrowanie po składnikach mięsnych
                )
                .sorted(Comparator.comparing(pizza -> pizza.getIngredients().stream()
                        .filter(Ingredient::isMeat)                     // filtrowanie po składnikach mięsnych
                        .count()                                        // zliczanie cześtotliwości wystepowania
                ))
                .collect(Collectors.toList());                          // zwrócenie List<Pizza>
    }
// Map groupByPrice() - metoda grupujące pizzę po cenie.
    Map<Integer, List<Pizza>> groupByPrice(){
        return Arrays.stream(Pizza.values())
                .collect(Collectors.groupingBy(this::getPizzaPrice))        // Map<>
                .entrySet().stream()
                    .sorted(Map.Entry.<Integer, List<Pizza>>comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new)
                );

    }

// String formatedMenu() - metoda zwracająca string w postaci
// nazwa_pizzy: składnik1, składnik2, składnik3 - cena, kolejne pizzę oddzielone znakiem nowej linii.
    String formatedMenu(){
        Random random = new Random();
        Pizza generatedPizza = Pizza.values()[random.nextInt(Pizza.values().length)];
        return Arrays.stream(Pizza.values())
                    .map(pizza -> String.format(
                            "| %15s | %-90s | %5.2f zł | %5s | %5s | %s",
                            pizza.getName(),
                            pizza.getIngredients().stream()
                                    .map(ingredient -> ingredient.getName())
                                    .collect(Collectors.joining(", ")),
                            generatedPizza.equals(pizza) ? (getPizzaPrice(pizza)*0.7) : getPizzaPrice(pizza),
                            pizza.getIngredients().stream().noneMatch(Ingredient::isMeat) ? "VEGE" : "",
                            pizza.getIngredients().stream().anyMatch(Ingredient::isSpicy) ? "SPICY" : "",
                            generatedPizza.equals(pizza) ? "-" + (getPizzaPrice(pizza)*0.3) : ""
                            )
                    )
                    .collect(Collectors.joining("\n"));
    }

}
