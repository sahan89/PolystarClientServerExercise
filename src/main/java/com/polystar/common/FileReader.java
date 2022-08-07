package com.polystar.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FileReader {

    public static Map<String, Integer> readFile(String filePath) throws IOException {
        File f1 = new File(filePath);
        String[] words;
        java.io.FileReader fr = new java.io.FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        String s;
        Map<String, Integer> wordMap = new HashMap<>();
        while ((s = br.readLine()) != null) {
            String result = s.replaceAll("[()?'\"{}+^\\-:;,.*_!/]", "");
            String toLowerCase = result.toLowerCase(Locale.forLanguageTag(s));
            words = toLowerCase.split(" ");
            for (String word : words) {
                if (wordMap.containsKey(word)) {
                    int count = wordMap.get(word);
                    wordMap.put(word, count + 1);
                } else {
                    wordMap.put(word, 1);
                }
            }
        }
        wordMap.remove("");
        return wordMap;
    }

}
