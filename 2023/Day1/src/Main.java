import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static List<String> calibrations;
    public static void main(String[] args) {
        calibrations = Reader.readFromFile();
        int sumOfResults = 0;

        for (String calibration : calibrations) {
            int digits = part1(calibration);
            int a = firstDigit(digits);
            int b = lastDigit(digits);
            String result = a + Integer.toString(b);
            sumOfResults += Integer.parseInt(result);
        }

        System.out.println("Part 1 result: " + sumOfResults);

        sumOfResults = 0;
        for (String calibration : calibrations) {
            String digits = part2(calibration);
            int a = firstDigit(Integer.parseInt(digits));
            int b = lastDigit(Integer.parseInt(digits));
            String result = a + Integer.toString(b);
            sumOfResults += Integer.parseInt(result);
        }

        System.out.println("Part 2 result: " + sumOfResults);

    }

    public static int firstDigit(int n) {
        while (n >= 10) {
            n /= 10;
        }
        return n;
    }

    public static int lastDigit(int n) {
        return (n % 10);
    }

    public static int part1(String calibration) {
        String numbersOnly = calibration.replaceAll("[^0-9]", "");
        return Integer.parseInt(numbersOnly);
    }

    public static String part2(String calibration) {
        String nums[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String num = "";
        for (int i = 0; i < calibration.length(); i++) {
            if (Character.isDigit(calibration.charAt(i))) {
                num += calibration.charAt(i);
                continue;
            }
            for (int j = 0; j < nums.length; j++) {
                if (calibration.substring(i).startsWith(nums[j])) {
                    num += j + 1;
                    i += nums[j].length() - 2;
                    break;
                }
            }
        }
        return num;
    }

}