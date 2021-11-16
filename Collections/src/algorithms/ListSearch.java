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
public class ListSearch {

    public static void main(String[] args) {
        
        List<String> list = new ArrayList<String>();

        // lista de argumentos
        list.addAll( Arrays.asList(args) );

        System.out.println(list);

        int pos = list.indexOf("tres");

        String s = list.get(pos);

        System.out.println(s + " esta en indice " + pos);

    }
}
