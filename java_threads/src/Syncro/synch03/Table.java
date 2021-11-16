package Syncro.synch03;

public class Table {

    //method not synchronized
    public synchronized void printTable(int n) {
        synchronized(this) {//synchronized block

            for (int i = 1; i <= 10; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }


    }
}
