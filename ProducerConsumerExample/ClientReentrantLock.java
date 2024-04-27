public class ClientReentrantLock
{
    public static void main(String[]args)
    {   

        ProcessReentrantLock process = new ProcessReentrantLock();
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                try{
                    process.producer();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

          Thread t2 = new Thread(new Runnable()
          {
            public void run()
            {
                try{
                    process.consumer();           //AS process consumer and producer methods throws InterruptedException
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
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
    }
}