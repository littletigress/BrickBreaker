/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Ludy Farhan
 */
public class Paddle {
    // Fields
    private int x;
    private int dx;
    private int width, height;
    
    private final int Y = GameLauncher.HEIGHT - 70;
    
    // Constructors
    public Paddle() {
        
        width = 100;
        height = 10;
        dx = 10;
        x = GameLauncher.WIDTH/2 - width/2;
    }
    
    // Draw
    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillRect((int)x, Y, width, height);
    }

    void moveRight() {
        x += dx;
    }
    
    void moveLeft() {
        x -= dx;
    }
    
    void stop() {
        x += 0;
    }
    int getPosX() {
        return x;
    }
    
    int getPosY() {
        return Y;
    }
    
    int getWidth() {
        return width;
    }
    
    int getHeight() {
        return height;
    }
}
