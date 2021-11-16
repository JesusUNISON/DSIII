package Hilos;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rnavarro
 */
class HelloRunner implements Runnable {
    public static final int MAX = 500;

    private int i;

    public void run() {
        i = 0;

        while (true) {
            String name = Thread.currentThread().getName();
            System.out.printf("%s: Hello %d\n",name, i++);

            if (i == MAX) {
                break;
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("main: inicio");
        Thread t = new Thread( new HelloRunner() );
        
        t.start();
        System.out.println("main: fin");

    }
}
