import java.util.*;

public class Main {
    public static final int RED_CUBES = 12;
    public static final int GREEN_CUBES = 13;
    public static final int BLUE_CUBES = 14;

    public static int result = 0;

    public static void main(String[] args) {
        List<String> games = Reader.readFromFile();
        String[] sets;
        int resultPart2 = 0;
        assert games != null;
        for (String game : games) {
            String[] tempSplit = game.split(":");
            sets = tempSplit[1].split(";");
            part1(sets, Integer.parseInt(tempSplit[0].substring(5)));
            resultPart2 += part2(sets, Integer.parseInt(tempSplit[0].substring(5)));
        }
        System.out.println(result);
        System.out.println(resultPart2);

    }

    private static void part1(String[] sets, int gameId) {
        for (String set : sets) {
            String[] cubes = set.split(",");

            for (String cube : cubes) {
                String[] temp = cube.split(" ");
                String numberOfCubes = temp[1];
                String colorOfCube = temp[2];
                switch (colorOfCube) {
                    case "red":
                        if (Integer.parseInt(numberOfCubes) > RED_CUBES) {
                            return;
                        }
                        break;
                    case "green":
                        if (Integer.parseInt(numberOfCubes) > GREEN_CUBES) {
                            return;
                        }
                        break;
                    case "blue":
                        if (Integer.parseInt(numberOfCubes) > BLUE_CUBES) {
                            return;
                        }
                        break;
                }
            }
        }
        result += gameId;
    }

    private static int part2(String[] sets, int gameId) {
        int result = 0;
        Map<String, Integer> maxCubesPerColor = new HashMap<>();

        for (String set : sets) {
            String[] cubes = set.split(",");

            for (String cube : cubes) {
                String[] temp = cube.split(" ");
                String numberOfCubes = temp[1];
                String colorOfCube = temp[2];
                if (!maxCubesPerColor.containsKey(colorOfCube)) {
                    maxCubesPerColor.put(colorOfCube, Integer.parseInt(numberOfCubes));
                } else {
                    if (maxCubesPerColor.get(colorOfCube) < Integer.parseInt(numberOfCubes)) {
                        maxCubesPerColor.put(colorOfCube, Integer.parseInt(numberOfCubes));
                    }
                }
            }
        }
        result = maxCubesPerColor.get("red") * maxCubesPerColor.get("blue") * maxCubesPerColor.get("green");
        return result;
    }
}