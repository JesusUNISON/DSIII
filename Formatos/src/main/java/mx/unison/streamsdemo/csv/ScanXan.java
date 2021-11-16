package mx.unison.streamsdemo.csv;

import java.io.*;
import java.util.Scanner;

public class ScanXan {
    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("vendors.csv")));

            s.useDelimiter(",\\s*");

            while (s.hasNext()) {
                System.out.println(s.next());
            }

        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
