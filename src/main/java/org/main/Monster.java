package org.main;

import main.map.Map;

import java.util.Random;

public class Monster {
    private int x, y;
    private Map map;

    public Monster(Map map){
        this.map = map;
        placeMonster();
    }

    private void placeMonster() {
       Random random = new Random();
       int x, y;
       do {
           x = random.nextInt(map.getSize());
           y = random.nextInt(map.getSize());
       } while (!map.isEmpty(x, y));
       map.placeElement(x, y, TiposDeElementos.MONSTER);
    }
}
