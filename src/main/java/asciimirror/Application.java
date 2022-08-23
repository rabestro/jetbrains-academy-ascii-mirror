package asciimirror;

import asciimirror.model.Picture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.function.Supplier;

public record Application(Supplier<Path> pathSupplier, Function<Picture, Picture> operator) implements Runnable {

    @Override
    public void run() {
        try {
            printPicture();
        } catch (IOException e) {
            printErrorMessage();
        }
    }

    private void printPicture() throws IOException {
        System.out.println(getPicture().content());
    }

    private Picture getPicture() throws IOException {
        var content = Files.readString(pathSupplier().get());
        return operator().apply(new Picture(content));
    }

    private void printErrorMessage() {
        System.out.println("File not found!");
    }
}
