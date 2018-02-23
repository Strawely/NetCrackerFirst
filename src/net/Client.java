package net;


import view.CompanyView;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    public static final int PORT = 20555;
    Client() {
    }

    @Override
    public void run() {


    }

    public static void main(String[] args)  {
        try {
            InetAddress address = InetAddress.getByName("127.0.0.1");
            Socket socket = new Socket(address, PORT);
            System.out.println("Connected to"+socket);
            CompanyView companyView = new CompanyView();
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            companyView.pack();
            companyView.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
