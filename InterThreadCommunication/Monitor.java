//Intrinsic Lock is called Monitor, get acquired by thread while executing so no other thread get access of this intrinsic lock.

//Problem: When we have 2 independent synchronised method, then thread have to wait each other to release a lock.
//Here both increment1 and increment2 are independent of each other,
//so when increment1 acquire lock of Monitor,so until it release the lock increment2() will not work.
//t1 and t2 uses Method level synchronisation
//t3 uses  class Level and block level synchronisation.

//t4 is usign Object Level and method level synchronisation
//t5 is using Object Level and block Level synchronisation


//** IT is good practice to use Synchronised block rather than using synchronisation method */

public class Monitor
{
        public static int counter1;
        public static int counter2;
        public static int counter3;

        public int counter4;
        public int counter5;

     public static synchronized void increment1()               //Method & class level synchronisation.
     {
        counter1++;
     }

     public static synchronized void increment2()
     {
        counter2++;
     }

     public synchronized void  increment4()
     {
       counter4++;
     }

     public void objectProcessing()
     {
         Thread t4 = new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<100000;i++)
                {
                    increment4();                           //Object & Method Level Synchronisation
                }
            }
        });

        Thread t5 = new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<100000;i++)
                { 
                   synchronized(this)                 //Object & Block Level Synchronisation
                    {
                        counter5++;
                    }
                }
            }
        });

        


        t4.start();
        t5.start();

        try{
            t4.join();
            t5.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Value of counter4 "+ counter4);
         System.out.println("Value of counter5 "+ counter5);
     }
    public static void process()
    {
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<100000;i++)
                {
                    increment1();
                }
            }
        });


        Thread t2 = new Thread(new Runnable()
        {
            public void run()
            {  
                
                  for(int i=0;i<100000;i++)
                {
                     increment2();
                }
                
                
               
            }
        });

        Thread t3 = new Thread(new Runnable()
        { 
             public void run()
            {  
                  for(int i=0;i<100000;i++)
                { 
                    synchronized(Monitor.class)            //AS we using class level synchronisation
                    {
                        counter3++;
                    }
                }  
            }

        });


        t1.start();
        t2.start();
        t3.start();

        try
        {
            t1.join();
            t2.join();
            t3.join();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Value of counter1 "+counter1);
         System.out.println("Value of counter2 "+counter2);
         System.out.println("Value of counter3 "+counter3);
    }
    public static void main(String[]args)
    {
         Monitor.process();

         Monitor obj = new Monitor();
         obj.objectProcessing();

    }
}
