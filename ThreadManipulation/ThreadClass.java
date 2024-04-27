import java.util.*;
public class ThreadClass
{ 
    public static void main(String[]args)
    {
        Thread t1 = new thread1();
        Thread t2 = new thread2();           

        t1.start();
        System.out.println("HELLO");
        t2.start();
    }
}

//** USE RUNNABLE INTERFACE as it is interface so you can extend new class.