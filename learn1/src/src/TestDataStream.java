package src;
/*数据流将基本数据类型和字符串类型作为数据源，从而允许程序以与机器无关的方式从底层输入输出流中操作java基本数据类型和字符串类型*/
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
public class TestDataStream {
    public static void main(String[]args)
    {
        DataOutputStream dos = null;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("D:/test.txt");
            fis = new FileInputStream("D:/test.txt");
            //
            dos = new DataOutputStream(new BufferedOutputStream(fos));
            dis = new DataInputStream(new BufferedInputStream(fis));
            dos.writeChar('A');
            dos.writeInt(10);
            dos.writeDouble(3.1415926);
            dos.writeBoolean(true);
            dos.writeUTF("朝花夕拾杯中酒");
            dos.flush();
            System.out.println("char:"+dis.readChar());
            System.out.println("Int:"+dis.readInt());
            System.out.println("Double"+dis.readDouble());
            System.out.println("Boolean"+dis.readBoolean());
            System.out.println("UTF:"+dis.readUTF());
        }catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            try {
                if (fis!=null)
                    fis.close();
            }catch (IOException e){
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
                if (dis!=null)
                    dis.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            try {
                if (dos!=null)
                    dos.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
