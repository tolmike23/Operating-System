/**
 *
 * @author John Barraca & Louie Faundo
 * 
 * Consumer.java
 * 
 * Consumer class that implements the consumer thread for the bounded buffer problem.
 */
package assignment;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable
{
    private Buffer buffer;
    
    public Consumer(Buffer buf)
    {
        buffer = buf;
    }
    
       public void run()
       {
         Object message = null;
         
            while (true)
            {
                try 
                {
                    long threadID = Thread.currentThread().getId();
                    System.out.println("Consumer " + threadID + " wants to consume.");
                    //Sleep consumer
                    Buffer.sleepThread();
                    // consume an item from the buffer
                    message = buffer.remove();
                    System.out.println("Consumer " + threadID + " consumed \"" + message + "\"");
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
}