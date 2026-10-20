
interface Pizza {
    String getDescription();
    double getCost();
}
class PlainPizza implements Pizza {
    public String getDescription() {
        return "Plain Dough & Sauce";
    }

    public double getCost() {
        return 5;
    }
}

class Cheese implements Pizza {
    Pizza pizza;

    Cheese(Pizza p) {
        pizza = p;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    public double getCost() {
        return pizza.getCost() + 2;
    }
}

class Olives implements Pizza {
    Pizza pizza;

    Olives(Pizza p) {
        pizza = p;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    public double getCost() {
        return pizza.getCost() + 1;
    }
}

class Pineapple implements Pizza {
    Pizza pizza;

    Pineapple(Pizza p) {
        pizza = p;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Pineapple";
    }

    public double getCost() {
        return pizza.getCost() + 1.5;
    }
}

public class Main {
    public static void main(String[] args) {
        Pizza p = new PlainPizza();

        p = new Cheese(p);
        p = new Olives(p);
        p = new Pineapple(p);

        System.out.println(p.getDescription());
        System.out.println(p.getCost());
    }
}
