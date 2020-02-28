package com.supplier.TCPServer;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ali Huseynov
 */
public class TCPConnection {

    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private Socket connection;
    private ServerSocket server;
    private int port = 6789;

    public void startConnection() {
        try {
            server = new ServerSocket(port, 100);
            while (true) {
                try {
                    connection = server.accept();
                    output = new ObjectOutputStream(connection.getOutputStream());
                    output.flush();
                    input = new ObjectInputStream(connection.getInputStream());

                    whileMessaging();
                } catch (EOFException eofException) {
                    System.out.println("Connection down");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void whileMessaging() throws IOException {
        String message = "";
        do {
            try {
                message = (String) input.readObject();
                System.out.println(message);
            } catch (ClassNotFoundException classNotFoundException) {
                
            }
        } while (!message.equals("STOP"));
    }

    public static void sendMessage(String message) {
        try {
            output.writeObject(message);
            output.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
