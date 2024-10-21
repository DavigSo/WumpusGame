package org.main;

import main.map.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private Map map;
    private Wumpus wumpus;
    private List<Obstacle> obstacles;
    private List<Monster> monsters;
    private List<Chest> chests;
    public Game(){
        map = new Map();
        wumpus = new Wumpus(map);
        obstacles = new ArrayList<>();
        monsters = new ArrayList<>();
        chests = new ArrayList<>();

        generateTreasures();
        generateObstacles();
        generateMonsters();
        generateChests();

        map.displayMap();
    }

    private void generateTreasures(){
        Random random = new Random();
        int treasuresPlaced = 0;

        while (treasuresPlaced < 2){
            int col = random.nextInt(8);
            if (map.placeElement(7, col, TiposDeElementos.TREASURE_A)) {
                treasuresPlaced++;
            }
        }

        treasuresPlaced = 0;
        while (treasuresPlaced< 2) {
            int row = random.nextInt(8);
            if (map.placeElement(row, 7, TiposDeElementos.TREASURE_B)) {
                treasuresPlaced++;
            }
        }

    }
    private void generateObstacles(){
        Random random =  new Random();
        int count = 0;
        while(count < 3) {
            int startX = random.nextInt(6);
            int startY = random.nextInt(6);

            if(startX != 0 && startY != 0 && startX != 1
                    && startY != 0 && startX != 0 && startY != 1
                    && map.isEmpty(startX, startY) && map.isEmpty(startX + 1, startY)
                    && map.isEmpty(startX, startY + 1) && map.isEmpty(startX + 1, startY + 1)){
                map.placeElement(startX, startY, TiposDeElementos.OBSTACLE);
                map.placeElement(startX + 1, startY, TiposDeElementos.OBSTACLE);
                map.placeElement(startX, startY + 1, TiposDeElementos.OBSTACLE);
                map.placeElement(startX + 1, startY+ 1, TiposDeElementos.OBSTACLE);
                count++;
            }
        }


    }

    private void generateMonsters() {
        int numMonsters = 1 +(int) (Math.random() * 2 );
        for (int i = 0; i < numMonsters; i++){
            monsters.add(new Monster(map));
        }
    }


    private void generateChests() {
        chests.add(new Chest(map, TiposDeElementos.TREASURE_A));
        chests.add(new Chest(map, TiposDeElementos.TREASURE_B));
        if(Math.random() > 0.5) {
            chests.add(new Chest(map, TiposDeElementos.TRAP));
        }
    }

    public static void main(String[] args) {

       new Game();
    }
}