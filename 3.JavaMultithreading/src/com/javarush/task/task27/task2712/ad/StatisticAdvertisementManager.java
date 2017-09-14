package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by alexa on 12.09.2017.
 */
public class StatisticAdvertisementManager {

    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    public List<Advertisement> getActiveVideoSet() {
        List<Advertisement> activeVideos = new ArrayList<>();

        for (Object o : advertisementStorage.list())
            if (((Advertisement) o).getHits() > 0) activeVideos.add((Advertisement) o);

        Collections.sort(activeVideos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });

        return activeVideos;
    }

    public List<Advertisement> getArchivedVideoSet() {
        List<Advertisement> archivedVideos = new ArrayList<>();

        for (Object o : advertisementStorage.list())
            if (((Advertisement) o).getHits() == 0) archivedVideos.add((Advertisement) o);

        Collections.sort(archivedVideos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });

        return archivedVideos;
    }
}
