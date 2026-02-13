import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = 600;
    
    Thread gameThread;
    Image image;
    Graphics graphics;
    
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    
    int score1 = 0;
    int score2 = 0;
    
    int gameTime = 60;
    boolean gameOver = false;
    long lastTimeCheck;

    public GamePanel() {
        paddle1 = new Paddle(0, (GAME_HEIGHT / 2) - 50, 1);
        paddle2 = new Paddle(GAME_WIDTH - 25, (GAME_HEIGHT / 2) - 50, 2);
        ball = new Ball((GAME_WIDTH / 2) - 10, (GAME_HEIGHT / 2) - 10);
        
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));

        gameThread = new Thread(this);
        gameThread.start();
        
        lastTimeCheck = System.currentTimeMillis();
    }

    public void move() {
        if(!gameOver) {
            paddle1.move();
            paddle2.move();
            ball.move();
            
            if (ball.x >= GAME_WIDTH / 2) {
                int paddleCenter = paddle2.y + (paddle2.height / 2);
                int ballCenter = ball.y + (ball.size / 2);

                if (paddleCenter < ballCenter - 10) {
                    paddle2.setYDirection(5);
                } 
                else if (paddleCenter > ballCenter + 10) {
                    paddle2.setYDirection(-5);
                } 
                else {
                    paddle2.setYDirection(0); 
                }
            } 
            else {
                paddle2.setYDirection(0);
            }
        }
    }

    public void checkCollision() {
        if (ball.y <= 0) ball.setYDirection(-ball.yVelocity);
        if (ball.y >= GAME_HEIGHT - ball.size) ball.setYDirection(-ball.yVelocity);

        if (ball.getBounds().intersects(paddle1.getBounds())) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; 
        }
        if (ball.getBounds().intersects(paddle2.getBounds())) {
            ball.xVelocity = Math.abs(ball.xVelocity) * -1;
            ball.xVelocity--; 
        }

        if (paddle1.y <= 0) paddle1.y = 0;
        if (paddle1.y >= (GAME_HEIGHT - paddle1.height)) paddle1.y = GAME_HEIGHT - paddle1.height;
        if (paddle2.y <= 0) paddle2.y = 0;
        if (paddle2.y >= (GAME_HEIGHT - paddle2.height)) paddle2.y = GAME_HEIGHT - paddle2.height;

        if (ball.x <= 0) {
            score2++;
            ball.reset(GAME_WIDTH/2, GAME_HEIGHT/2);
        }
        if (ball.x >= GAME_WIDTH - ball.size) {
            score1++;
            ball.reset(GAME_WIDTH/2, GAME_HEIGHT/2);
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            if (delta >= 1) {
                if(!gameOver) {
                    move();
                    checkCollision();
                    
                    if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                        gameTime--;
                        lastTimeCheck = System.currentTimeMillis();
                        
                        if (gameTime <= 0) {
                            gameTime = 0;
                            gameOver = true;
                        }
                    }
                }
                
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
        }
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        if (!gameOver) {
            paddle1.draw(g);
            paddle2.draw(g);
            ball.draw(g);
            
            g.setColor(Color.white);
            g.setFont(new Font("Consolas", Font.PLAIN, 60));
            g.drawString(String.valueOf(score1), (GAME_WIDTH / 2) - 85, 100);
            g.drawString(String.valueOf(score2), (GAME_WIDTH / 2) + 20, 100);
            
            g.setFont(new Font("Consolas", Font.PLAIN, 30));
            g.setColor(Color.yellow);
            g.drawString("Time: " + gameTime, (GAME_WIDTH / 2) - 60, 30);
            
        } else {
            g.setColor(Color.red);
            g.setFont(new Font("Consolas", Font.BOLD, 75));
            FontMetrics metrics1 = getFontMetrics(g.getFont());
            g.drawString("GAME OVER", (GAME_WIDTH - metrics1.stringWidth("GAME OVER"))/2, GAME_HEIGHT/2 - 50);
            
            g.setColor(Color.white);
            g.setFont(new Font("Consolas", Font.PLAIN, 40));
            String finalScore = "Final Score: " + score1 + " - " + score2;
            FontMetrics metrics2 = getFontMetrics(g.getFont());
            g.drawString(finalScore, (GAME_WIDTH - metrics2.stringWidth(finalScore))/2, GAME_HEIGHT/2 + 50);
            
            String winner = "";
            if(score1 > score2) winner = "PLAYER WINS!";
            else if(score2 > score1) winner = "COMPUTER WINS!";
            else winner = "IT'S A DRAW!";
            
            g.setColor(Color.green);
            g.drawString(winner, (GAME_WIDTH - metrics2.stringWidth(winner))/2, GAME_HEIGHT/2 + 100);
        }
    }
}