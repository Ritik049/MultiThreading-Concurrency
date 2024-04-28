public class LiveLock
{
    //LIVELOCK:  Situation where two or more thread change ther state continuously due to response of other thread.
    //hERE threads not block each other but unable to do progress.

    //woker1 tries to acquire lock2 , worker2 cause it false ,then it again continue, and then again same repeating cycle
    //same as vice versa;
    public static void main(String[]args)
    {
        LiveLockWorker worker = new LiveLockWorker();

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