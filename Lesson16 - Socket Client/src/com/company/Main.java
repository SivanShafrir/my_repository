package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {

    public static final int PORT = 3000;

    //Socket Client
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", PORT);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hi server, how are you?".getBytes());
            byte[] buffer = new byte[1024];
            int actuallyRead = inputStream.read(buffer);
            String responseFromServer = new String(buffer, 0, actuallyRead);
            System.out.println(responseFromServer);
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}