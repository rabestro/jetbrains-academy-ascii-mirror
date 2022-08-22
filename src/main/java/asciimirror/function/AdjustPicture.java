package asciimirror.function;

import asciimirror.model.Picture;

import java.util.function.UnaryOperator;

public record AdjustPicture(AdjustLineOperator operator) implements UnaryOperator<Picture> {
    @Override
    public Picture apply(Picture picture) {
        return picture.transform(operator().apply(picture.width()));
    }
}
