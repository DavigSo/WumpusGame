package org.main;

import main.map.Map;

import java.util.Random;

public class Obstacle {
    private int x, y;
    private Map map;

    public Obstacle (Map map) {
        this.map = map;
        placeObstacle();
    }

    private void placeObstacle() {
        Random random = new Random();
        int x, y;
        do{
            x = random.nextInt(map.getSize());
            y = random.nextInt(map.getSize());

        } while (!map.isEmpty(x, y));
        map.placeElement(x, y, TiposDeElementos.OBSTACLE);
    }
}
