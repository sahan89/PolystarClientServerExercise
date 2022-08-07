package com.polystar.server;

import java.io.IOException;

public class FrankensteinServer {

    private static final int port = 8081;
    private static final String FILE_PATH = "D:\\Learning\\JAVA\\polystar\\src\\main\\resources\\frankenstein.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerExecutor.execute(port, FILE_PATH);
    }
}
