package org.main;

import main.map.Map;

public class Wumpus {
    private int x, y;
    private Map map;

    public Wumpus(Map map) {
        this.map = map;
        this.x = 0;
        this.y = 0;
        map.placeElement(x, y, TiposDeElementos.WUMPUS);
    }

    public void move(int newX, int newY){
        if (map.isEmpty(newX, newY)){
            map.placeElement(x, y, TiposDeElementos.EMPTY);

            x = newX;
            y = newY;

            map.placeElement(x, y, TiposDeElementos.WUMPUS);
        }
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
