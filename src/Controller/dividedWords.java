package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {
    public static void main(String[] args) {
        String fileName = "words.txt";
        ArrayList<String[]> wordList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");

                if (words.length >= 3) {
                    String[] threeWords = { words[0], words[1], words[2] };
                    wordList.add(threeWords);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }