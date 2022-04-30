package ZeldaMiniClone;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

public class World {

    public static List<Blocks> blocos = new ArrayList<Blocks>();

    public World(){
        blocos.add(new Blocks(96, 96));
        blocos.add(new Blocks(160, 160));
        blocos.add(new Blocks(520, 176));
        for(int xx = 0; xx < 640/32; xx++){
            blocos.add(new Blocks(xx*32,0));
        }
        for(int xx = 0; xx < 400/32; xx++){
            blocos.add(new Blocks(xx*32,240));
        }
        for(int xx = 0; xx < 640/32; xx++){
            blocos.add(new Blocks(xx*32,480-32));
        }

        for(int yy = 0; yy < 480/32; yy++){
            blocos.add(new Blocks(0, yy*32));
        }
        for(int yy = 0; yy < 480/32; yy++){
            blocos.add(new Blocks(640-32, yy*32));
        }
    }

    public static boolean isFree(int x, int y){
        for(int i = 0; i < blocos.size(); i++){
            Blocks blocoAtual = blocos.get(i);
            if(blocoAtual.intersects(new Rectangle(x, y, 32, 32))){
                return false;
            }
        }
        return true;
    }

    public void render(Graphics g){
        for(int i = 0; i < blocos.size(); i++){
            blocos.get(i).render(g);
        }
    }
}
