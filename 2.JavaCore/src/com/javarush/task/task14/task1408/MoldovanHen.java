package com.javarush.task.task14.task1408;

/**
 * Created by alexa on 26.03.2017.
 */
public class MoldovanHen extends Hen {
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

    @Override
    int getCountOfEggsPerMonth() {
        return 3;
    }
}