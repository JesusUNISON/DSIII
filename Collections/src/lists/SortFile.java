/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rnavarro
 */
public class SortFile {

    public static void main(String args[]) {
//        if (args.length < 1) {
//            System.out.println("Usage: SortFile text_file");
//            return;
//        }

        File fileDescriptor = new File("divina_comedia.txt");

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileDescriptor));

            String buffer = null;

            ArrayList<String> list = new ArrayList();

            long start = System.currentTimeMillis();
            // leer el archivo y cargar en una lista
            while ((buffer = in.readLine()) != null) {
                // no agregar lineas en blaco
                if (buffer.length() > 0) {
                    // eliminar espacios en blaco al inicio y fin
                    list.add( buffer.trim() );
                }
            }
            in.close();
            System.out.printf("Se agregaron %d lineas en %d milisegundos\n",
                    list.size(),
                    System.currentTimeMillis() - start);

            start = System.currentTimeMillis();

            // ordernar las lineas en la lista
            Collections.sort( list );
            
            System.out.printf("Ordenar: %d milisegundos\n",
                    System.currentTimeMillis() - start);

            start = System.currentTimeMillis();

            String path = System.getProperty("user.dir");

            fileDescriptor = new File(path, "sorted_file.txt");

            PrintWriter out = new PrintWriter(
                    new FileWriter(fileDescriptor));

//            for (String line : list) {
//                out.println( line );
//            }
            
            String line = null;
            for (int i = 0; i < list.size(); i++) {
                line = list.get(i);
                out.println( line );
            }
            
            Iterator it = list.iterator();            
            while( it.hasNext() ) {
                line = (String) it.next();
                out.println( line );
                
            }
            
            
            
            out.close();
            System.out.printf("Escribir: %d milisegundos\n",
                    System.currentTimeMillis() - start);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SortFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SortFile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
