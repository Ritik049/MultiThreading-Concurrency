import java.util.*;
public class JoinMethod 
{
    public static void main(String[]args)  throws InterruptedException
    {
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i=0;i<10;i++)
                {
                    System.out.println("runner1 "+i);
                }

            }
        });
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i=0;i<10;i++)
                {
                    System.out.println("runner 2 "+i);
                }
            }
        });
    

        
        t1.start();
        t2.start();

        //Without join --> Thread main thread , t1 thread,  t2 thread.
        System.out.println("Without join");

        //With using join,  --> It allows one thread to wait for completion of another.
       try{
        t1.join();
       }
       catch(InterruptedException e)
       {
        System.out.println(e);
       }
        System.out.println("Thread1 finish");  //May be in mid;  //These linew will print only when thread1 finishes.
       
        try
          {        t2.join();}
          catch(InterruptedException e)
          {
            System.out.println(e);
          }

        System.out.println("Thread2 finish");  //IN last;
    

    }
}