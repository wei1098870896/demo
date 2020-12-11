import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class TestThreadPool {
    private static int POL_NUM=10;
    public static void main(String[]args) throws InterruptedException
    {
        ExecutorService  exeser = Executors.newFixedThreadPool(5);
        for(int i =0;i<POL_NUM;i++)
        {
            ThreadPool threadpool = new ThreadPool();
            Thread.sleep(1000);
            exeser.execute(threadpool);
        }
        exeser.shutdown();
    }
}

class ThreadPool implements Runnable{
    public void run(){
        System.out.println("通过线程池方法创建的线程:  "+ Thread.currentThread().getName()+"  ");
    }
}
