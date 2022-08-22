package asciimirror.function;

import java.util.OptionalInt;
import java.util.function.IntUnaryOperator;

public record MirrorCodePoint(String pairChars) implements IntUnaryOperator {

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

    private static boolean isEven(int index) {
        return (index & 1) == 0;
    }

}
