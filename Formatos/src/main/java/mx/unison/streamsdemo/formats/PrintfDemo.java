package mx.unison.streamsdemo.formats;

import java.util.Locale;

public class PrintfDemo {

    public static final String MSG="Hola Mundo";

    public static void  main(String args[]) {

        System.out.printf("demo%nsalto%nlinea%n");

        // boolean %b %B
        System.out.printf("%b%n", null);
        System.out.printf("%B%n", false);
        System.out.printf("%B%n", 5.3);
        System.out.printf("%b%n", MSG);

        // Strings %s
        System.out.printf("'%s' %n", MSG);
        System.out.printf("'%S' %n", MSG);

        System.out.printf("'%15S' %n", MSG);
        System.out.printf("'%-15S' %n", MSG);

        // solo imprime 2 caracteres y rellena con espacios
        System.out.printf("'%15.2S' %n", MSG);

        // solo imprime 2 caracteres
        System.out.printf("'%2.2S' %n", MSG);

        // INTs %d
        System.out.printf("simple integer: %d%n", 10000L);
        System.out.printf("simple integer: '%8d'%n", 10000L);
        System.out.printf("simple integer: '%08d'%n", 10000L);

        System.out.printf(Locale.US, "%,d %n", 10000);
        System.out.printf(Locale.ITALY, "%,d %n", 10000);

        // FLOATs %f
        System.out.printf("%f%n", 5.1473);

        System.out.printf("'%5.2f'%n", 5.1473); // ' 5.15'

        System.out.printf("'%5.2e'%n", 5.1473); // '5.15e+00'

    }

}
