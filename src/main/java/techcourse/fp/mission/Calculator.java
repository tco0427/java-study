package techcourse.fp.mission;

import java.util.List;

public class Calculator {

    public static int sumAll(List<Integer> numbers, Conditional conditional) {
        return numbers
                .stream()
                .mapToInt(number -> number)
                .filter(conditional::test)
                .sum();
    }
}
