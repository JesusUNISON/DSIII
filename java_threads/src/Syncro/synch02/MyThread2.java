package Syncro.synch02;



public class MyThread2 extends Thread  {
    private Table t;

   public MyThread2(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}
