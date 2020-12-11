package src;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/*Runnable接口里的run方法不能返回操作结果。congJDk1.5开始，
* Java提供了一个新的支持多线程实现的接口:java.util.concurrent.Callable*/
class CallableThread implements Callable<String>{
        private String name;
        private int tickets = 20;
        public CallableThread(String name){
            this.name = name;
        }
        @Override
        public String call() throws Exception{
            for(int i=0;i<100;i++)
                if(this.tickets>0)
                System.out.println(this.name+"剩余，ticket = "+ this.tickets--);
                return "票已售罄！";
        }
    }
public class TestCallable {
    public static void main(String[]args)throws Exception {
        CallableThread thread1 = new CallableThread("线程1");
        CallableThread thread2 = new CallableThread("线程2");
        CallableThread thread3 = new CallableThread("线程3");

        FutureTask<String> task1 = new FutureTask<String>(thread1);
        FutureTask<String> task2 = new FutureTask<String>(thread2);
        FutureTask<String> task3 = new FutureTask<String>(thread3);
        //FutureTask 是 Runnable 接口的子类，所以可以使用Thread类的构造来接收 task 对象
        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
        System.out.println("线程1的返回结果：" + task1.get());
        System.out.println("线程2的返回结果：" + task2.get());
        System.out.println("线程3的返回结果：" + task3.get());
    }
}
