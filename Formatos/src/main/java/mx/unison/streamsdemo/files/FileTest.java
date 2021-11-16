package mx.unison.streamsdemo.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserPrincipal;

public class FileTest {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("usage: FileTest file");
            System.exit(-1);
        }

        try {
            // Converts the input string to a Path object.
            Path inputPath = Paths.get(args[0]);

            // Converts the input Path
            // to an absolute path.
            // Generally, this means prepending
            // the current working
            // directory.  If this example
            // were called like this:
            //     java FileTest foo
            // the getRoot and getParent methods
            // would return null
            // on the original "inputPath"
            // instance.  Invoking getRoot and
            // getParent on the "fullPath"
            // instance returns expected values.
            Path fullPath = inputPath.toAbsolutePath();

            System.out.printf("%s full path:%n\t%s%n", inputPath.toString(), fullPath.getParent().toString());

            // obtener ultima fecha de modificación
            FileTime lastModifiedTime = Files.getLastModifiedTime(fullPath);
            System.out.printf("Ultima modificación: %s%n", lastModifiedTime.toString());

            UserPrincipal owner = Files.getOwner(fullPath);
            System.out.printf("Propietadio = %s%n" , owner.toString());

            // Permisos Portable Operating System Interface POSIX
            PosixFileAttributes attr =
                    Files.readAttributes(fullPath, PosixFileAttributes.class);
            System.out.format("%s %s %s%n",
                    attr.owner().getName(),
                    attr.group().getName(),
                    PosixFilePermissions.toString(attr.permissions()));

        } catch (InvalidPathException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
