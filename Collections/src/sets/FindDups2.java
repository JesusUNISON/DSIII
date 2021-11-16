/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.sets;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rnavarro
 */
public class FindDups2 {
    public static void main(String[] args) {
        
        String words[] = {"EL", "CABALLO", "CORRE", "POR", "EL", "CAMPO"};
        
        Set<String> uniques = new HashSet<String>();
        Set<String> dups    = new HashSet<String>();

        for (String a : words)
            // add regresa false si esta duplicado
            if ( !uniques.add( a ) ) 
                dups.add(a);

        // Remover palabras duplicadas (diferencia de conjuntos).
        uniques.removeAll(dups);

        System.out.println("Unique words:    " + uniques);
        System.out.println("Duplicate words: " + dups);
    }
    
}
