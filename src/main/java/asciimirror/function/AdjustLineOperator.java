package asciimirror.function;

import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

public record AdjustLineOperator() implements IntFunction<UnaryOperator<String>> {
    @Override
    public UnaryOperator<String> apply(int width) {
        return line -> (line + " ".repeat(width)).substring(0, width);
    }
}
