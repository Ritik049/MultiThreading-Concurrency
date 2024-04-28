public class DeadLock
{
    //When two process each  with in its own transaction updates of two rows of information but in opposite order.
    //Dealock occurs when the thread1 needed the lock held by thread2 and lock needed by thread 2 is held by lock1
    //HERE BASICALLY two lock involve.

    public static void main(String[]args)
    {
        DeadLockWorker worker = new DeadLockWorker();

        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                worker.worker1();
            }
        });

        Thread t2 = new Thread(new Runnable()
        {
            public void run()
            {
                worker.worker2();
            }
        });

       
       System.out.println("Given Threads result in deadLock-->NO PROGRESS");
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


    }

}