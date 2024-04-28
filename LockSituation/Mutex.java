import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Mutex
{
    // Mutext is a short form of mutual exclusion that allows only one thread at a time to access a resource.
    //They used to typically protect the other thread to access the shared resource.
    //It has concept of ownership, if mutex acquires lock then, until it releases the lock another one cant take it.
    //Only that mutex can unlock it.

    //*****Remember we use lock and synchronised keywords in our methods. and from main method we call thread;
    private static  Lock mutex = new ReentrantLock();
    private static int counter;

    public static void increment()
    { 
       mutex.lock();
        try
        {
            for(int i=0;i<1000000;i++)
            {
                counter++;
            }
        }
        finally
        {
            mutex.unlock();
        }
    }
    public static void main(String[]args)
    {
        Thread t1= new Thread(new Runnable()
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

        System.out.println("Value of counter "+counter);
    }

    
}