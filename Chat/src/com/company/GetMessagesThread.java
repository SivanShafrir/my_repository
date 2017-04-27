package com.company;

/**
 * Created by hackeru on 3/28/2017.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 * Created by eladlavi on 28/03/2017.
 */
public class GetMessagesThread extends Thread {

    public static final int PORT = 3000;
    public static final String SERVER_IP = "10.0.11.4";

    public static final int SEND_MESSAGE = 100;
    public static final int GET_MESSAGES = 101;
    public static final int OKAY = 90;
    private boolean go = true;
    private int lastMessageReceived;

    public GetMessagesThread() {
        lastMessageReceived = -1;
    }

    @Override
    public void run() {
        while(go){
            Socket clientSocket = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try{
                clientSocket = new Socket(SERVER_IP, PORT);
                inputStream = clientSocket.getInputStream();
                outputStream = clientSocket.getOutputStream();
                outputStream.write(GET_MESSAGES);
                byte[] lastMessageReceivedBytes = new byte[4];
                ByteBuffer.wrap(lastMessageReceivedBytes).putInt(lastMessageReceived+1);
                outputStream.write(lastMessageReceivedBytes);
                int messageLength;
                while((messageLength = inputStream.read()) != -1){
                    byte[] messageBytes = new byte[messageLength];
                    inputStream.read(messageBytes);
                    String message = new String(messageBytes);
                    System.out.println(message);
                    lastMessageReceived++;
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(inputStream != null)
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if(outputStream != null)
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if(clientSocket != null)
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
    }

    public void stopGettingMessages(){
        go = false;
        this.interrupt();
    }
}
