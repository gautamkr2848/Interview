
package com.interview.systemDesign.DesignPattern.creational;

/*Instantiation Type
    1. Eager
    2. Lazy

Example
    1. java.lang.Runtime class
    2. java.awt.Desktop

Uses
    1. DB connection
    2. Error Manager

Break Singleton Pattern Of a Class
    1. Using Reflection => we can use singleton enum to stop breaking singleton pattern
    2. Using Serialization => a. Serialization is used to convert an object of byte stream and save in
                                 a file or send over a network. Then if you de-serialize that object it
                                 will create a new instance
                               b. To ovehigh-level modules should not depend upon low-level modules; they should depend
                                  on abstractionsrcome this issue, we have to implement method readResolve() method.
    3. Using Clone => a. Using clone we can create copy of object.
                      b. To overcome this issue, override clone() method and throw an exception from clone
                         method that is CloneNotSupportedException
*/

import java.lang.reflect.Constructor;

//Eager Instantiation
class Singleton {
    public final static Singleton singleton = new Singleton();      // final makes it thread safe
    private Singleton() {
        if (singleton != null) {        // throw error within constructor for preventing breaking of singleton
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException  {       // override clone for preventing breaking of singleton
        throw new CloneNotSupportedException();
    }

    protected Object readResolve() {        // override clone for preventing breaking of singleton
        return singleton;
    }
}

//Lazy Instantiation
class Singleton_2 {
    private static Singleton_2 singleton;
    private Singleton_2() { }

    public static Singleton_2 getInstance() {
        if(singleton == null)
            singleton = new Singleton_2();
        return singleton;
    }
}

//Double Checked Locking
class Singleton_3 {
    private static Singleton_3 singleton;
    private Singleton_3() { }

    public static Singleton_3 getInstance(){
        if(singleton == null){
            synchronized (Singleton_3.class){
                if(singleton == null) {
                    singleton = new Singleton_3();
                }
            }
        }
        return singleton;
    }
}

//singleton with immutable with help of volatile
class Singleton_4 {
    private static volatile Singleton_4 singleton;
    private Singleton_4() { }

    public static Singleton_4 getInstance(){
        if(singleton == null)
            singleton = new Singleton_4();
        return singleton;
    }
}

class BreakSingleton{
    public void breakSingleton(){
        Singleton objOne = Singleton.singleton;
        Singleton objTwo = null;
        try {
            Constructor constructor = Singleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            objTwo = (Singleton) constructor.newInstance();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        System.out.println("Hashcode of Object 1 - "+objOne.hashCode());
        System.out.println("Hashcode of Object 2 - "+objTwo.hashCode());
    }
}