import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class LiveLockWorker
{ 
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);
      public void worker1()
    {
        while(true)
        {  
            try
           { lock1.tryLock(50,TimeUnit.MILLISECONDS);  //trys to acquire lock  maximum upto 50 milliseconds.
           System.out.println("Worker1 acquires lock1");
           }
           catch(InterruptedException e)
           {
            e.printStackTrace();
           }

           System.out.println("Worker1 tries to acquire lock2");

           if(lock2.tryLock())
           {
            System.out.println("Worker1 acquires Lock2");
            lock2.unlock();
           }
           else
           {
            System.out.println("Worker1 can't acquire Lock2");
            continue;
           }
      
      break;


        }
        lock1.unlock();
        lock2.unlock();
    }

     public void worker2()
    {
        while(true)
        {  
            try
           { lock2.tryLock(50,TimeUnit.MILLISECONDS);
           System.out.println("Worker2 acquires lock2");
           }
           catch(InterruptedException e)
           {
            e.printStackTrace();
           }

           System.out.println("Worker2 tries to acquire lock1");

           if(lock1.tryLock())
           {
            System.out.println("Worker2 acquires Lock1");
            lock1.unlock();
           }
           else
           {
            System.out.println("Worker2 can't acquire Lock1");
            continue;
           }
      
      break;


        }
        lock1.unlock();
        lock2.unlock();
    }
}