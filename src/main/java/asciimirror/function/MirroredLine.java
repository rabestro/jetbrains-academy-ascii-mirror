package asciimirror.function;

import java.util.function.UnaryOperator;

public record MirroredLine() implements UnaryOperator<String> {

    @Override
    public String apply(String line) {
        return line + " | " + line.transform(new ReversedString(new ReversedCodePoint("<>[](){}/\\")));
    }
}
