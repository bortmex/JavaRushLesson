package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by alexa on 09.09.2017.
 */
public interface EventDataRow {
    public EventType getType();
    public Date getDate();
    public int getTime();
}
