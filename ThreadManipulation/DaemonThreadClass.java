public class DaemonThreadClass implements Runnable
{
   
   public void run()
   {
      while(true)
      { 
        try
        {  Thread.sleep(1000);
            System.out.println("Daemon thread is running");
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
      }
   }

}