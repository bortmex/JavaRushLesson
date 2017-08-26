package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alexa on 15.08.2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            Message text = null;
            while (true) {
                text = connection.receive();
                if (text.getType() == MessageType.TEXT){
                String text1 = userName + ": " + text.getData();
                Message newtext = new Message(MessageType.TEXT, text1);
                sendBroadcastMessage(newtext);}
                else {
                    ConsoleHelper.writeMessage("No TEXT");
                }
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message message = null;
            do {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
            } while (!message.getType().equals(MessageType.USER_NAME)
                    || message.getData().isEmpty()
                    || connectionMap.containsKey(message.getData()));
            connectionMap.put(message.getData(),connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return message.getData();
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException, ClassNotFoundException {
            for (Map.Entry<String, Connection> entry:connectionMap.entrySet()) {
                Message message = new Message(MessageType.USER_ADDED, entry.getKey());
                if(!entry.getKey().equals(userName)){
                connection.send(message);}
            }
        }

        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение" + socket.getRemoteSocketAddress());
            String name = null;
            try (Connection connection = new Connection(socket);){
                ;
                name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,name));
                sendListOfUsers(connection,name);
                serverMainLoop(connection,name);


            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error");
            }
            if(name!=null){
                connectionMap.remove(name);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,name));
            }
            ConsoleHelper.writeMessage("Soedinenia acsept");
        }
    }

    public static void sendBroadcastMessage(Message message){
        for (Connection connection:connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Errror message!!!");
            }
        }
    }

    public static void main(String[] args){
        int port = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(port)) {
        ConsoleHelper.writeMessage("Server start");
        while (true){
            new Handler(serverSocket.accept()).start();
        }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Warning!!!");
        }
    }
}
