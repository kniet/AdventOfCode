package Day3.src;

import utils.Reader;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String path = "2024/Day3/Input.txt";
    public static String input;

    public static void main(String[] args) throws IOException {

        input = Reader.readFromFileToString(path);
        //part1
        System.out.println(checkForMul(input));

        //part2
        String replacedInput = input.replace("\n", "").replace("\r", "");
        replacedInput = replacedInput.replaceAll("don't\\(\\).*?(do\\(\\)|$)", "#");
        System.out.println(checkForMul(replacedInput));
    }

    public static int checkForMul(String replacedInput) {
        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        Matcher matcher = pattern.matcher(replacedInput);
        int result = 0;
        while (matcher.find()) {
            result += multiply(matcher.group());
        }
        return result;
    }

    public static int multiply(String value) {
        Pattern pattern = Pattern.compile("(\\d{1,3}),(\\d{1,3})");
        Matcher matcher = pattern.matcher(value);
        String[] strNum;
        while (matcher.find()) {
            strNum = matcher.group().split(",");
            return Integer.parseInt(strNum[0]) * Integer.parseInt(strNum[1]);
        }
        return 0;
    }
}