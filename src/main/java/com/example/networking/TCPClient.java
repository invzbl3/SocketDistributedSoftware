package com.example.networking;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This code implements the first two tasks described. You'll need to extend it further to complete
 * tasks 3 and 4. For task 3, you'll need to modify the message object to include the data blob and
 * implement the logic to compute transmission times and averages. For task 4, you'll need to implement
 * multi-threading on both the client and server side to handle multiple connections in parallel.
 */
public class TCPClient {
    public static void main(String[] argv) throws Exception {
        Socket clientSocket = new Socket("localhost", 6789);
        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

        Message messageToSend = new Message(5, "client one", System.currentTimeMillis());
        messageToSend.addData(1024); // Adding 1 KiB of dummy data

        outToServer.writeObject(messageToSend);
        Message receivedMessage = (Message) inFromServer.readObject();

        System.out.println("Received number: " + receivedMessage.number);

        clientSocket.close();
    }
}