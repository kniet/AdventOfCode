import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> inputs = Reader.readFromFile();
        List<Integer> times = convertToTimes(inputs);
        List<Integer> distances = convertToDistances(inputs);
        List<Integer> possibilitiesForWinning = part1(times, distances);
        int result1 = 1;

        for (Integer i : possibilitiesForWinning) {
            result1 *= i;
        }
        System.out.println("Part 1: " + result1);

        long time = convertToTime(inputs);
        long distance = convertToDistance(inputs);

        System.out.println("Part 2: " +  part2(time, distance));

    }

    private static List<Integer> convertToTimes(List<String> inputs) {
        String[] temp = inputs.get(0).split("Time:");
        temp = temp[1].split(" ");
        List<Integer> times = new ArrayList<>();
        for (String string : temp) {
            if (!string.isEmpty()) {
                times.add(Integer.parseInt(string));
            }
        }
        return times;
    }

    private static Long convertToTime(List<String> inputs) {
        String[] temp = inputs.get(0).split("Time:");
        String time = temp[1].trim();
        time = time.replaceAll("\\s+", "");
        return Long.parseLong(time);
    }

    private static List<Integer> convertToDistances(List<String> inputs) {
        String[] temp = inputs.get(1).split("Distance:");
        temp = temp[1].split(" ");
        List<Integer> distance = new ArrayList<>();
        for (String string : temp) {
            if (!string.isEmpty()) {
                distance.add(Integer.parseInt(string));
            }
        }
        return distance;
    }

    private static Long convertToDistance(List<String> inputs) {
        String[] temp = inputs.get(1).split("Distance:");
        String distance = temp[1].trim();
        distance = distance.replaceAll("\\s+", "");
        return Long.parseLong(distance);
    }

    private static List<Integer> part1(List<Integer> times, List<Integer> distance) {
        int remainingTime = 0;
        int totalDistanceWithThisTime = 0;
        List<Integer> possibilitiesForWinning = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            List<Integer> allOptions = new ArrayList<>();
            List<Integer> winningOptions = new ArrayList<>();
            for (int j = 1; j < times.get(i); j++) {
                remainingTime = times.get(i) - j;
                totalDistanceWithThisTime = remainingTime * j;
                allOptions.add(totalDistanceWithThisTime);
            }
            for (Integer option : allOptions) {
                if (option > distance.get(i)) {
                    winningOptions.add(option);
                }
            }
            possibilitiesForWinning.add(winningOptions.size());
        }
        return possibilitiesForWinning;
    }

    private static int part2(Long time, Long distance) {
        long remainingTime;
        long totalDistanceWithThisTime;
        List<Long> possibilitiesForWinning = new ArrayList<>();
        List<Long> allOptions = new ArrayList<>();
        List<Long> winningOptions = new ArrayList<>();

        for (long j = 1; j < time; j++) {
            remainingTime = time - j;
            totalDistanceWithThisTime = remainingTime * j;
            allOptions.add(totalDistanceWithThisTime);
        }
        for (Long option : allOptions) {
            if (option > distance) {
                winningOptions.add(option);
            }
        }
        return winningOptions.size();
    }
}