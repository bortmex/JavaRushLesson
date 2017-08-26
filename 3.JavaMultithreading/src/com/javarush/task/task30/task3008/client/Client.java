package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by alexa on 25.08.2017.
 */
public class Client {
    private volatile boolean clientConnected = false;
    protected Connection connection;

    public class SocketThread extends Thread {

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true){
                Message text = Client.this.connection.receive();

                if(text.getType()==MessageType.NAME_REQUEST){
                    Client.this.connection.send(new Message(MessageType.USER_NAME,getUserName()));
                } else if(text.getType()==MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected  void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true){
                Message text = Client.this.connection.receive();
                if(text.getType() == MessageType.TEXT){
                    processIncomingMessage(text.getData());
                } else if(text.getType() == MessageType.USER_ADDED){
                    informAboutAddingNewUser(text.getData());
                } else if(text.getType() == MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(text.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("Учасник с именем " + userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("Учасник с именем "+userName+" покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected=clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        @Override
        public void run() {
            String addres = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(addres, port);
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    public void run() {
        SocketThread st = getSocketThread();
        st.setDaemon(true);
        st.start();

        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Error");
            return;
        }

        if (clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");
        else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        String message;
        while (clientConnected) {
            if (!(message = ConsoleHelper.readString()).equalsIgnoreCase("exit")) {
                if (shouldSendTextFromConsole()) sendTextMessage(message);
            } else
                break;
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Can you pliz input address server");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Can you pliz input port");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Can you pliz input name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            clientConnected = false;
        }
    }

}
