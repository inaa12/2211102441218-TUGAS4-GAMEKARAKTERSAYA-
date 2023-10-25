import greenfoot.*;

public class Enemy extends Actor {
    public Enemy() {
        setImage("images/Enemy.png");
    }

    public void act() {
        move(-2);
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}

