package src;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*System.in是字节流对象，代表键盘的输入，如果我们想按行接收用户的输入时，就必须用到缓冲字符流BufferedReader特有的方法Readline()，
但是经过观察就会发现BufferedReader的构造方法必须是一个Reader对象，这时候我们的转换流，InputStreamReader就派上用场了。
-----------------------------------------------------------------------
而System.out也是字节流对象，代表输出到显示器，按行读取用户的输入后，并且要将读取的一行字符，
*/
public class TestConvertStream {
    public static void main(String[]args){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            //使用字符输入输出流
            String str = br.readLine();//一只读取知道用户输入流exit
            while(!("exit".equals(str)))
            {
                bw.write(str);
                bw.newLine();
                bw.flush();
                str = br.readLine();
            }

        }catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            if (br!=null)
            {
                try {
                    br.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (bw!=null)
            {
                try {
                    bw.close();
                }catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
