package pizza;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
        pc.getAllSpicy().forEach(pizza -> System.out.println(
                pizza.getName() + " " + pc.getPizzaPrice(pizza) + " " + pizza.getIngredients()));
        System.out.println(pc.findCheapestSpicy() + " " + pc.getPizzaPrice(pc.findCheapestSpicy()));
        System.out.println(pc.findCheapestSpicy() + " " + pc.getPizzaPrice(pc.findCheapestSpicy()));
        pc.getAllVegetarian()
                .forEach(pizza -> System.out.printf("%20s %10d \n", pizza, pc.getPizzaPrice(pizza)));
        System.out.println(pc.findMostExpensiveVegetarian());
        pc.iLikeMeat().forEach(pizza -> System.out.printf(
                "%15s %30s\n",
                pizza,
                pizza.getIngredients().stream().filter(Ingredient::isMeat).collect(Collectors.toList())));
        System.out.println("=========================================");
        pc.groupByPrice().forEach((key, value) -> System.out.printf("%20s | %s\n", key, value));
        System.out.println(pc.formatedMenu());
    }
}
