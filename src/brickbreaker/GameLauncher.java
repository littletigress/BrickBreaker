/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreaker;
import javax.swing.JFrame;

/**
 *
 * @author Ludy Farhan
 */
public class GameLauncher {
    
    public static int WIDTH = 720, HEIGHT = 500;
    
    public static void main(String[] args) {
        BrickFrame frame = new BrickFrame();
        Thread thread = new Thread(frame);
        
        thread.start();
        
        frame.setVisible(true);
    }
}
