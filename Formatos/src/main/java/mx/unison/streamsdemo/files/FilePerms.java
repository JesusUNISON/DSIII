package mx.unison.streamsdemo.files;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class FilePerms {
    public static void main(String[] args) throws IOException {



        if (args.length != 1) {
            System.out.println("Faltan argumentos");
            System.exit(3);
        }


        Path path = FileSystems.getDefault().getPath(args[0]);
        //Path path = Path.resolve( args[0] );
        try {
            Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
            System.out.println("permissions = " + permissions);
        } catch (UnsupportedOperationException e) {
            System.err.println("Looks like you're not running on a posix file system");
        }
    }
}
