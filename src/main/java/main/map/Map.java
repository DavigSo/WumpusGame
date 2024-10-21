package main.map;

import org.main.TiposDeElementos;

import java.awt.*;
import java.util.Random;

public class Map {

    private static final int MAP_SIZE = 8;
    private TiposDeElementos[][] grid;
    private Random random;

    public Map() {
        grid = new TiposDeElementos[MAP_SIZE][MAP_SIZE];
        random = new Random();
        initializeMap();
    }

    private void initializeMap() {
        for(int i = 0; i < MAP_SIZE; i++){
            for(int j = 0; j < MAP_SIZE; j++){
                grid[i][j] = TiposDeElementos.EMPTY;
            }
        }
    }

    public int getSize(){
        return MAP_SIZE;
    }

    public boolean isEmpty(int x, int y){
        return grid[x][y] == TiposDeElementos.EMPTY;
    }

    public boolean placeElement(int x, int y, TiposDeElementos type) {
        if(isEmpty(x, y)) {

         grid[x][y] = type;
          return true;
        }
        return false;
    }

    public TiposDeElementos getElement(int x, int y) {
        return grid[x][y];
    }

    public void displayMap(){
        System.out.print(" ");
        for(int j = 0; j < MAP_SIZE; j++){
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print(i + " ");
            for(int j = 0; j < MAP_SIZE; j++) {
                System.out.print(grid[i][j].name().charAt(0) + " ");
            }
            System.out.println();
        }
    }

}
