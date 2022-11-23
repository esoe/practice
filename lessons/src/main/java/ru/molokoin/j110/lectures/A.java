/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.molokoin.j110.lectures;

/**
 *
 * @author (C)Y.D.Zakovryashin, 07.10.2022
 */
public class A {
    private A a;
    private A b;
    
    public A () {
       this(null);
       System.out.println ("A::A()"); 
    }
    
    public A (A a) {
        System.out.println("A::A(A)");
    }
    
    public void a () {
        System.out.println("A::a()");
    }
    
    public void a (A a) {
        System.out.println("A::a(A)");
    }
    
    public static void main (String[] args) {
        System.out.println("Hello, Java!!!");
        A a = new A (null);
        a.a(a);
    }
}
