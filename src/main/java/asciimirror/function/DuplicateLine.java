package asciimirror.function;

import java.util.function.UnaryOperator;

public record DuplicateLine(UnaryOperator<String> transformation) implements UnaryOperator<String> {
    @Override
    public String apply(String line) {
        return line + " | " + line.transform(transformation());
    }
}
