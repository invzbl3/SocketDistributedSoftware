package com.example.networking;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This code implements the first two tasks described. You'll need to extend it further to complete
 * tasks 3 and 4. For task 3, you'll need to modify the message object to include the data blob and
 * implement the logic to compute transmission times and averages. For task 4, you'll need to implement
 * multi-threading on both the client and server side to handle multiple connections in parallel.
 */
class TCPServer {
    public static void main(String[] argv) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
            ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());

            Message clientMessage = (Message) inFromClient.readObject();
            clientMessage.number++;
            outToClient.writeObject(clientMessage);

            connectionSocket.close();
        }
    }
}