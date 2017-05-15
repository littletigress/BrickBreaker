/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Ludy Farhan
 */
public class Map {
    private LinkedList<Brick> listBrick = new LinkedList<>();
    private LinkedList<Integer> list = new LinkedList<>();
    
    public Map(LinkedList<Brick> listBrick) {
        this.listBrick = listBrick;
    }
    
    public void Level(int lvl) {
        switch(lvl){
            case 1:
                int x, y = 60;
                for (int i=0;i<3;i++) {
                    Brick c = new Brick();
                    x = 100;
                    for (int j=0;j<10;j++) {
                        Brick b = new Brick();
                        b.setPosition(x, y); // (x,y) adalah koordinat brick, dicoba-coba aja penempatannya
                        x += b.getWidth() + 6;
                        listBrick.add(b);
                    }
                    y += c.getHeight() + 6;
                }
//                for(int i = 0; i < 20; i++) {
//                    list.add(i);
//                }
                
//                System.out.println(listBrick.size());
//                Random rand = new Random();
//                while(list.size() > 10) {
//                    int index = rand.nextInt(list.size());
//                    listBrick.get(index).setDensity(3);
//                    list.remove(index);
//                }
                break;
            case 2: 
                 // setiap bikin Brick yang udah ada koordinatnya masukan ke ListBrick supaya dapat tampil di layar
                break;
            case 3: break;//isi
            case 4: break;//isi
            case 5: break;//isi
            case 6:
                y = 60;
                Brick c = new Brick();
                x = 100;
                for (int j=0;j<10;j++) {
                    Brick b = new Brick();
                    b.setPosition(x, y); // (x,y) adalah koordinat brick, dicoba-coba aja penempatannya
                    x += b.getWidth() + 6;
                    listBrick.add(b);
                }  
                    
                y += c.getHeight() + 6;
                y=60;x=100;
                for(int k=0;k<8;k++){ 
//                    for(int n=0;n<1;n++){
                        Brick d = new Brick();
                        Brick e = new Brick();
                        y += d.getHeight() + 12;
                        d.setPosition(x,y);
                        e.setPosition(x+414,y);
                        listBrick.add(d);
                        listBrick.add(e);
//                    }
                }
                        
                x=200;y=72;
                for(int p=0;p<7;p++){ 
//                    for(int n=0;n<1;n++){
                        Brick f = new Brick();
                        Brick g = new Brick();
                        y += f.getHeight() + 12;
                        int j=185;
                        j += g.getWidth()+6;
                        f.setPosition(x,y);
                        g.setPosition(x+j,y);
                        listBrick.add(f);
                        //listBrick.add(g);
//                    }
                }
                        
                x=0; y=104;
                for(int w=0;w<2;w++){
                    for(int p=0;p<3;p++){
                        for(int n=0;n<4;n++){
                            Brick d = new Brick();
                            x += d.getWidth() + 6;
                            d.setPosition(x+200,y);
                            listBrick.add(d);
                        }
                        Brick e = new Brick();
                        y += e.getHeight() + 12;
                        x=0;
                    }
                    y=232;
                }
                
                for(int i = 0; i < 20; i++) {
                    list.add(i);
                    listBrick.get(i).setDensity(3);
                }
                
                System.out.println(listBrick.size());
                Random rand = new Random();
                while(list.size() > 0) {
                    int index = rand.nextInt(list.size());
                    listBrick.get(index).setDensity(3);
                    list.remove(index);
                }
                break;
        }
    }
}
