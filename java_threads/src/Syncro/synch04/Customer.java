/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syncro.synch04;

/**
 *
 * @author rnavarro
 */
class Customer {

    // saldo del cliente
    int amount = 10000;

    synchronized void withdraw(int amount) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ":Retirando...");

        while( this.amount < amount ) {
            System.out.println(name + ":Saldo insuficiente; esperando deposito...");
            try {
                wait(1000);
            } catch (Exception e) {
            }
        }
        this.amount -= amount;
        System.out.println(name + ":Retiro completo");
    }

    synchronized void deposit(int amount) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ":depositando...");
        this.amount += amount;
        System.out.println(name + ":deposito completo. ");
        notify();
    }
}
