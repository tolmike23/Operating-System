/**
 *
 * @author John Barraca & Louie Faundo
 * 
 * Main.java
 * 
 * The main bounded buffer is executed by initializing the producer and consumer threads 
 */
package assignment;
import java.util.ArrayList;
import java.util.List;

public class Main 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int runOrSleepTime = 10; //Initialize run and sleep time.
        int numProducer = 1;//Initialize how many producer.
        int numConsumer = 5;//Initialize how many consumer.
        long threadId = Thread.currentThread().getId();//Get thread Id.
         
         System.out.println("Buffer Size: " + Constants.BUFFER_SIZE);
         System.out.println("Producers: " + numProducer);
         System.out.println("Consumers: " + numConsumer);
         System.out.println("Main thread "+threadId + " will sleep for " + runOrSleepTime + " seconds upon awakening will terminate application" );   
            
         //instantiate (create) buffer shared by Producer & Consumer
         Buffer sharedBuffer = new Buffer();
         List <Thread> listProducer = new ArrayList<>();
         List <Thread> listCustomer = new ArrayList<>();
         
         //Create the producer and consumer threads
         for(int i=0; i<numConsumer; i++)
         {
             Thread threadCustomer = new Thread(new Consumer(sharedBuffer));
             threadCustomer.setName("Customer" + i);
             listCustomer.add(threadCustomer);
         }
         for(int i=0; i<numProducer; i++)
         {
            Thread threadProducer = new Thread(new Producer(sharedBuffer));
             threadProducer.setName("Producer" + i);
             listProducer.add(threadProducer);
         }
         
        //Start consumer and producer threads        
         for(int i=0;i<listCustomer.size();i++)
         {             
             listCustomer.get(i).start(); 
         }
         for(int i=0;i<listProducer.size();i++)
         {
             listProducer.get(i).start();          
         }
         
         //Sleep thread for 10 seconds
         Buffer.sleepThread();
         
         //Console out when main thread finishes and then terminate
        System.out.println("Application has finished executing for " + runOrSleepTime + " seconds.");
        System.exit(0);
    }
}
