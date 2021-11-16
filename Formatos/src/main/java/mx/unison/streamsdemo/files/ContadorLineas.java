package main.java.mx.unison.streamsdemo.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.StringTokenizer;

public class ContadorLineas extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        FileReader fl=null;
        BufferedReader in=null;
        String name = file.toAbsolutePath().toString();

        if (name.toLowerCase().endsWith(".txt")) {
            fl = new FileReader(name);
            in = new BufferedReader(fl);
            StringTokenizer st=null;

            int contLines = 0;
            int contCaracters = 0;
            int contPalabras = 0;
            String linea=null;

            while ((linea=in.readLine()) != null) {
                contLines++;
                contCaracters=contCaracters + linea.length();

                st=new StringTokenizer(linea, "+-@#$%^&*~`=|°,.:;!¡¿?-_ '/()[]{}\"");
                if (st.hasMoreTokens()) {
                    contPalabras= contPalabras + st.countTokens();
                }

                /*
                while (st.hasMoreTokens()) {
                    st.nextToken();
                    contPalabras++;
                }
                 */

            }
            in.close();

            System.out.printf("%-70s %6d %6d %6d%n",name,contLines,contCaracters,contPalabras);
        }

        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.printf("No se puede procesar:%30s",file.toString());
        return super.visitFileFailed(file, exc);
    }

    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            System.exit(2);
        }
        System.out.printf("%-70s %6s %6s %6s%n","Archivo","Lineas","Caracteres","Palabras");
        // iniciar en este directorio
        Path startingDir = Paths.get(args[0]);

        // clase para procesar los archivos
        ContadorLineas contadorLineas = new ContadorLineas();

        // iniciar el recorrido de los archivos
        Files.walkFileTree(startingDir, contadorLineas);

    }
}
