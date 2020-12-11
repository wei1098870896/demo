import java.io.File;
import java.io.IOException;
public class TestFile2 {
    public static void main(String[]args){
        File file = new File("d:/cbps8/aaa.txt");
        boolean flag = file.exists();//判断该文件是否存在
        if(flag){
            boolean flagd= file.delete();
            if(flagd){
                System.out.println("删除成功!");
            }else{
                System.out.println("删除失败!");
            }
        }else{
            //不存在就创建
            boolean flagn = true;
            try{
                //如果目录不存在，就先创建目录
                File dir = file.getParentFile();
                dir.mkdirs();
                //创建文件
                flagn = file.createNewFile();
                System.out.println("创建成功!");
            }catch(IOException e){
                System.out.println("创建失败!");
                e.printStackTrace();
            }
        }
        //file.renameTo(new File("d:/cbps8/bbb.txt"));
    }
}
