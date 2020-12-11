import java.io.File;

/*java.io.File类，代表文件和目录，在开发中读取文件，生成文件，删除文件，修改文件的属性时经常会用到此类
* */
public class TestFile1 {
    public static void main(String[]args) throws Exception{
        System.out.println(System.getProperty("D:/ideaProjects/Project01/learn1"));
        /*File f1 =new File("aaa.txt");
        f1.createNewFile();
        File f2 =new File("D:/bbb.txt");
        f2.createNewFile();*/

        File f3 = new File("afilethatprobablydoesntexist");
        System.out.println(f3.getAbsolutePath());
        System.out.println(f3.exists());
    }
}
