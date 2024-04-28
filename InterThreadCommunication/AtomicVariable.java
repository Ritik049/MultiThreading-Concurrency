//Atomic variable is a special type of variable to provide atomicity,meaning that operations on the variable are peformed atomically, without interference of other threads.
//Atomicity refers property which guarantee that operations getting  executed in a single indivisible unit.
  import java.util.*;
 import java.util.concurrent.atomic.AtomicInteger;
public class AtomicVariable
{  
    private static AtomicInteger counter = new AtomicInteger(0);  //default value;

     public  static void increment()
    {
        for(int i=0;i<1000000;i++)
        {
            counter.getAndIncrement();      //Operations occur as singleIndivisible unit.
        }
    }
    public static void main(String[]args)
    {
       Thread t1 = new Thread(new Runnable()
       {
        public void run()
        {
            increment();
        }
       });

       Thread t2 = new Thread(new Runnable()
       {
        public void run()
        {
            increment();
        }
       });

       t1.start();
       t2.start();

       try{
        t1.join();
        t2.join();
       }
       catch(InterruptedException e)
       {
        e.printStackTrace();
       }

       System.out.println("VAlue of counter "+counter);
    }

   
}