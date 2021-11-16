/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

/**
 *
 * @author rnavarro
 */
public class Shuffle {
    public static void main(String[] args) {
       List<String> list = new ArrayList<String>();
        
        
        // lista de argumentos
        for (String a : args)
            list.add( a );
        
        System.out.println( list );
        
        Collections.shuffle(list, new Random());
        System.out.println( list );
    }
}
