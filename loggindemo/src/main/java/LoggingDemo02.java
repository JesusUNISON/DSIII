import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingDemo02 {
    private static final String CLASS_NAME = LoggingDemo02.class.getName();
    private final static Logger LOG =
            Logger.getLogger(CLASS_NAME);

    public static void main(String[] args) throws IOException {
        System.out.println(CLASS_NAME);

        // Aarchivo para guardar logs
        FileHandler logFile = new FileHandler("Logging.txt");

        // Crear un formatter
        SimpleFormatter plainText = new SimpleFormatter();
        logFile.setFormatter(plainText);

        // agregar el
        LOG.addHandler(logFile);

        LOG.setLevel( Level.ALL );

        LOG.fine("FINE");
        LOG.info("INICIO");
        LOG.warning("WARNING");
        LOG.severe("SEVERE");

        LoggingDemo02.doIt();

        LOG.info("FIN");

    }

    public static void doIt() {
        LOG.info("INICIO");

        try {

            Integer.parseInt("123k");

        } catch (Exception e) {
            LOG.severe("Error: " + e.getMessage() );
        }

        LOG.info("FIN");

    }
}
