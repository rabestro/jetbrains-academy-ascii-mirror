package asciimirror.function;

import java.util.OptionalInt;
import java.util.function.IntUnaryOperator;

public record ReflectCodePoint(String pairChars) implements IntUnaryOperator {

    private static boolean isEven(int index) {
        return (index & 1) == 0;
    }

    @Override
    public int applyAsInt(int codePoint) {
        return getOppositeCodePoint(codePoint).orElse(codePoint);
    }

    private OptionalInt getOppositeCodePoint(int codePoint) {
        var index = pairChars().indexOf(codePoint);
        if (index < 0) {
            return OptionalInt.empty();
        }
        var shift = isEven(index) ? 1 : -1;
        return OptionalInt.of(pairChars().charAt(index + shift));
    }

}
