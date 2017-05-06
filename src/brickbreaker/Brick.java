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
public class Brick {
    private int width,height;
    int density;
    private int x,y;
    
    // Constructors
    public Brick() {
        
        width = 40;
        height = 20;
        density = 1;
    }
    
    int getPosX() {
        return x;
    }
    
    int getPosY() {
        return y;
    }
    
    int getWidth() {
        return width;
    }
    
    int getHeight() {
        return height;
    }
    
    void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // Draw
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect((int)x, y, width, height);
    }
}
