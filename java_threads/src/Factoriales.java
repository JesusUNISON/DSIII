public class Factoriales {

    public static void main(String[] args) {

        System.out.println("main: Factoriales");

        if (args.length > 0) {

            for (String arg:args) {

                int num = Integer.parseInt(arg);

                FactorialHilo f = new FactorialHilo(num);

                Thread t = new Thread(f);

                t.start();

            }

        }

        System.out.println("main: fin");
    }

}
