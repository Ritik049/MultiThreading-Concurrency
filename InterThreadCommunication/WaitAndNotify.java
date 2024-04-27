
//WAIt and nofity are not static methods,they cant be reference from static context.
//Wait is is used to release the acquired intrinsic lock and notify is used to notify all the threads in waiting state.
//After calling notify , another waiting threads does not do its immediate execution, firstly the thread that calls notify first executes itself.

public class WaitAndNotify
{

    public static void main(String[]args)
    {  
          ProducerConsumerProcess process = new ProducerConsumerProcess();

           Thread producerThread = new Thread(new Runnable()
           {
            public void run()
            {
               process.producer();

            }
           });

           Thread consumerThread = new Thread(new Runnable()
           {
            public void run()
            {
                process.consumer();
            }
           }
           );

           Thread normalThread = new Thread(new Runnable()
           {
            public void run()
            {
                System.out.println("Normal thread is running...");
            }
           });

           producerThread.start();
           consumerThread.start();
           normalThread.start();


           try
           {
            producerThread.join();
            consumerThread.join();
            normalThread.join();
           }
           catch(InterruptedException e)
           {
            e.printStackTrace();
           }
    }
}