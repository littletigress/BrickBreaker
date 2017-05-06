/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
/**
 *
 * @author Ludy Farhan
 */
public class Play extends JPanel implements Runnable, KeyListener {
    
    // Fields
    boolean running,play,win,lose;
    private BufferedImage image, background;
    private Graphics2D g;
    LinkedList<Brick> listBrick = new LinkedList<>();
    
    int score = 0;
    Ball theBall;
    Paddle thePaddle;
    Brick b1,b2,b3,b4;
    Map map;
    
    // constructor
    public Play() {
        
        init();
        
    }
    
    public void init() {
        
        map = new Map(listBrick);
        
        theBall = new Ball();
        
        thePaddle = new Paddle();
        
        running = true;
        
        play = true;
        
        lose = false;
        
        addKeyListener(this);
        
        setFocusable(true);
        
        image = new BufferedImage(GameLauncher.WIDTH,GameLauncher.HEIGHT,BufferedImage.TYPE_INT_RGB);
        
        g = (Graphics2D) image.getGraphics();
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        File imageSrc;
        try {
            background = ImageIO.read(new File("Background_1.jpg"));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        // Game Loop
        int count = 0;
        map.Level(1); // kalo mau cek map-nya tinggal ganti map.Level(x) x-nya jadi level berapa
        update();
        draw();
        repaint();
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (play) {
            while (running && !lose) {
            
                // update
                update();
            
                // render or draw
                draw();
            
                // display
                repaint();
            
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                for (int i=0;i<listBrick.size();i++) {
                    if (listBrick.get(i).density == 0) {
                        count++;
                    }
                }
                if (count == listBrick.size()) {
                    win = true;
                }
                else count =0;
            }
        }
    }
    
    public void update() {
        
        theBall.update(thePaddle, this);
        
        for (Brick listBrick1 : listBrick) {
            theBall.update(listBrick1,this);
        }
    }
    
    public void draw() {
        
        g.drawImage(background, 0, 0, 715, 480, null);
        
        //draw scores
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.BOLD, 25));
        g.drawString("" + score, GameLauncher.WIDTH - 70, 28);
        
        if (win) {
            running = false;
            play = false;
            
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.8));
            g.setColor(Color.gray);
            g.fillRect(140, 240, 450, 100);
            g.setColor(Color.RED);
            g.setFont(new Font("Serif", Font.BOLD, 40));
            g.drawString("You Win, Your Score " + score, 155, 300);
        }
        if (lose) {
            play = false;
            
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.8));
            g.setColor(Color.gray);
            g.fillRect(140, 240, 450, 100);
            g.setColor(Color.RED);
            g.setFont(new Font("Serif", Font.BOLD, 40));
            g.drawString("You Lose", 300, 300);
        }
        theBall.draw(g);
        
        thePaddle.draw(g);
        
        for (Brick listBrick1 : listBrick) {
            if (listBrick1.density > 0){
                listBrick1.draw(g);
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.BLACK);
        
        g2.drawImage(image,0,0,GameLauncher.WIDTH,GameLauncher.HEIGHT,null);
        
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (thePaddle.getPosX() < GameLauncher.WIDTH - thePaddle.getWidth()) {
                thePaddle.moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if (thePaddle.getPosX() > 0) {
                thePaddle.moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            running = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (thePaddle.getPosX() < GameLauncher.WIDTH - thePaddle.getWidth()) {
                thePaddle.stop();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if (thePaddle.getPosX() > 0) {
                thePaddle.stop();
            }
        }
    }
}
