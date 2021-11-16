public class FactorialHilo implements Runnable {

    private int num;

    public FactorialHilo(int num) {
        this.num=num;
    }

    public void run() {
        int fact = 1;
        while (this.num != 0) {
            fact = fact * this.num;
            this.num--;
        }
        System.out.println(Thread.currentThread().getName() + ": " + fact);
    }

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        Thread t = new Thread(new FactorialHilo(num));
        t.start();
    }

}
