package Syncro.sync01;

public class MyThread1 extends Thread  {
    private Table t;

   public MyThread1(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }

}
