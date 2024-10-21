package org.main;

import main.map.Map;

import java.util.Random;

public class Chest {
    private int x, y;
    private TiposDeElementos type;
    private Map map;

    public Chest(Map map, TiposDeElementos type) {
        this.map = map;
        this.type = type;
        placeChest();
    }

    public void placeChest(){
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(map.getSize());
            y = random.nextInt(map.getSize());
        } while (!map.isEmpty(x, y));
        map.placeElement(x, y, type);
    }
}
