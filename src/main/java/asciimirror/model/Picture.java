package asciimirror.model;

import java.util.function.UnaryOperator;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public record Picture(String content) {

    public int width() {
        return content().lines().mapToInt(String::length).max().orElse(0);
    }

    public Picture transform(UnaryOperator<String> lineTransformation) {
        return new Picture(content()
                .lines()
                .map(lineTransformation)
                .collect(joining(lineSeparator())));
    }
}
