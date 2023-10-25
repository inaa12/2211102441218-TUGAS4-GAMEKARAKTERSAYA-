import greenfoot.*;

public class Character extends Actor {
    private int score = 0;
    private int lives = 3; // Jumlah nyawa karakter
    private int speed = 3; // Kecepatan karakter
    private GreenfootImage[] characterImages;
    private int animationIndex = 0;
    
    public Character() {
        setImage("images/karakter.png");
        
    }
    
    public void tembak() {
        World wrld = this.getWorld();
        Bullet bullet = new Bullet();
        bullet.setRotation(this.getRotation());
        wrld.addObject(bullet, this.getX(), this.getY());
    }

    public void act() {
        this.move(1);
        if(Greenfoot.isKeyDown("up")){
             this.setLocation(this.getX(), this.getY()-speed);
        }
        
        if(Greenfoot.isKeyDown("down")){
             this.setLocation(this.getX(), this.getY()+speed);
        }
        
        if(Greenfoot.isKeyDown("left")){
             this.setLocation(this.getX()-speed, this.getY());
        }
        
        if(Greenfoot.isKeyDown("right")){
             this.setLocation(this.getX()+speed, this.getY());
        }
    }

    public void checkForCollision() {
        Actor object = getOneIntersectingObject(ObjectSpecial.class);
        if (object != null) {
            increaseScore();
            getWorld().removeObject(object);
        }

        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            loseLife();
            getWorld().removeObject(enemy);
        }
    }
    
    public void moveCharacter() {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + speed, getY());
        }
    }

    public void increaseScore() {
        score += 10;
        getWorld().showText("Score: " + score, 50, 25);
    }

    public void loseLife() {
    lives--;
    getWorld().showText("Lives: " + lives, 50, 50);
    if (lives <= 0) {
        World world = getWorld(); // Dapatkan objek World
        world.showText("Game Over - You Lose!", world.getWidth() / 2, world.getHeight() / 2);
        Greenfoot.stop();
        }
    }


    public void checkGameOver() {
        if (score >= 100) {
            getWorld().showText("Game Over - You Win!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        }
    }
}
