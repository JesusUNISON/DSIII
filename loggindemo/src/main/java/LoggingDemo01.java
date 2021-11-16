import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingDemo01 {
    private static final String CLASS_NAME = LoggingDemo01.class.getName();
    private final static Logger LOG = Logger.getLogger(CLASS_NAME);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(CLASS_NAME);

        LOG.setLevel( Level.FINE );

        // nivel fine, normalmente es para debugging
        LOG.fine("INICIO");

        LoggingDemo01.doIt();

        LOG.fine("FIN");

    }

    public static void doIt() {
        LOG.info("INICIO");

        try {
            int x = Integer.parseInt("256k");
        } catch (Exception e) {
            LOG.severe("Error: " + e.getMessage() );
        }
        LOG.info("FIN");
    }
}
