/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

/**
 *
 * @author (C)Y.D.Zakovryashin, 07.10.2022
 */
public interface I {

    public static final A a = new A(null);
    A b = null;

    public abstract void a();

    void a(A a);

    default void b() {
        System.out.println("I:b() - default");
    }
}
