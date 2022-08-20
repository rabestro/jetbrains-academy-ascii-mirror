package asciimirror;

import asciimirror.function.UserDefinedPath;
import asciimirror.model.MirroredPicture;
import asciimirror.model.Picture;

import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        var path = new UserDefinedPath(System.in).get();

        try (var lines = Files.lines(path)) {
            new MirroredPicture(new Picture(lines))
                    .print();

        } catch (Throwable e) {
            System.out.println("File not found!");
        }

    }
}