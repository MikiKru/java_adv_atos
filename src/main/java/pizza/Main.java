package pizza;

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
    }
}
