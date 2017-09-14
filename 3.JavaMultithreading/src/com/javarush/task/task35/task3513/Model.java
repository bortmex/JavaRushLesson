package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * Created by alexa on 09.09.2017.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score, maxTile;
    boolean isSaveNeeded = true;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();

    public Model() {
        resetGameTiles();
    }

    public void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        this.score = 0;
        this.maxTile = 2;
        addTile();
        addTile();
    }

    private void saveState(Tile[][] tile) {
        Tile[][] newTile = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {
                newTile[i][j] = new Tile(tile[i][j].value);
            }
        }
        previousStates.push(newTile);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public boolean hasBoardChanged(){
        int sum1 = 0;
        int sum2 = 0;
        Tile[][] tipref = previousStates.peek();
        if(!previousStates.isEmpty()){
            for (int i = 0; i < FIELD_WIDTH; i++) {
                for (int j = 0; j < FIELD_WIDTH; j++) {
                    sum1+=gameTiles[i][j].value;
                    sum2+=tipref[i][j].value;
                }
            }
        }

        return sum1!=sum2;
    }

    public void autoMove(){

        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());

        class MoveUp implements Move{
            @Override
            public void move() {
                up();
            }
        }
        priorityQueue.offer(getMoveEfficiency(new MoveUp()));
        class MoveDown implements Move{
            @Override
            public void move() {
                down();
            }
        }
        priorityQueue.offer(getMoveEfficiency(new MoveDown()));
        class MoveLeft implements Move{
            @Override
            public void move() {
                left();
            }
        }
        priorityQueue.offer(getMoveEfficiency(new MoveLeft()));
        class MoveRight implements Move{
            @Override
            public void move() {
                right();
            }
        }
        priorityQueue.offer(getMoveEfficiency(new MoveRight()));

        Move m = priorityQueue.peek().getMove();
        m.move();
    }

    public MoveEfficiency getMoveEfficiency(Move move){

        MoveEfficiency mf;
        move.move();
        if(!hasBoardChanged()) mf = new MoveEfficiency(-1,0,move);
        else mf = new MoveEfficiency(getEmptyTiles().size(),score,move);
        rollback();

        return mf;
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;

        switch (n) {
            case 0:
                left();
                break;
            case 1:
                up();
                break;
            case 2:
                right();
                break;
            case 3:
                down();
                break;
        }
    }

    public void rollback() {
        if (!previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
        }
        if (!previousScores.isEmpty()) {
            score = previousScores.pop();
        }

    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == gameTiles[j - 1][i].value) return true;
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == 0) return true;
            }
        }
        return false;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                if (gameTiles[i][j].isEmpty()) list.add(gameTiles[i][j]);
            }
        }
        return list;
    }

    public void addTile() {
        int size = getEmptyTiles().size();
        Tile tile = getEmptyTiles().get((int) (Math.random() * size));
        tile.value = (Math.random() < 0.9 ? 2 : 4);
    }

    private static boolean compressTiles(Tile[] tiles) {
        boolean compressTrue = false;
        while (!finishCompress(tiles)) {
            for (int i = 0; i < tiles.length; i++) {
                if (tiles[i].value == 0) {
                    compressLocal(i + 1, tiles);
                    compressTrue = true;
                }
            }
        }
        return compressTrue;
    }

    private static void compressLocal(int j, Tile[] tiles) {  //j указывает какой блок мы передвигаем влево
        for (int i = 0; i < tiles.length - j; i++) {
            tiles[j - 1 + i] = tiles[j + i];
        }
        tiles[tiles.length - 1] = new Tile(0);
    }

    private static boolean finishCompress(Tile[] tiles) {  // {2,2,0,2} = false   {2,2,2,0} = true
        int i = 0;
        for (i = tiles.length - 1; i >= 0; i--) {
            if (tiles[i].value != 0) break;
        }
        for (int j = i - 1; j >= 0; j--) {
            if (tiles[j].value == 0) return false;
        }

        return true;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean compressTrue = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty() && !tiles[i + 1].isEmpty()) {
                tiles[i].value *= 2;
                compressTrue = true;
                tiles[i + 1] = new Tile();
                maxTile = maxTile > tiles[i].value ? maxTile : tiles[i].value;
                score += tiles[i].value;
                compressTiles(tiles);
            }
        }
        return compressTrue;
    }

    public void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) addTile();
        isSaveNeeded = true;
    }

    public void right() {
        saveState(gameTiles);
        turn90();
        turn90();
        left();
        turn90();
        turn90();
    }

    public void up() {
        saveState(gameTiles);
        turn90();
        turn90();
        turn90();
        left();
        turn90();
    }

    public void down() {
        saveState(gameTiles);
        turn90();
        left();
        turn90();
        turn90();
        turn90();
    }

    /*public static void main(String[] args) {
        Tile[][] arr =  {{new Tile(4),new Tile(7),new Tile(9),new Tile(6)},
                        {new Tile(41),new Tile(71),new Tile(91),new Tile(61)},
                        {new Tile(411),new Tile(711),new Tile(911),new Tile(611)},
                        {new Tile(4111),new Tile(7111),new Tile(9111),new Tile(6111)}};
        arrPrint(arr);
        System.out.println();
        arr = turn90(arr);
        arrPrint(arr);
        System.out.println();
        arr = turn90(arr);
        arrPrint(arr);
        System.out.println();
        arr = turn90(arr);
        arrPrint(arr);
    }*/

    public static void arrPrint(Tile[][] gameTile) {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                System.out.print(gameTile[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void turn90() {
        Tile[][] tiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tiles[j][FIELD_WIDTH - 1 - i] = gameTiles[i][j];
            }
        }
        gameTiles = tiles;
    }

}
