package com.polystar.server;

import java.io.IOException;

public class DraculaServer {

    private static final int PORT = 8082;
    private static final String FILE_PATH = "D:\\Learning\\JAVA\\polystar\\src\\main\\resources\\dracula.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerExecutor.execute(PORT, FILE_PATH);
    }

}
