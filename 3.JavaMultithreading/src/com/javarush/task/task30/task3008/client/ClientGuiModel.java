package com.javarush.task.task30.task3008.client;

import java.util.*;

/**
 * Created by alexa on 26.08.2017.
 */
public class ClientGuiModel {
    private final ArrayList<String> allUserNames = new ArrayList<>();
    private String newMessage;

    public final List<String> getAllUserNames() {
        return Collections.unmodifiableList(allUserNames);
    }

    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public void addUser(String newUserName){
        allUserNames.add(newUserName);
    }

    public String getLastChatName(){
        String text = "";
        if(allUserNames.size()!=0){
            text = allUserNames.get(allUserNames.size()-1);
        }
        return text;
    }

    public void deleteUser(String userName){
        allUserNames.remove(userName);
    }
}
