package mx.unison.streamsdemo.csv;

import java.io.*;
import java.util.Scanner;

public class ScanCSV {

    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("vendors.csv")));

            // saltar la linea con nombres de columna
            s.nextLine();

            s.useDelimiter(",\\s*");

            int c = 1;

            String registro = null;

            while ( s.hasNext() ) {
                int cve = s.nextInt();
                String name = s.next();
                String date = s.next();
                String state = s.nextLine();
                System.out.printf("|%03d|%-25s|%10s|%15s|\n",cve,name,date,state);
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
