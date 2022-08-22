package asciimirror;

import asciimirror.function.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Application(
                new PicturePath(new Scanner(System.in)),
                new AdjustPicture(new AdjustLineOperator()).andThen(
                        new MirrorPicture(
                                new DuplicateLine(
                                        new ReverseLine(
                                                new ReflectCodePoint("<>[](){}/\\")))))
        ).run();
    }
}