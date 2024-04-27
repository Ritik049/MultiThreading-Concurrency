//Synchorisation is used to maintain data consistency.
//Synchronisation is used to block one thread while one thread is getting executed
//Synchronisation two types: class level, object level 
//Class Level we use static method and use synchronized(className.class)
//Object level we need not to use static method, and use synchronized(this)

//Every class has intrinsic lock when we use synchronised keyword, so  it means only a single thread can acquire that lock.


//Method level Synchronisation is used at directly methods.
//Block level synchronisation is used on a particular part of code.

public class Synchronisation{

     public static int counter;

     public static synchronized void increment()               //Method & class level synchronisation.
     {
        counter++; 
     }

    public static void process()
    {
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<100000;i++)
                {
                    increment();
                }
            }
        });


        Thread t2 = new Thread(new Runnable()
        {
            public void run()
            {  
                
                  for(int i=0;i<100000;i++)
                {
                     increment();
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

        System.out.println("Value of counter "+counter);
    }
    public static void main(String[]args)
    {
         Synchronisation.process();

    }
}