/**
 *
 * @author John Barraca & Louie Faundo
 * 
 * Producer.java
 * 
 * Producer class that implements the producer thread for the bounded buffer problem.
 */
package assignment;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable 
{  
    private Buffer buffer;
    
    public Producer(Buffer buf)
    {
        buffer = buf;
    }
    
    public void run()
    {
         while (true) 
         {
             try 
             {
                 long threadID = Thread.currentThread().getId();
                 //Sleep Producer
                 Buffer.sleepThread();
                 
                 // item will be a randomly generated number
                 Random randomGen = new Random();
                 int numGen = randomGen.nextInt(100);
                 //Producer will produce the item and place into buffer
                 System.out.println("Producer " + threadID + " produced \"" + numGen + "\"");
                 buffer.insert_item(numGen);
             } 
             catch (InterruptedException ex) 
             {
                 Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }
}
