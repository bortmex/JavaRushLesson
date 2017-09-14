package com.javarush.task.task35.task3513;

/**
 * Created by alexa on 11.09.2017.
 */
public class MoveEfficiency implements Move, Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    public void move() {

    }

    @Override
    public int compareTo(MoveEfficiency  o) {
        if(this.numberOfEmptyTiles!=o.numberOfEmptyTiles) return Integer.compare(this.numberOfEmptyTiles, o.numberOfEmptyTiles);
        else return Integer.compare(score, o.score);
    }
}
