import java.io.*;
import java.util.*;
import java.net.*;
public class SocketTest {
    public static void main(String[]args){
        try {
            Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13);
            //Socket(String host,int port)
            //创建一个套接字，用来连接给定的主机和端口。
            //InputStream getInputStream()
            //OutputStrean getOutputStream()  获取可以从套接字中读取数据的流，以及可以向套接字写出数据的流。
            try {
                InputStream inStream = s.getInputStream();
                Scanner in = new Scanner(inStream);
                while (in.hasNextLine()){
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }
            finally {
                s.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
