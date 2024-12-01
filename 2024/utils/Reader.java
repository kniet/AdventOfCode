package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<String> readFromFile(String path) {
        List<String> input = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
            reader.close();
            return input;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
