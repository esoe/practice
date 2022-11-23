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
public class B extends A {

    public B() {
        super(null);  // this();
        System.out.println("B::B()");
    }

    public static void main(String[] args) {
        B b = new B();
        b.a();
    }

    @Override
    public void a() {
        System.out.println("B::a()");
        super.a();
    }
}
