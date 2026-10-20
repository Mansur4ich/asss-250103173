interface Movement {
    void move();
}
class Walking implements Movement {
    public void move() {
        System.out.println("Walking:5 km/h");
    }
}
class Skateboarding implements Movement {
    public void move() {
        System.out.println("Skateboarding: 15 km/h");
    }
}

class Jetpack implements Movement {
    public void move() {
        System.out.println("Jetpack:60 km/h");
    }
}

class Player {
    Movement movement;
    Player(Movement m) {
        movement = m;
    }
    void setMovement(Movement m) {
        movement = m;
    }
    void move() {
        movement.move();
    }
}

public class Main {
    public static void main(String[] args) {
        Player p = new Player(new Walking());
        p.move();
        p.setMovement(new Jetpack());  
        p.move();
    }
}
