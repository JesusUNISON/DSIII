/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urlconnection;

import urls.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author rnavarro
 */
public class URLReader {
    // https://people.sc.fsu.edu/~jburkardt/data/csv/csv.html
    // https://people.sc.fsu.edu/~jburkardt/data/csv/cities.csv
    // https://people.sc.fsu.edu/~jburkardt/data/xml/ell_65.xml
    
    public static final String TAG = URLReader.class.getSimpleName();
    
    public static final Logger LOG = Logger.getLogger(TAG);
    
    public static void main(String[] args) {

        URL webPage = null;
        URLConnection connection = null;
        
        try {
            webPage = new URL("https://people.sc.fsu.edu/~jburkardt/data/xml/ell_65.xml");
            
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
        
        // Obtener encabezados que regresa el web server
        Map<String,List<String>> headers = connection.getHeaderFields();  
        
        // Obtener nombres de encabezados que regresa el web server
        Set<String> headersName = headers.keySet();
        
        for(String name: headersName) {
            System.out.printf("%s = %s\n",name, headers.get(name) );
        }
        
        System.out.println("\nContedido:\n");
        
        // Crear un flujo para leer datos del URL
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader( connection.getInputStream() ));
        } catch (IOException ex) {
             LOG.severe(ex.getMessage());
        }

        String inputLine = null;
        
        try {
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
        } catch (IOException ex) {
            LOG.severe(ex.getMessage());
        }
        try {
            in.close();
        } catch (IOException ex) {
             LOG.severe(ex.getMessage());
        }
        
    }
    
}
