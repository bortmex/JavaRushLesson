package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.List;
import java.util.Map;

/**
 * Created by alexa on 12.09.2017.
 */
public class DirectorTablet {
    public void printAdvertisementProfit() {
        long totalAmount = 0;
        for (Map.Entry<String, Long> pair : StatisticManager.getInstance().advertisementProfit().entrySet()) {
            ConsoleHelper.writeMessage(pair.getKey() + " - " + (float) pair.getValue() / 100);
            totalAmount += pair.getValue();
        }
        ConsoleHelper.writeMessage("Total - " + (float) totalAmount / 100);
    }

    public void printCookWorkloading() {
        for (Map.Entry<String, Map<String, Integer>> dayWorkload : StatisticManager.getInstance().cookWorkloading().entrySet()) {
            ConsoleHelper.writeMessage(dayWorkload.getKey());
            for (Map.Entry<String, Integer> cookWorkload : dayWorkload.getValue().entrySet()) {
                ConsoleHelper.writeMessage(cookWorkload.getKey() + " - " + (int) Math.ceil((float) cookWorkload.getValue() / 60) + " min");
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        for (Advertisement ad : StatisticAdvertisementManager.getInstance().getActiveVideoSet()) {
            ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits());
        }
    }

    public void printArchivedVideoSet() {
        for (Advertisement ad : StatisticAdvertisementManager.getInstance().getArchivedVideoSet()) {
            ConsoleHelper.writeMessage(ad.getName());
        }
    }

    public void printNoAvailableVideo() {
        for (Map.Entry<String, List<Integer>> noVideo : StatisticManager.getInstance().noAvailableVideo().entrySet()) {
            ConsoleHelper.writeMessage(noVideo.getKey());
            for (int time : noVideo.getValue())
                ConsoleHelper.writeMessage("" + time);
        }
    }
}
