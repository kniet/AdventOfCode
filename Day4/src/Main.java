import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> cards = Reader.readFromFile();
        int result = 0;
        for (String s : cards) {
            String[] nums = s.split(":");
            List<Integer> myNumbers = stringArrToIntArray(nums[1].split("\\|")[0]);
            List<Integer> winningNumbers = stringArrToIntArray(nums[1].split("\\|")[1]);
            result += part1(myNumbers, winningNumbers);
        }

        System.out.println(result);
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

    private static int part1(List<Integer> myNumbers, List<Integer> winningNumbers) {
        int matches = 0;
        int result = 0;
        for (int i = 0; i < myNumbers.size(); i++) {
            if (winningNumbers.contains(myNumbers.get(i))) {
                matches++;
                if (matches == 1) {
                    result += 1;
                } else {
                    result *= 2;
                }
            }

        }
        return result;
    }
}