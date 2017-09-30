/**
 *
 * @author John Barraca & Louie Faundo
 * 
 * Buffer.java
 * This class implements bounded buffer with insert() and remove() method for a shared memory.
 * Class Constant() is to initialized a fixed buffer array and a fixed sleep time for the buffer.
 */
package assignment;
import java.util.concurrent.Semaphore;

public class Buffer 
{
    //Synchronization Techniques using semaphore
    private final Semaphore  empty;    //keep track of the number of empty elements in the array
    private final Semaphore full;         //keep track of number of filled elements in the array.
    private final Semaphore mutex;     //provide limited access to the buffer (mutual exclusion)
    
    //Intialized array of buffer object with referee to first position entry and next free position and a counter.
    private final Object[] buffer;
    private int count; 
    private int in;
    private int out;
    
    
    
    //Constructor Buffer
    public Buffer()
    {
        //buffer is initially empty
        count = 0;
        in = 0;
        out = 0;
        buffer = new Object[Constants.BUFFER_SIZE];
        //Semaphore technique using mutex, empty, and full
        mutex = new Semaphore (1);//for mutual exclusion
        empty = new Semaphore (Constants.BUFFER_SIZE); //first pointer position of the array  with an empty elements
        full = new Semaphore (0); 
    }
    
    //Producer calls this method
    public void insert_item(Object item) throws InterruptedException
    {   
        //This provides synchronization for the producer,
        //because this makes the producer stop running when buffer is full
        try
        {    
            empty.acquire(); //keep track of number of empty elements (value--)
            mutex.acquire(); //mutual exclusion
         }
         catch (InterruptedException e) 
         { 
             System.out.println("ERROR in insert(): " + e);
         } 
        
         // add an item to the buffer
         ++count;
         buffer[in] = item;
         
         //modulus (%) is the remainder of a division
         in = (in + 1) % Constants.BUFFER_SIZE; 
         
         //buffer information feedback
         long threadID = Thread.currentThread().getId();
         if (count == Constants.BUFFER_SIZE)
         {
            System.out.println("Producer " + threadID + " inserted \"" + item + " \" BUFFER FULL count = " + count  + "." );
         }
         else
         {
            System.out.println("Producer "  + threadID + " inserted \"" + item + "\" count = " + count );
         }
         //If buffer was empty, then this wakes up the Consumer
         mutex.release(); //mutual exclusion
         full.release(); //keep track of number of elements (value++)
    }
    
    //Consumer calls this method
    public Object remove() throws InterruptedException 
    {
       Object item=null;   
        //This provides synchronization for consumer, 
        //because this makes the Consumer stop running when buffer is empty
         try
         {
            full.acquire(); //keep track of number of elements (value--)
            mutex.acquire(); //mutual exclusion
         }
         catch (InterruptedException e) 
         { 
            System.out.println("ERROR in try(): " + e);
         } 	
         // remove an item from the buffer
         --count;
         item = buffer[out];
        //modulus (%) is the remainder of a division
        //for example, 0%3=0, 1%3=1, 2%3=2, 3%3=0, 4%3=1, 5%3=2   
         out = (out + 1) % Constants.BUFFER_SIZE;
        //buffer information feedback
        long threadID = Thread.currentThread().getId();
         if (count == 0)
         {
            System.out.println("Consumer " + threadID + " removed \"" + item + "\". BUFFER EMPTY  count =  " + count);
         }
         else
         {
            System.out.println("Consumer " + threadID + " removed \"" + item + "\" count = " + count);
         }
         //if buffer was full, then this wakes up the Producer 
         mutex.release(); //mutual exclusion
         empty.release(); //keep track of number of empty elements (value++)      	  
         return item; 
    }
    
    
    
        //Threads calls this method to sleep in a specified fixed variable in the Constants class.
        public static void sleepThread()
        {
            //Put thread to sleep for in seconds counter
            int sleepTime = (int) (Constants.SLEEP_TIME * Math.random() );
            try
            {
               // thread to sleep for 1000 milliseconds
               Thread.sleep(sleepTime * 1000);
            } 
            catch (Exception e) 
            {
               System.out.println(e);
            }
        }
         
       
 } 

//Fixed Constant Variables
class Constants
{
    public  static int BUFFER_SIZE = 5;//max size of a buffer array
    public  static int SLEEP_TIME = 10; //max sleep time in seconds
}