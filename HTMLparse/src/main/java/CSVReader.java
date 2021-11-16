/**
 * @author Jesus Angel Juarez
 */
package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class CSVReader implements Runnable {

    public static final String TAG = HTMLReader.class.getSimpleName();

    public static final Logger LOG = Logger.getLogger(TAG);

    public String url;

    public CSVReader(String url) {
        this.url = url;
    }

    public void run() {
        URL webPage = null;
        URLConnection connection = null;

        try {
            webPage = new URL(this.url);
            // abrir conexion
            connection = webPage.openConnection();

        } catch (MalformedURLException ex) {
            LOG.severe(ex.getMessage());
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        }

        // Crear un flujo para leer datos del URL
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        }

        String inputLine = null;
        int countLine = 0;

        /*try {
            while ((inputLine = in.readLine()) != null)
                countLine++;
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        countLine = (int) in.lines().count();
        try {
            System.out.println("Lineas = " + countLine);
            in.close();
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        String url = "https://people.sc.fsu.edu/~jburkardt/data/csv/csv.html";
        Thread t =new Thread(new CSVReader(url));
        t.start();
    }
}
