package Hilos;

import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rnavarro
 */
class HelloSlowRunner implements Runnable {
    public static final String TAG = HelloSlowRunner.class.getSimpleName();
    public static final int MAX = 500;

    public static final  Logger LOGGER = Logger.getLogger(TAG);
    
    private int i;

    public void run() {
        i = 0;

        while (true) {
            String name = Thread.currentThread().getName();
            System.out.printf("%s: Hello %d\n",name, i++);
            
            if (i == MAX) {
                break;
            }
            
            try {
                // descansar medio segundo
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                LOGGER.severe(ex.getMessage());
            }
        }
    }

    public static void main(String args[]) {
        
        Thread t = new Thread( new HelloRunner() );
        
        t.start();

    }
}
