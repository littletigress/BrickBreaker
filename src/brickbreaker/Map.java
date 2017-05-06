/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import java.util.LinkedList;

/**
 *
 * @author Ludy Farhan
 */
public class Map {
    private LinkedList<Brick> listBrick = new LinkedList<>();
    
    public Map(LinkedList<Brick> listBrick) {
        this.listBrick = listBrick;
    }
    
    public void Level(int lvl) {
        switch(lvl){
            case 1:
                int x, y = 60;
                for (int i=0;i<2;i++) {
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
                break;
            case 2: 
                // contoh (bisa dihapus kalau merasa udah ngerti)
                Brick b = new Brick();
                b.setPosition(100, 60); // akan menghasilkan Brick yang terletak di koordinat (100,60)
                listBrick.add(b); // setiap bikin Brick yang udah ada koordinatnya masukan ke ListBrick supaya dapat tampil di layar
                break;
            case 3: break;//isi
            case 4: break;//isi
            case 5: break;//isi
            case 6: break;//isi
        }
    }
}
