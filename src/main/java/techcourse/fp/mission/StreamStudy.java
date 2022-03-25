package techcourse.fp.mission;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = Files.readString(Paths
            .get("src/main/resources/fp/war-and-peace.txt"));

        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        return words.stream()
                .filter(word -> word.length() > 12)
                .count();
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> 2 * number)
                .collect(toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(number -> number)
                .sum();
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 3)
                .mapToLong(number -> (number * 2))
                .sum();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = Files.readString(Paths
            .get("src/main/resources/fp/war-and-peace.txt"));

        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        words.stream()
                .filter(word -> word.length() > 12)
                .sorted(comparing(String::length).reversed())
                .distinct()
                .limit(100)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }
}
