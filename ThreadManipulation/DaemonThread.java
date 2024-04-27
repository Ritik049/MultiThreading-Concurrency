//Thread that run along with woker thread  and act as helper Thread  //EX: GARBAGE COLLECTION
//Main thread first start executing and finish in last as it need to perform various shutDown operations.
//Daemon thread get terminated when all non Daemon thread finish its execution

import java.util.*;
public class DaemonThread
{
    public static void main(String[]args)
    {
        //System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(new DaemonThreadClass());
        Thread t2 = new Thread(new NonDaemonThread());

        t1.setDaemon(true);          //by using this thread is set as Daemon;

        t1.start();
        t2.start();  //when execution of t2 stops, and all other threads will stop, so t1(daemon is also get stop ) and finish execution.
    }
}