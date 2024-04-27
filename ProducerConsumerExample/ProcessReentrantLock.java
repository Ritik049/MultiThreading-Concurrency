import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ProcessReentrantLock
{
    //Reentrant lock are explicit locks and provide additional functionality
    //Here we can unlock in another method and lock in another method.
    //Here we nned not to use synchronized keyword.
    //When we initialise ReentrantLock then is has argument boolean fairness which has default value as true.
    //HERe we need to use 


//**** VOLATILE Keyword is used to store variable in mainMemory so they can be accessible from mainMemory itself. */
//** CAN be used as synchronisation alternative but if multiple threads  */

 
 private Lock lock = new ReentrantLock();
 private Condition condition = lock.newCondition();
   private static final int  UPPER_LIMIT = 5;
   private static final int LOWER_LIMIT = 0;
   private  int value;
   private List<Integer>lst = new ArrayList<>();
    public void producer() throws InterruptedException 
    {
           lock.lock();

           try
           {
            while(true)
            {
                if(lst.size() == UPPER_LIMIT)
                {
                    System.out.println("Waiting for removing items");
                    //lock.wait();
                    condition.await();
                }
                else
                {
                    System.out.println("Adding: "+value);
                    lst.add(value);
                    value++;
                    //lock.notify();
                    condition.signal();
                }
                Thread.sleep(500);
            }
            
           }
           finally
            {
                lock.unlock();
            }

    }

     public void consumer() throws InterruptedException 
    {
        lock.lock();
           try{
            Thread.sleep(1000);      //Producer will run firstly.
            while(true)
            {
                if(lst.size() == LOWER_LIMIT)
                {
                    System.out.println("Waiting for Adding items...");
                    //INitialising value again 0 for producer
                    value = 0;
                    condition.await();
                }
                else
                {  
                    System.out.println("Removing: "+lst.remove(lst.size()-1));
                    
                   // value--;
                    condition.signal();
                }
                Thread.sleep(500);
            }
           }
           finally
           {
            lock.unlock(); 
           }
    }
}