/*将文件中的内容读入到程序里*/
package src;
import java.io.*;
public class TestIO {
    public static void main(String[]args)
    {
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("D:/adc.txt");
            StringBuilder stemp = new StringBuilder();
            int temp = 0;
            while((temp=(fis.read()))!=-1){
                stemp.append((char)temp);
            }
            System.out.println(stemp);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fis!=null)
                    fis.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
