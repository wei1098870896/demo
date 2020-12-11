package src;
import java.io.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/*ObjectInputStream/ObjectOutputStream 是以对象为数据源，但是必须将传输的对象进行序列化和反序列化操作。*/
public class TestObjectStream {
    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
        write();
        read();
    }
    /*使用对象输出流将数据写入文件*/
    public static void write()
    {
        //创建Object输出流，并包装缓冲流，增加缓冲功能
        OutputStream os = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            os = new FileOutputStream(new File("D:/11-11.txt"));
            bos = new BufferedOutputStream(os);
            oos = new ObjectOutputStream(bos);
            //使用Object输出流
            //对象流也可以对基本数据类型进行读写操作
            oos.writeInt(11);
            oos.writeChar('A');
            oos.writeBoolean(true);
            oos.writeDouble(3.1415926);
            oos.writeUTF("双十一购物节拉开帷幕！");
            oos.writeObject(new Date());
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            if (oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void read()
    {
        InputStream is = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            is = new FileInputStream(new File("D:/11-11.txt"));
            bis = new BufferedInputStream(is);
            ois = new ObjectInputStream(bis);

            //使用Object输入流按照写入顺序读取内容
            System.out.println("Int:"+ois.readInt());
            System.out.println("Char:"+ois.readChar());
            System.out.println("Boolean:"+ois.readBoolean());
            System.out.println("Double:"+ois.readDouble());
            System.out.println("UTF:"+ois.readUTF());
            System.out.println(ois.readObject().toString());

        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/*
* */