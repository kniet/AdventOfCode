import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        List<String> cards = Reader.readFromFile();
        int result1 = 0;
        int result2 = 0;

        for (int i = 0; i < cards.size(); i++) {
            map.put(i,1);
        }

        for (int i = 0; i < cards.size(); i++) {
            String[] nums = cards.get(i).split(":");
            List<Integer> myNumbers = stringArrToIntArray(nums[1].split("\\|")[0]);
            List<Integer> winningNumbers = stringArrToIntArray(nums[1].split("\\|")[1]);
            result1 += part1(myNumbers, winningNumbers, i);
        }

        for (int value : map.values()) {
            result2 += value;
        }

        System.out.println("Part 1: " + result1);
        System.out.println("Part 2: " + result2);
    }

    private static List<Integer> stringArrToIntArray(String string) {
        StringBuilder stringBuffer = new StringBuilder();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int j = 0; j < string.length(); j++) {
            if (Character.isDigit(string.charAt(j))) {
                stringBuffer.append(string.charAt(j));
                if (j == string.length() - 1) {
                    numbers.add(Integer.parseInt(stringBuffer.toString()));
                    stringBuffer = new StringBuilder();
                }
            } else {
                if (!stringBuffer.isEmpty()) {
                    numbers.add(Integer.parseInt(stringBuffer.toString()));
                    stringBuffer = new StringBuilder();
                }
            }
        }
        return numbers;
    }

    private static int part1(List<Integer> myNumbers, List<Integer> winningNumbers, int i) {
        int matches = 0;
        int result1 = 0;
        for (Integer winningNumber : winningNumbers) {
            if (myNumbers.contains(winningNumber)) {
                matches++;
                if (matches == 1) {
                    result1 += 1;
                } else {
                    result1 *= 2;
                }
            }
        }
        for (int j = i + 1; j < i + matches + 1; j++) {
            map.put(j, map.getOrDefault(i, 0) + map.getOrDefault(j,0));
        }
        return result1;
    }
}