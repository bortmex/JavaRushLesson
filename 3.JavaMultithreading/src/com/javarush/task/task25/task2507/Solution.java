package com.javarush.task.task25.task2507;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* 
Работать в поте лица!
*/
public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        try {
            socket.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            super.interrupt();
        }
    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        in.read(new byte[BUFFER_SIZE],0,count);
                    }
                }
            }
        } catch (IOException ignored) {}
    }

    @Override
    protected void finalize() throws Throwable {
        super.interrupt();
        super.finalize();
    }

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("\"127.0.0.1\"",6666);
        Thread thread = new Solution(s);
        thread.start();
    }
}
