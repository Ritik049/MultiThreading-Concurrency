import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class DeadLockWorker
{
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public void worker1()
    {
        lock1.lock();
        System.out.println("Worker1 acquires Lock1");

        try{
            Thread.sleep(3000);              //So that thread2 comes and acquire lock2
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        lock2.lock();

        System.out.println("Worker1 acquires Lock2");
        
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2()
    {
        lock2.lock();

        System.out.println("Worker2 acquires Lock2");

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        
        lock1.lock();

        System.out.println("Worker2 acquires Lock1");

        lock1.unlock();
        lock2.unlock();
    }
}