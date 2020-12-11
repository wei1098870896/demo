import com.sun.jdi.ObjectReference;

import javax.swing.plaf.synth.SynthCheckBoxMenuItemUI;
import java.util.concurrent.locks.Lock;


public class TestSynch {
    private static int count = 0;
    private static Object lock = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) throws InterruptedException{
        Thread th1 = new Thread(() ->{
            for(int i = 0;i<500;i++)
            {
                synchronized (lock){
                    count++;
                }
            }
            System.out.println("count的值:"+count);
        });
        Thread th2 = new Thread(() ->{
           for(int i =0;i<500;i++)
           {
               synchronized (lock){
                   count--;
               }
           }
           System.out.println("count的值:"+count);
        });
       th1.start();
       th2.start();
       th1.join();
       th2.join();
    }
}

/********************************************************/
