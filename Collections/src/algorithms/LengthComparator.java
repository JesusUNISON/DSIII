/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.algorithms;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author rnavarro
 */
public class LengthComparator implements Comparator {
    
    
    // Comparador para ordenar por longitud de cadena
    // devuelve un entero negativo, cero o un entero positivo 
    // si es que el primer (o1) argumento es menor, igual o mayor 
    // que el segundo (o2).
    
    @Override
    public int compare(Object o1, Object o2) {
       String s1 = (String) o1;
       String s2 = (String) o2;
              
       return s1.length() - s2.length();               
    }
    
}
