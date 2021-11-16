import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    public static void main(String[] args) {
        // TODO code application logic here

        if (args.length == 0) {
            System.out.println("Falta el nombre de archivo");
            System.exit(0);
        }

        FileReader fi = null;
        try {
            fi = new FileReader(args[0]);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedReader in = new BufferedReader(fi);

        String line = null;

        int lineCount = 0;
        int wordCount = 0;

        long startTime = System.currentTimeMillis();

        String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*|\\_\\s*|\"\\s*|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*";

        Pattern pat = Pattern.compile("[0-9]*");

        HashSet<String> stopWords = loadStopWords();

        try {
            while ((line = in.readLine()) != null) {
                lineCount++;

                if (line.trim().length() == 0) {
                    continue;
                }

                String words[] = line.split(delimiters);

                //System.out.println(line);
                for (String word : words) {
                    word = word.toLowerCase();
                    Matcher mat = pat.matcher(word);
                   if ( !mat.matches() && !stopWords.contains(word)) {
                        System.out.print(word);
                        System.out.print(" ");
                   }
                }
                System.out.println();
                wordCount += words.length;
            }

            in.close();
            fi.close();
            long total = System.currentTimeMillis() - startTime;
            System.out.printf("%2.3f  segundos, %,2d lineas y %,3d palabras\n", total / 1000.00, lineCount, wordCount);
        } catch (IOException ex) {
            Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static  HashSet<String> loadStopWords() {
        FileReader fi = null;
        try {
            fi = new FileReader("stopwords-es.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(WordCounter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return table;

    }
}
