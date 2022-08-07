package com.polystar.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.Callable;

public class PolystarCallable implements Callable<Map<String, Integer>> {

    private final String host;
    private final int port;

    public PolystarCallable(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Map<String, Integer> call() throws Exception {
        Socket socket = new Socket(host, port);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject("Request word count");
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Map<String, Integer> message = (Map<String, Integer>) ois.readObject();
        ois.close();
        oos.close();
        return message;
    }
}
