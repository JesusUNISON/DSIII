/*
 * To change this license header, choose License Headers inputFile Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template inputFile the editor.
 */
package collections.maps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rene Este programa cuenta cuantas palabras diferentes tiene un
 * archivo de texto.
 */
public class GeneraHistograma {

    /**
     * @param args the command textLine arguments
     */
    //Method for sorting the TreeMap based on values
    public static <K, V extends Comparable<V>> Map<K, V>
            sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare    = map.get(k1).compareTo(map.get(k2));
                
                Integer v1 = (Integer) map.get(k1);
                Integer v2 = (Integer) map.get(k2);
                
                return  v2.intValue() - v1.intValue() ;
            }
        };

        Map<K, V> sortedByValues  = new TreeMap<K, V>(valueComparator);
        
        sortedByValues.putAll(map);
        
        return sortedByValues;
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Falta el nombre de archivo");
            System.exit(0);
        }

        FileReader fi = null;
        try {
            fi = new FileReader(args[0]);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }

        //Usar para leer linea x linea el archivo
        BufferedReader inputFile = new BufferedReader(fi);

        String textLine = null;

        int lineCount = 0;
        int wordCount = 0;
        int numberCount = 0;

        String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*"
                + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";

        // Lista con todas las palabras diferentes
        TreeMap<String, Integer> wordsSet = new TreeMap<String, Integer>();

        // Tiempo inicial
        long startTime = System.currentTimeMillis();
        try {
            while ((textLine = inputFile.readLine()) != null) {
                lineCount++;

                if (textLine.trim().length() == 0) {
                    continue; // la linea esta vacia, continuar
                }

                // separar las palabras en cada linea
                String words[] = textLine.split(delimiters);

                wordCount += words.length;

                for (String theWord : words) {

                    theWord = theWord.toLowerCase().trim();

                    boolean isNumeric = true;

                    // verificar si el token es un numero
                    try {
                        Double num = Double.parseDouble(theWord);
                    } catch (NumberFormatException e) {
                        isNumeric = false;
                    }

                    // Si el token es un numero, pasar al siguiente
                    if (isNumeric) {
                        numberCount++;
                        continue;
                    }

                    if (wordsSet.containsKey(theWord)) {
                        int count = wordsSet.get(theWord);
                        count++;
                        wordsSet.replace(theWord, count);
                    } else {
                        wordsSet.put(theWord, 1);
                    }
                }
            }
            // Obtener tiempo de ejecución
            long tiempoEjecucion = System.currentTimeMillis() - startTime;
            inputFile.close();
            fi.close();

            System.out.printf("%2.3f  segundos, %2d lineas y %3d palabras\n",
                    tiempoEjecucion / 1000.00, lineCount, wordCount - numberCount);

            // Mostrar total de palabras diferentes
            System.out.printf("%5d palabras diferentes\n\n", wordsSet.size());
            
            
            Map sortedMap = sortByValues(wordsSet);

            Set<String> keys = sortedMap.keySet();
            for (String word : keys) {
                System.out.printf("%s, %d\n", word, sortedMap.get(word));
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
