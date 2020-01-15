package pizza;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
//    Pizza findCheapestSpicy(){
//        return Arrays.stream(Pizza.values())
//
//    }
// Pizza findMostExpensiveVegetarian() - metoda zwracająca najdroższą pizzę wegetariańską.

// List iLikeMeat() - metoda zwracająca same pizzę mięsne, posortowane malejąco po liczbie składników mięsnych.

// Map groupByPrice() - metoda grupujące pizzę po cenie.

// String formatedMenu() - metoda zwracająca string w postaci nazwa_pizzy: składnik1, składnik2, składnik3 - cena, kolejne pizzę oddzielone znakiem nowej linii.


}
