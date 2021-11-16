import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingConfiguration {

    static Logger logger = Logger.getLogger(LoggingConfiguration.class.getName());

    public static void main(String[] args) {

        try {
            FileInputStream configFile = new FileInputStream("mylogging.properties");
            LogManager.getLogManager().readConfiguration(configFile);
        } catch (IOException ex) {
            logger.severe(ex.getMessage());
        }

        logger = Logger.getLogger(LoggingConfiguration.class.getName());
        //logger.setUseParentHandlers(false);
        System.out.println("Loger name: " + logger.getName());

      //  logger.setLevel(Level.FINE);
       // logger.addHandler(new ConsoleHandler());

        //adding custom handler
       // logger.addHandler(new MyHandler());
        try {
            //FileHandler file name with max size and number of log files limit
            //Handler fileHandler = new FileHandler("logger.log", 2000, 5);

           // fileHandler.setFormatter(new MyFormatter());
            //setting custom filter for FileHandler
           // fileHandler.setFilter(new MyFilter());
           // logger.addHandler(fileHandler);

            for (int i = 0; i < 1000; i++) {
                //logging messages
                logger.log(Level.INFO, "Msg" + i);
            }
            logger.log(Level.CONFIG, "Config data");
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}
