package src;
import java.io.ByteArrayInputStream;
import java.io.IOException;
public class TestByteArray {
    public static void main(String[]args){
        byte[] b = "abcdefg".getBytes();
        test(b);
    }
    public static void test(byte[] b)
    {
        ByteArrayInputStream bais = null;
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        int num =0;
        try {
            bais = new ByteArrayInputStream(b);
            while ((temp=bais.read())!=-1)
            {
                sb.append((char)temp);
                num++;
            }
            System.out.println("打印字符数组:"+sb);
            System.out.println("读取的字节数："+num);
        }finally {
            try {
                if (bais!=null)
                    bais.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
