package asciimirror.function;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public record ReversedString(IntUnaryOperator codePointMapper) implements UnaryOperator<String> {

    @Override
    public String apply(String line) {
        return new StringBuilder(line)
                .reverse()
                .chars()
                .map(codePointMapper)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
    }
}
