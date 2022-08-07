package com.polystar.client;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class PolystarClient {

    public static void main(String[] args)
            throws IOException, ClassNotFoundException, InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        InetAddress host = InetAddress.getLocalHost();
        List<PolystarCallable> callables = Arrays.asList(
                new PolystarCallable(host.getHostName(), 8081),
                new PolystarCallable(host.getHostName(), 8082));

        List<Future<Map<String, Integer>>> futures = pool.invokeAll(callables);

        pool.shutdown();
        pool.awaitTermination(20, TimeUnit.SECONDS);
        Map<String, Integer> allRecords = new HashMap<>();
        for (Future<Map<String, Integer>> future : futures) {
            allRecords.putAll(future.get());
        }
        Map<String, Integer> sortedMap = allRecords.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Most common words with count");

        int i = 0;
        for (Map.Entry<String, Integer> map : sortedMap.entrySet()) {
            if (i == 5) {
                break;
            }
            System.out.printf("Word = [%s], Count = [%s]%n", map.getKey(), map.getValue());
            ++i;
        }
    }
}
