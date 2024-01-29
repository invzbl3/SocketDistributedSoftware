package com.example.networking;

import java.io.Serializable;
import java.util.Arrays;

class Message implements Serializable {
    int number;
    String sender;
    long timestamp;
    byte[] data;

    public Message(int number, String sender, long timestamp) {
        this.number = number;
        this.sender = sender;
        this.timestamp = timestamp;
    }

    public void addData(int size) {
        this.data = new byte[size];
        Arrays.fill(this.data, (byte) 0);
    }
}