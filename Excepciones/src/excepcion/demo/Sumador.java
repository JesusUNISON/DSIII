package excepcion.demo;

public class Sumador {

    public static void main(String args[]) {
        int a = 0;
        int b = 0;

        if( args.length == 2 ) {
            try {
                a = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e)    {
                System.out.println(e.getMessage());
                System.out.println( "Error de formato en el primer argumento");
                a = 0;
            }

            try {
                b = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e)    {
                System.out.println(e.getMessage());
                System.out.println( "Error de formato en el segundo argumento");
                b = 0;
            }

            System.out.printf("%d + %d = %d\n", a, b, a + b);

        }

    }
}
