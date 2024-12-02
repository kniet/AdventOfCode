package Day2.src;

import utils.Reader;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final String path = "2024/Day2/Input.txt";
    public static List<String> input;

    public static void main(String[] args) {

        input = Reader.readFromFile(path);
        int resultPart1 = 0;
        for (String string : input) {
            List<Integer> result = Arrays.stream(string.split(" "))
                    .mapToInt(Integer::parseInt).boxed().toList();

            if (part1(result)) {
                resultPart1++;
            }
        }

        System.out.println(resultPart1);
    }

    public static boolean part1(List<Integer> result) {
        boolean increasing = result.get(0) < result.get(1);
        for (int i = 1; i < result.size(); i++) {
            int diff = Math.abs(result.get(i-1) - result.get(i));

            if (diff <= 0 || diff > 3 ||
                    (increasing && result.get(i-1) > result.get(i)) ||
                    (!increasing && result.get(i-1) < result.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void part2() {

    }

}