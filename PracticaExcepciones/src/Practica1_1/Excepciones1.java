package Practica1_1;

import java.util.Scanner;

public class Excepciones1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Palabra: ");
        String lectTeclado= teclado.next();
        //int posicion= teclado.nextInt();
        int posicion=7;
        System.out.println("Posicion: "+posicion);
        try {
            System.out.println(caracterEn(lectTeclado,posicion));
        } catch (Exception e) {
            e.printStackTrace();
        }
        teclado.close();
    }

    public static char caracterEn(String texto, int posicion) throws Exception {
        if (posicion >= texto.length() || posicion < 0) {
            throw new Exception("Has intentado recuperar una posición de la cadena de caracteres que no existe");
        }
        return texto.charAt(posicion);

    }

}
