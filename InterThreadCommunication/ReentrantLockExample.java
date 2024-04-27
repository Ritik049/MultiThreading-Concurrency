import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
public  class ReentrantLockExample
{
    //Reentrant lock provide additional features than, normal locking like interruptible lock acquisition,time lock acquisition.
    //A given thread can not acquire a lock which owns by another thread, but a thread can acquire that lock which it already owns.
    private static final ReentrantLock lock = new ReentrantLock();      //this is property of class.
    
    public static int counter;
    public static void main(String[]args)
    {   
        
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                 for(int i=0;i<100000;i++)
                 {
                     lock.lock();                    //HERE we not use synchronized keyword.

                     try{
                        counter++;
                     }
                     finally
                     {
                        lock.unlock();
                     }
                 }
            }
        });

       Thread t2 = new Thread(new Runnable()
        {
            public void run()
            {
                 for(int i=0;i<100000;i++)
                 {
                     lock.lock();                    //HERE we not use synchronized keyword.

                     try{
                        counter--;
                     }
                     finally
                     {
                        lock.unlock();                 //Manually we can unlock.
                     }
                 }
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

        System.out.println("Value of counter "+ counter);

    }
}