import java.awt.*;
import java.awt.event.*;

public class Paddle {
    int id;
    int x, y, yVelocity;
    int width = 25;
    int height = 100;
    int speed = 10;

    public Paddle(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {
        if (id == 1) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                setYDirection(-speed);
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                setYDirection(speed);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        if (id == 1) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                setYDirection(0);
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                setYDirection(0);
            }
        }
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void move() {
        y = y + yVelocity;
    }

    public void draw(Graphics g) {
        if (id == 1)
            g.setColor(Color.cyan);
        else
            g.setColor(Color.pink);
            
        g.fillRect(x, y, width, height);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}