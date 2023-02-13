package com.ustc.maven.lazysingleton;

/**
 * @author Miracle
 * @date 2022/11/11 11:10
 * @description LazysingletonTest
 */
public class LazysingletonTest {
    public static void main(String[] args) {
        Lazysingleton instance = Lazysingleton.getInstance();
        Lazysingleton instance1 = Lazysingleton.getInstance();
        System.out.println(instance == instance1);

        new Thread( ()->{
            Lazysingleton instance2 = Lazysingleton.getInstance();
            System.out.println(instance2);
        } );
        new Thread( ()->{
            Lazysingleton instance2 = Lazysingleton.getInstance();
            System.out.println(instance2);
        } );
    }
}

class Lazysingleton{
    private static Lazysingleton instance;
    private Lazysingleton(){}
    public synchronized static Lazysingleton getInstance(){   //synchronized可以保证线程安全
        if(instance == null){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            instance = new Lazysingleton();
        }
        return instance;
    }
}
