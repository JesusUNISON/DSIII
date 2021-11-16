package msp;

/**
 * @author Jesus Angel Juarez Zazueta
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Logger;

public class UserManager {
    public static final String CLASS_NAME = UserManager.class.getSimpleName();
    public static final Logger LOGGER = Logger.getLogger(CLASS_NAME);

    private HashMap<String, Socket> connections;

    public UserManager() {
        super();
        connections = new HashMap<String, Socket>();
    }

    public boolean connect(String user, Socket socket) {
        boolean result = true;

        Socket s = connections.put(user, socket);
        if (s != null) {
            result = false;
        }
        return result;
    }

    public boolean disconnect(String user, Socket socket) {
        boolean result = true;

        Socket s = connections.remove(user);
        if (connections.containsValue(s)) {
            result = false;
        }
        return result;
    }

    public Socket get(String user) {
        Socket s = connections.get(user);
        return s;
    }

    public void send(String message) {
        Collection<Socket> conexiones = connections.values();
        for (Socket s : conexiones) {
            try {
                PrintWriter output = new PrintWriter(s.getOutputStream(), true);
                output.println(message);
            } catch (IOException e) {
                LOGGER.severe(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void send(String message,String user) {
        Socket s = get(user);
        try {
            PrintWriter output = new PrintWriter(s.getOutputStream(), true);
            output.println(message);
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
        }
    }

    public String list() {
        StringBuilder usuarios = new StringBuilder();

        for (String user : connections.keySet()) {
            usuarios.append(user);
            usuarios.append(", ");
        }

        return connections.keySet().toString();
    }

}
