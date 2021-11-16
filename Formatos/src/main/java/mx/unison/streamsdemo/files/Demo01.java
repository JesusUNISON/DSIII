package main.java.mx.unison.streamsdemo.files;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo01 {

    public static void main(String []args) {

        if( args.length != 1 ) {
            System.out.println("Falta el nombre de archivo/folder como argumento\n");
            System.exit(1);
        }

        try {
            Path path = Paths.get(args[0]);

            System.out.format("toString: %s%n", path.toString());
            System.out.format("getFileName: %s%n", path.getFileName());
            System.out.format("getName(0): %s%n", path.getName(0));
            System.out.format("getNameCount: %d%n", path.getNameCount());
            System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
            System.out.format("getParent: %s%n", path.getParent());
            System.out.format("getRoot: %s%n", path.getRoot());

        } catch (InvalidPathException exception) {
            System.out.println(exception.getMessage());
        }


    }
}
