import java.awt.*;
import java.util.Random;

public class Ball {
    int x, y, xVelocity, yVelocity;
    int size = 20;
    int speed = 5;

    public Ball(int x, int y) {
        reset(x, y);
    }

    public void reset(int x, int y) {
        this.x = x;
        this.y = y;
        
        Random random = new Random();
        int randomX = random.nextInt(2);
        if (randomX == 0) randomX--;
        setXDirection(randomX * speed);

        int randomY = random.nextInt(2);
        if (randomY == 0) randomY--;
        setYDirection(randomY * speed);
    }

    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }

    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, size, size);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
}