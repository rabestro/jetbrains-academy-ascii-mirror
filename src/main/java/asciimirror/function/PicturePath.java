package asciimirror.function;

import java.nio.file.Path;
import java.util.Scanner;
import java.util.function.Supplier;

public record PicturePath(Scanner scanner) implements Supplier<Path> {
    @Override
    public Path get() {
        System.out.println("Input the file path:");
        return Path.of(scanner.nextLine());
    }
}
