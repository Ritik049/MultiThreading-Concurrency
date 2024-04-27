import java.util.*;
public class ProcessLowerLevel 
{ 
    //As we are using while true() so it runs indefinitely, 
    //now in this scenario we use wait and notify, 
    //If producer reaches upperLimit then wait() so it releases the lock, and consumer takes it. and it releases lock only when it reaches lowerLimit.
    //we perform notify operation, (AS WE ARE USING WAIt) but notify not immediately shut down operations of ongoing thread.

   private final Object lock = new Object();
   private static final int  UPPER_LIMIT = 5;
   private static final int LOWER_LIMIT = 0;
   private  int value;
   private List<Integer>lst = new ArrayList<>();
    public void producer() throws InterruptedException 
    {
           synchronized(lock)
           {
            while(true)
            {
                if(lst.size() == UPPER_LIMIT)
                {
                    System.out.println("Waiting for removing items");
                    lock.wait();
                }
                else
                {
                    System.out.println("Adding: "+value);
                    lst.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(500);
            }
            
           }
    }

     public void consumer() throws InterruptedException 
    {
           synchronized(lock)
           {
            Thread.sleep(1000);      //Producer will run firstly.
            while(true)
            {
                if(lst.size() == LOWER_LIMIT)
                {
                    System.out.println("Waiting for Adding items...");
                    //INitialising value again 0 for producer
                    value = 0;
                    lock.wait();
                }
                else
                {  
                    System.out.println("Removing: "+lst.remove(lst.size()-1));
                    
                   // value--;
                    lock.notify();
                }
                Thread.sleep(500);
            }
           }
    }
}