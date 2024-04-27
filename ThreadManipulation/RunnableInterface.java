import java.util.*;
public class RunnableInterface 
{
    public static void main(String[] args)
    {  
        //CREATING A thread object using runnable interface.
        Thread t1 = new Thread(new runner1());
        Thread t2 = new Thread(new runner2());

        Thread t3 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for(int i=0;i<10;i++)
                {
                    System.out.println("RUNNER 3 "+i);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}








