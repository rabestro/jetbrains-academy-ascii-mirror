package asciimirror.model;

import asciimirror.function.FixedWidth;
import asciimirror.function.MirroredLine;

public record MirroredPicture(Picture picture) {
    public void print() {
        picture.lines().stream()
                .map(new FixedWidth(picture.width()))
                .map(new MirroredLine())
                .forEach(System.out::println);
    }
}
