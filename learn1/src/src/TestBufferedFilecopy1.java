package src;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
/*使用缓冲流实现文件的高效复制
*  Java缓冲流本身并不具有IO流的读取与写入功能，只是在别的流(节点流或其他处理流)上加上缓冲功能提高效率，就像是把别的流包装起来一样，因此缓冲流是一种处理流(包装流)。
* 当对文件或者其他数据源进行频繁的读写操作时，效率比较低，这时如果使用缓冲流就能够更高效的读写信息。因为缓冲流是先将数据缓存起来，然后当缓存区存满后或者手动刷新时再一次性的读取到程序或写入目的地。*/
public class TestBufferedFilecopy1 {
    public static void main(String[]args)
    {
        long time1 = System.currentTimeMillis();
        copyFile2("D:/电影/华语/大陆/天坛公园.mp4","D:/电影/华语/大陆/朝花夕拾.mp4");
        long time2 = System.currentTimeMillis();
        System.out.println("普通字节流复制视频花费时间:"+(time2-time1));
        long time3 = System.currentTimeMillis();
        BufferedFilecopy("D:/电影/华语/大陆/天坛公园.mp4","D:/电影/华语/大陆/朝花夕拾2.mp4");
        long time4 = System.currentTimeMillis();
        System.out.println("缓冲字节流复制视频花费时间:"+(time4-time3));
    }
    static void BufferedFilecopy(String src,String dec)
    {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        int temp =0;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dec);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //使用缓冲字节流包装文件字节流，增加缓冲功能，提高效率。缓冲区的大小默认是8192，也可以自己指定
            while((temp=bis.read())!=-1)
                bos.write(temp);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            try {
                if (bos!=null)
                    bos.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            try {
                if (bis!=null)
                    bis.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            try {
                if (fos!=null)
                    fos.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            try {
                if (fis!=null)
                    fis.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*普通文件字节流复制文件*/
    static void copyFile2(String src,String dec)
    {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        int temp = 0;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dec);
            while ((temp = fis.read()) != -1)
                fos.write(temp);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fos!=null)
                    fos.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            try {
                if(fis!=null)
                    fis.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    /*缓冲字符流复制文件*/
    static void Bufferedercopy(String src,String dec)
    {
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        String tempString = "";
        try {
            fr = new FileReader(src);
            fw = new FileWriter(dec);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            while ((tempString = br.readLine())!=null)
            {
                bw.write(tempString);
                bw.newLine();
            }
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                if (bw!=null)
                    bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (br!=null)
                    br.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            try {
                if (fw!=null)
                {
                    fw.close();
                }
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            try {
                if(fr!=null)
                    fr.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }

        }

    }
}
