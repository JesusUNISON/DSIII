/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections.bingo;

//********************************************************************
import java.util.HashSet;
import java.util.Iterator;

//  Bingo.java       Authors: Lewis/Chase
//
//  Demonstrates the use of a bag collection.
//********************************************************************
public class Bingo {
    //-----------------------------------------------------------------
    //  Creates all 75 bingo balls and stores them in a bag. Then
    //  pulls several balls from the bag at random and prints them.
    //-----------------------------------------------------------------

    public static void main(String[] args) {
        final int NUM_BALLS = 75, NUM_PULLS = 10;

        HashSet<BingoBall> bingoBag = new HashSet<BingoBall>();
        BingoBall ball;

        for (int num = 1; num <= NUM_BALLS; num++) {
            ball = new BingoBall(num);
            bingoBag.add(ball);
        }

        System.out.println("Size: " + bingoBag.size());
        System.out.println();

        Iterator<BingoBall> iterator = bingoBag.iterator();

        while (iterator.hasNext() ){
            BingoBall element = iterator.next();
            System.out.println(element);
        }
    }
}
