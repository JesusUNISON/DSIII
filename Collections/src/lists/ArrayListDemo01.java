/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lists;

import java.util.ArrayList;

/**
 *
 * @author rnavarro
 */
public class ArrayListDemo01 {
    public static void main(String[] args) { 
        // Creando una ArrayList genérica  
        ArrayList testLis = new ArrayList(); 
 
        // Tamaño de arrayList  
        System.out.println("Tamaño de ArrayList en la creación:" + testLis.size()); 
 
        // Permite agregarle algunos elementos  
        testLis.add("D"); 
        testLis.add("U"); 
        testLis.add("K"); 
        testLis.add("E");  
 
        // Vuelva a verificar el tamaño después de agregar elementos 
        System.out.println("Tamaño de ArrayList después de agregar elementos:" + 
                testLis.size());  
 
        // Mostrar todos los contenidos de ArrayList  
        System.out.println("Lista de todos los elementos:" + testLis);  
 
        // Eliminar algunos elementos de la lista  
        testLis.remove ("D");  
        System.out.println("Ver contenido después de eliminar un elemento:" + 
                testLis);  
 
        // Eliminar elemento por índice  
        testLis.remove (2);  
        System.out.println("Ver contenido después de eliminar elemento por índice:" + 
                testLis);  
 
        // Verifique el tamaño después de eliminar los elementos  
        System.out.println("Tamaño de arrayList después de eliminar elementos:" + 
                testLis.size()); 
        System.out.println("Lista de todos los elementos después de eliminar elementos:" +
                testLis);  
 
        // Verifica si la lista contiene "K"  
        System.out.println(testLis.contains("K")); 
    }
}
