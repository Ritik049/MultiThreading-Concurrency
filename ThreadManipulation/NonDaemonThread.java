public  class NonDaemonThread implements Runnable
{
      public void run()
      {
            try{
                Thread.sleep(3000);
                System.out.println("Normal Thread is running....");
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
         
      }
}