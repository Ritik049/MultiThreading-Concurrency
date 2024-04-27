public class WithoutSynchronisation
{
    public static int counter;

    public static void process()
    {
        Thread t1 = new Thread(new Runnable()
        {
            public void run()
            {
                for(int i=0;i<100000;i++)
                {
                    counter++;
                }
            }
        });


        Thread t2 = new Thread(new Runnable()
        {
            public void run()
            {  
                
                  for(int i=0;i<100000;i++)
                {
                    counter++;
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

        WithoutSynchronisation.process();  //Counter value comes : 170144 or some different everytime
    }
}