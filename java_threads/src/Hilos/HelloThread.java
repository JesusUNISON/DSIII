package Hilos;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Logger;

/**
 *
 * @author rnavarro
 */
public class HelloThread extends Thread {

    public static final String TAG = HelloThread.class.getSimpleName();
    public static final Logger LOGGER = Logger.getLogger(TAG);

    public void run() {

        LOGGER.info("Hello from a thread: " + currentThread().getName());
        System.out.println("Hello from a thread!");

    }

    public static void main(String args[]) {
        System.out.println("main: inicio");
        // crear el objeto thread
        HelloThread t = new HelloThread();

        // iniciar la ejecución del thread
        t.start();
       // t.run();
        
        System.out.println("main: Fin");
    }

}
