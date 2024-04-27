public class LockCustomObjects
{
    //Solving Problem Arises due to intrinsic lock,  as if two method  are synchronised independently then if first thread is executing then until that thread does not finish its exeution, other indpendent synchronised method cant start its execution.

    //Here using custom Object lock , lock1, lock2, we are using synchronized keyword on these lock , these are acteds as two independent lock, so both threads can do their execution at same tiem
    //No need to wait that thread1 finished its execution that thread2 starts

    //At the same time --> NOt parallel it means TimeSlicingAlgorithm.

    public static int counter1;
    public static int counter2;
    

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();


     public static void process()
    {
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<100000;i++)
                {
                    synchronized(lock1)
                    { 
                        counter1++;
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
                     synchronized(lock2)
                     {
                        counter2++;
                     }
                }
                
                
               
            }
        });

      


        t1.start();
        t2.start();
        

        try
        {
            t1.join();
            t2.join();
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Value of counter1 "+counter1);
         System.out.println("Value of counter2 "+counter2);
 
    }


  public static void main(String[]args)
  {
  LockCustomObjects.process();
  }
   
}