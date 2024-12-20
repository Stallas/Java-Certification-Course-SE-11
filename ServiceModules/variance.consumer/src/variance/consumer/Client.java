/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 10: Services in Modular Application
Topic:  Service Extras
*/

package variance.consumer;

import variance.spi.MyService1;
import variance.spi.MyService2;

import java.util.ServiceLoader;

public class Client {
    public static void main(String[] args) {

        MyService2 s1 = ServiceLoader.load(MyService2.class)
                // ServiceLoader.findFirst() returns an Optional
                .findFirst()
                // Need to use .get() on Optional to get a PayOffService
                .get();

        MyService1 s2 = ServiceLoader.load(MyService1.class)
                // ServiceLoader.findFirst() returns an Optional
                .findFirst()
                // Need to use .get() on Optional to get a PayOffService
                .get();

        s1.doSomething();
        s2.doSomething();
    }
}