import java.io.*;
/*
* */
public class FindDirectories
{
    public static void main(String[]args)
    {
        //if no arguments provided,start at the parent directory
        if(args.length==0)
            args = new String[] {".."};
        try{
            File pathName = new File(args[0]);
            String [] fileNames = pathName.list();
            //enumerate all files in the directory
            for(int i = 0;i< fileNames.length;i++)
            {
                File f = new File(pathName.getPath(),fileNames[i]);
                //if the file is again a directory,call the main method recursively

                if(f.isDirectory())
                {
                    System.out.println("["+f.getCanonicalPath()+"]");
                    main(new String[] {f.getPath()});
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
/*文件加锁机制
* 假设你的应用将用户的偏好存储在一个配置文件中，当用户调用这个应用的两个实例时，这两个实例就有可能会同时希望写这个配置文件。
* 在这种情况下，第一个实例应该锁定这个文件，第二个实例发现这个文件被锁定时，他必须决策是等待直至这个文件被解锁，还是直接跳过这个写操作过程。*/
/*要锁定一个文件。可以调用FileChannel类的lock或tryLock方法:
* FileLock lock = channel.lock();
* 或
* FileLock lock = channel.tryLock();
* 你还可以通过下面的调用锁定文件的一部分
* FileLock lock(long start ,long size, boolean exclusive)
* 或者
* FileLock tryLock(long start, long size, boolean exclusive)
* 如果exclusive标识的值为true，则锁定文件的目的是读写。而如果是false，则这是一个共享锁，它允许多个进程从文件读入，并阻止任何进程获得独占的锁。*/
/*void release()
* 释放这个锁*/
