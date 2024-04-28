import java.util.concurrent.Semaphore;
public class SemaphoreExample
{
    //Semaphore is a synchronisation primitive and allow access to shared resource through counter;
    //Binary semaphore also called mutex.
    //used when you need to limit the no. of threads accesing the shared resource at a time.

    //Semaphore maintain sets of permits
       //*****   -acquire():- if a permit is available then takes it.
       //***      - release().....adds a permit
       //Semaphore just keeps the count of  number of permits available.
       //new Semaphore(int permit,  boolean fairness);


   //For BinarySemaphore, we need to use just new Semaphore(1);

   //BinarySemaphore act as mutex, becuase it has only two states.

   //Semaphores does not have a concept of ownership**(MaIN differnCE than MUTEX) means any thread can release the semaphore, not just the one acquired it.
   //If we release before acquire,  then it just increment the count of  permits.

       private Semaphore  semaphore = new Semaphore(5);  //Giving connection of 5.

       public void useDatabase()
       {
           try{
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" is using the database...");
            //simulate database operations.
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" has finished...");
           }
           catch(InterruptedException e)
           {
            e.printStackTrace();
        
           }
           finally
           {
            semaphore.release();
           }
       }


       public static void main(String[]args)
       { 
          SemaphoreExample example = new SemaphoreExample();
              for(int i=0;i<20;i++)
              {
                Thread thread = new Thread(()->example.useDatabase(),"Thread- "+i);   //Lambda function
                thread.start();
              }
       }
}
