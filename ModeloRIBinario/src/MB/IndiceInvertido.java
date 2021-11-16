/*
Autor: Jesus Angel Juarez Zazueta
       Hector Eduardo Arevalo Hernandez
       Andre Ahumada Avila
 */
package MB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static MB.OpBinaria.*;

public class IndiceInvertido extends SimpleFileVisitor<Path> {

    public static Hashtable<String,HashSet> indice = new Hashtable<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        FileReader fi=null;
        BufferedReader in=null;
        String name = file.toAbsolutePath().toString();
        String subname = file.getFileName().toString();

        if (name.toLowerCase().endsWith(".txt")) {

            try {
                fi = new FileReader(name);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(IndiceInvertido.class.getName()).log(Level.SEVERE, null, ex);
            }

            in = new BufferedReader(fi);
            //docNum++;

            String line = null;
            String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*|\\_\\s*|\"\\s*|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*" +
                    "|\\&\\s*|\\/\\s*|\\+\\s*|\\=\\s*|\\{\\s*|\\}\\s*|\\'\\s*|\\*\\s*|\\|\\s*|\\«\\s*|\\»\\s*|\\°\\s*|\\¬\\s*|\\~\\s*|\\`\\s*|\\ª\\s*|\\º\\s*" +
                    "|\\§\\s*";

            Pattern pat = Pattern.compile("[0-9]*");

            HashSet<String> stopWords = loadStopWords();

            try {
                while ((line = in.readLine()) != null) {

                    if (line.trim().length() == 0) {
                        continue;
                    }

                    String words[] = line.split(delimiters);

                    for (String word : words) {
                        word = word.toLowerCase();
                        Matcher mat = pat.matcher(word);
                        if ( !mat.matches() && !stopWords.contains(word)) {
                            if (!indice.containsKey(word)) {
                                HashSet<String> docs = new HashSet<>();
                                docs.add(subname);
                                indice.put(word, docs);
                            } else {
                                indice.get(word).add(subname);
                            }
                        }
                    }
                }

                in.close();
                fi.close();
            } catch (IOException ex) {
                Logger.getLogger(IndiceInvertido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return super.visitFile(file, attrs);
    }

    public static HashSet<String> loadStopWords() {
        FileReader fi = null;
        try {
            fi = new FileReader("stopwords-es.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IndiceInvertido.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedReader in = new BufferedReader(fi);

        HashSet<String> table  = new HashSet<>();

        String line = null;

        try {
            while ((line = in.readLine()) != null) {
                table.add( line );
            }
            in.close();
            fi.close();
        } catch (IOException ex) {
            Logger.getLogger(IndiceInvertido.class.getName()).log(Level.SEVERE, null, ex);
        }

        return table;
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
        //System.out.printf("%-70s %6s %6s %6s%n","Archivo","Lineas","Caracteres","Palabras");
        // iniciar en este directorio
        Path startingDir = Paths.get(args[0]);

        // clase para procesar los archivos
        IndiceInvertido indiceInvertido = new IndiceInvertido();

        // iniciar el recorrido de los archivos
        Files.walkFileTree(startingDir, indiceInvertido);

        if (args.length == 1) {
            Enumeration<String> claves = indice.keys();
            int id = 0;
            while (claves.hasMoreElements()) {
                String clave = claves.nextElement();
                System.out.printf("%-5d %-15s %5s\n", id++, clave, indice.get(clave));
            }
        }

        Scanner in = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("Ingrese la palabra clave a buscar:");
            System.out.println("(para dos palabras ingrese AND, OR o NOT)");
            System.out.println("(ingrese c para salir)");

            String consulta = in.nextLine();
            Collection docs = null;
            String[] claves = consulta.split(" ");
            if (claves[0].equals("c")) {
                salir = true;
                continue;
            }
            if (claves.length == 1) {
                if (indice.containsKey(claves[0])) {
                    System.out.println("Documentos con " + claves[0]);
                    System.out.println(indice.get(claves[0]));
                } else {
                    System.out.println("No se encuentran resultados");
                }
            }
            if (claves.length == 3) {
                HashSet<String> a = indice.get(claves[0]);
                HashSet<String> b = indice.get(claves[2]);
                if (!(a ==null) || !(b ==null)) {
                    switch (claves[1]) {
                        case "AND":
                            docs = AND(a,b);
                            break;
                        case "OR":
                            docs = OR(a,b);
                            break;
                        case "NOT":
                            docs = NOT(a,b);
                            break;
                        default:
                            System.out.println("Operacion no valida");
                    }
                    if (!(docs == null)) {
                        System.out.println("Documentos con: " + claves[0] + " " + claves[1] + " " + claves[2]);
                        System.out.println(docs);
                    }
                } else {
                    System.out.println("No se encuentran resultados");
                }

            }
            System.out.println("\n");
        }

    }
}
