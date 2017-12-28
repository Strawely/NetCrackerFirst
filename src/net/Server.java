package net;


import java.net.ServerSocket;
import java.util.Scanner;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Server {
    public static final int PORT=20555;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(PORT);
        try {
            System.out.println("Server is up.");
            while(true) {
                Socket socket = serverSocket.accept();
                Thread client = new Thread(new Client());
                System.out.println("Connection accepted: " + socket);
                client.start();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            serverSocket.close();
        }
    }

}
