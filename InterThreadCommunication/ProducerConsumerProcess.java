public class ProducerConsumerProcess 
{
     public  void producer()
    {
        synchronized(this)
        {
            System.out.println("Producer method is executing ....");
            try
           { wait();}
           catch(InterruptedException e)
           {
            e.printStackTrace();
           }
            System.out.println("Producer method again starts....");
        }
    }

    public   void consumer()
    {
        synchronized(this)
        {
            System.out.println("Consumer method is executing");
            notify();
            System.out.println("Notify does not call immediately,first it  complete its execution then another thread comes");
        }
    }
}