public class VolatileKeyword
{
    private volatile counter;

    public void increment()
    {
        counter++;
    }
}

//Why fails in maintaining consistency.

//Now 2 thread can call increment same time and increment the value, and save that counter in main Memory now other thread fetches the counter from main Memory.

//Introduciing in mainMemory (like 2 thread incmrenet at same time  and put in main Memory )
//Suppose thread t1 --> 1 to 10 and thread t2-->1 to 10   =---> 20 (result)
//but at time of increment() race condition occurs and t1--> reach 5 and t2--> also reach 5 now, suppose value counter = 5, now again when it runs so atMost it can become 15 not 20.


//Thread.stop() method get deprecated, it used volatile keyword to fetch data from mainMemory.