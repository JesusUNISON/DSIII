/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rnavarro
 */
public class Circle {
    
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double perimetro() {
        return Math.PI * radius * 2.0;
    }
    
    
    
}
