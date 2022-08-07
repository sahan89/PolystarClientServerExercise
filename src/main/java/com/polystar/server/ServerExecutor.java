package com.polystar.server;

import com.polystar.common.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class ServerExecutor {

    public static void execute(int port, String filePath) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for the client request : " + port);
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Map<String, Integer> wordMap = FileReader.readFile(filePath);
            oos.writeObject(wordMap);
            ois.close();
            oos.close();
            socket.close();
        }
    }
}
