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
public class C implements I {

    public void a() {
        System.out.println("C::a()");
    }

    public void a(A a) {
        System.out.println("C::a(A)");
    }

    public static void main(String[] args) {
        C c = new C();
        c.a();
        c.a(null);
        c.b();
    }
}
