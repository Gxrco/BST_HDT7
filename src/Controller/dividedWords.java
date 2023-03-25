package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class dividedWords {
    public ArrayList<String[]> readingFile(String fileName) {
        ArrayList<String[]> wordList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");

                if (words.length >= 3) {
                    String[] threeWords = {words[0], words[1], words[2]};
                    wordList.add(threeWords);
                }
            }
            reader.close();
            return wordList;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<String> getPhrase(String path) throws IOException{
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        reader.close();
        return lines;
    }
}