public class ClientLowerLevel
{
    public static void main(String[]args) throws InterruptedException
    {
        ProcessLowerLevel process = new ProcessLowerLevel();
        
        Thread t1= new Thread(new Runnable()
        {
            public void run()
            { 
                try
                {process.producer();}
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
                try
                {process.consumer();}
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