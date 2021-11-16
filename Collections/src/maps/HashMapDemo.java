/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.maps;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author rnavarro
 */
public class HashMapDemo {
    public static void main(String[] args) {
        
    // Create a HashMap object called population
    //HashMap<String, Double> population = new HashMap<String, Double>();

    TreeMap<String, Double> population = new TreeMap<String, Double>();
    
    // Add keys and values (Country, City)
    population.put("England", 55.98 );
    population.put("Germany", 83.02 );
    population.put("Norway", 5.43 );
    population.put("USA", 328.20 );
    
    System.out.println(population);
    
    double pop = population.get("Norway");
    
    System.out.println("Población de Noruega: " + pop);
    
    Set<String> keys  = population.keySet();
    
    for(String pais : keys ) {
        System.out.println( pais );
    }
    
    population.replace("Norway", pop + 1.0);
    pop = population.get("Norway");
    
     System.out.println("Población de Noruega: " + pop);
    
    
    
    System.out.println("Hashcode " + "Norway".hashCode() );      
    
  }
    
}
