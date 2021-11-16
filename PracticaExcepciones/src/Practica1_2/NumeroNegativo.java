package Practica1_2;

import java.util.Scanner;

public class NumeroNegativo {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        int numero=teclado.nextInt();

        try {
            validate(numero);
            System.out.println(Math.sqrt(numero));
        } catch (NumeroNegativoExcepcion ne) {
            System.out.println("Se encontro un error");
            System.out.println("Excepcion ocurrida: " + ne);
        } finally {
            teclado.close();
        }

    }
    static void validate (int numero) throws NumeroNegativoExcepcion {
        if(numero < 0){
            throw new NumeroNegativoExcepcion("El numero ingresado es negativo");
        }
    }
}
