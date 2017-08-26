package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alexa on 26.08.2017.
 */
public class BotClient extends Client{

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if(!message.isEmpty() && message.contains(": ") && message.split(": ").length==2) {
                String name = message.split(": ")[0];
                String mesasgeName = message.split(": ")[1];
                SimpleDateFormat simpleDateFormat = null;
                if (mesasgeName.equals("дата")) {
                    simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                } else if (mesasgeName.equals("день")) {
                    simpleDateFormat = new SimpleDateFormat("d");
                } else if (mesasgeName.equals("месяц")) {
                    simpleDateFormat = new SimpleDateFormat("MMMM");
                } else if (mesasgeName.equals("год")) {
                    simpleDateFormat = new SimpleDateFormat("YYYY");
                } else if (mesasgeName.equals("время")) {
                    simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                } else if (mesasgeName.equals("час")) {
                    simpleDateFormat = new SimpleDateFormat("H");
                } else if (mesasgeName.equals("минуты")) {
                    simpleDateFormat = new SimpleDateFormat("m");
                } else if (mesasgeName.equals("секунды")) {
                    simpleDateFormat = new SimpleDateFormat("s");
                }
                if(!(simpleDateFormat==null))
                sendTextMessage("Информация для " + name + ": " + simpleDateFormat.format(new Date()));
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random()*100);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
