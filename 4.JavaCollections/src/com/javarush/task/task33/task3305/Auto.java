package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include= JsonTypeInfo.As.PROPERTY, property="className" , visible = true)
@JsonSubTypes({@JsonSubTypes.Type(value = Car.class , name = "car"),@JsonSubTypes.Type(value = RaceBike.class, name = "race-bike"), @JsonSubTypes.Type(value = Motorbike.class, name = "motorbike")})
public abstract class Auto {
    protected String name;
    protected String owner;
    protected int age;
}