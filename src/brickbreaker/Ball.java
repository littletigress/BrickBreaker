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

public class Ball {
    private int x,y,dx,dy;
    private int ballsize = 16;
    
    public Ball() {
        x = GameLauncher.WIDTH / 2 - 4;
        y = GameLauncher.HEIGHT - 86;
        
        dx = -2;
        dy = -2;
    }
    
    public void update(Paddle p, Play panel) {
        setPosition(p,panel);
    }
    
    public void update(Brick b, Play panel) {
        setPosition(b, panel);
    }
    
    public void setPosition(Paddle p, Play panel) {
        
        x += dx;
        y += dy;
        
        if(x < 4) {
            dx = -dx;
        }
        if(y < 38) {
            dy = -dy;
        }
        if(x > GameLauncher.WIDTH - (2*ballsize)) {
            dx = -dx;
        }
        if(y > GameLauncher.HEIGHT - (ballsize)) {
            panel.lose = true;
        }
        
        if (y + ballsize >= p.getPosY() && y <= p.getPosY() + p.getHeight() ) {
            if ( x + ballsize>= p.getPosX() && x <= p.getPosX() + p.getWidth()) {
                if (x + ballsize == p.getPosX() || x == p.getPosX() + p.getWidth()){
                    dx = -dx;
                }
                else if (y + ballsize >= p.getPosY() || y <= p.getPosY() + p.getHeight()){
                    dy = -dy;
                }
            }
        }
    }
    
    public void setPosition(Brick b, Play panel) {
        if (b.density > 0) {
            if (y + ballsize >= b.getPosY() && y <= b.getPosY() + b.getHeight() ) {
                if ( x + ballsize>= b.getPosX() && x <= b.getPosX() + b.getWidth()) {
                    b.density = 0;
                    if (y + ballsize == b.getPosY() || y == b.getPosY() + b.getHeight()){
                        dy = -dy;
                        panel.score += 5;
                    }
                    else if (x + ballsize == b.getPosX() || x == b.getPosX() + b.getWidth()){
                        dx = -dx;
                        panel.score += 5;
                    }
                }
            }
        }
    }
    
    public void draw(Graphics2D g) {
        
        g.setColor(Color.DARK_GRAY);
        //g.setStroke(new BasicStroke(4));
        g.fillOval(x,y,ballsize,ballsize);
    }
}
