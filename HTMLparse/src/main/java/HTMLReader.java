/**
 * @author Jesus Angel Juarez
 */
package main.java;

import javax.swing.text.html.HTMLEditorKit;
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

public class HTMLReader {
    // https://people.sc.fsu.edu/~jburkardt/data/csv/csv.html
    // https://people.sc.fsu.edu/~jburkardt/data/csv/cities.csv
    // https://people.sc.fsu.edu/~jburkardt/data/xml/ell_65.xml
    // https://docs.oracle.com/javase/tutorial/getStarted/cupojava/netbeans.html

    public static final String TAG = HTMLReader.class.getSimpleName();

    public static final Logger LOG = Logger.getLogger(TAG);

    public static final String URL_STRING =
            "https://people.sc.fsu.edu/~jburkardt/data/csv/csv.html";

    public static void main(String[] args) {

        URL webPage = null;
        URLConnection connection = null;
        URL archivo = null;

        try {
            webPage = new URL(URL_STRING);


            archivo = new URL(URL_STRING.substring(0,URL_STRING.lastIndexOf("/")+1));

            // abrir conexion
            connection = webPage.openConnection();

            String tipoContenido = connection.getContentType();
            long size = connection.getContentLengthLong();

            System.out.println("Tipo: " + tipoContenido );
            System.out.println("Tamanio en bytes: " + size );
            System.out.println("");

        } catch (MalformedURLException ex) {
            LOG.severe(ex.getMessage());
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        }

        // Crear un flujo para leer datos del URL
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader( connection.getInputStream() ));
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        }

        HTMLParser parserGetter = new HTMLParser();

        HTMLEditorKit.Parser parser = parserGetter.getParser();

        // HTMLEditorKit.ParserCallback callback = new ElementHandler() ;
        // ImgCounter callback = new ImgCounter() ;

        URLParser callback = new URLParser(archivo);


        try {
            parser.parse(in , callback, false);
        } catch (IOException ex) {

        }

        //System.out.println("Total de imagenes: " + callback.getImgCounter());

    }

}
