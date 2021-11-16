/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Collections;

/**
 *
 * @author rnavarro
 */
public class SortList {
    public static void main(String[] args) {
        
       String[] palabras = {"uno","de","Sonora","cuatros",
           "once","universidad","zz","aa"};
        
       List<String> list = Arrays.asList( palabras );
        
        
        // lista de argumentos
      //  for (String a : args)
            // list.add( a );
        
        System.out.println(list);
        
       list.sort( new StringComparator() );
       // list.sort(new LengthComparator());
        
        
        // Collections.sort( list );
        
       
       // Collections.sort( list, new LengthComparator() );
       
//       for (String a : list) {
//            System.out.println(a);
//       }
        
       System.out.println(list);
    }
}
