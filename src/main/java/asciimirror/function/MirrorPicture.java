package asciimirror.function;

import asciimirror.model.Picture;

import java.util.function.UnaryOperator;

public record MirrorPicture(UnaryOperator<String> transformation) implements UnaryOperator<Picture> {
    @Override
    public Picture apply(Picture picture) {
        return picture.transform(mirrorLine());
    }

    private UnaryOperator<String> mirrorLine() {
        return line -> line + " | " + line.transform(transformation());
    }
}
