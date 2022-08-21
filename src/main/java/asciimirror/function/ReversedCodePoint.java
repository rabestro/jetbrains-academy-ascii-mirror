package asciimirror.function;

import java.util.function.IntUnaryOperator;

public record ReversedCodePoint(String pairChars) implements IntUnaryOperator {

    @Override
    public int applyAsInt(int codePoint) {
        var index = pairChars().indexOf(codePoint);
        if (index < 0) {
            return codePoint;
        }
        var shift = index % 2 == 0 ? 1 : -1;
        return pairChars().charAt(index + shift);
    }
}
