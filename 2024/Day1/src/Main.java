package Day1.src;

import utils.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static final String path = "2024/Day1/Input.txt";
    public static List<String> input;
    public static List<String> listOfKeys = new ArrayList<>();
    public static List<String> listOfValues = new ArrayList<>();

    public static void main(String[] args) {

        input = Reader.readFromFile(path);
        part1();
        part2();
    }

    public static void part1() {
        for (String string : input) {
            String[] splitedString = string.split("   ");
            listOfKeys.add(splitedString[0]);
            listOfValues.add(splitedString[1]);

        }
        listOfKeys.sort(String::compareTo);
        listOfValues.sort(String::compareTo);

        Map<String, String> mappedValues = zipToMap(listOfKeys, listOfValues);

        long sum = 0L;

        for (Map.Entry<String, String> entry : mappedValues.entrySet()) {
            sum += Math.abs(Long.parseLong(entry.getKey()) - Long.parseLong(entry.getValue()));
        }

        System.out.println(sum);
    }

    public static void part2() {
        Long sum = listOfKeys.stream().mapToLong(n -> Long.parseLong(n) * listOfValues.stream().filter(n::equals).count()).sum();

        System.out.println(sum);
    }

    public static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }
}