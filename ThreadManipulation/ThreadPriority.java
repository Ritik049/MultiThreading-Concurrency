//By using thread priority we can set the thread priority, which is in range of min_priority and max_priority. (1 to 10);
//By deafault all threads have priority 5.

//but order of executions depends on underlying OS

public class ThreadPriority
{
    public static void main(String[]args)
    {
       System.out.println(Thread.currentThread().getName());
       Thread.currentThread().setPriority(10);
       System.out.println(Thread.currentThread().getPriority());
    }
}

//It is not necessary that higherPriority runs first, lowerPriority may run fast.