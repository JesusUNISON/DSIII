package mx.unison.streamsdemo.csv;

import java.io.*;
import java.util.Scanner;

public class ScanVendors {

    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("vendors.csv")));

            // saltar la linea con nombres de columna
            s.nextLine();

            //s.useDelimiter(",\\s*");

            int c = 1;

            String registro = null;

            while (s.hasNextLine()) {

                registro = s.nextLine();

                String[] campos = registro.split(",");

                if (campos.length >= 4) {
                    for (String field : campos) {
                        System.out.print(field + "|");
                    }
                    System.out.println();
                } else {
                    System.err.println("Registro invalido: " + registro);
                }
                c++;
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
