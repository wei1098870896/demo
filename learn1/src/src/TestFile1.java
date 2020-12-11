package src;

import java.io.File;
import java.util.Date;


/*java.io.File类，代表文件和目录，在开发中读取文件，生成文件，删除文件，修改文件的属性时经常会用到此类
* */
public class TestFile1 {
    public static void main(String[]args) throws Exception{
        System.out.println(System.getProperty("D:/ideaProjects/Project01/learn1"));
        File f1 =new File("aaa.txt");
        f1.createNewFile();
        File f2 =new File("D:/bbb.txt");
        f2.createNewFile();
        System.out.println("File是否存在:"+f2.exists());
        System.out.println("File是否是目录:"+f2.isDirectory());
        System.out.println("File是否是文件"+f2.isFile());
        System.out.println("File的最后修改时间"+ new Date(f2.lastModified()));
        System.out.println("File文件的大小"+f2.length());
        System.out.println("File文件名"+f2.getName());
        System.out.println("File文件的路径"+f2.getPath());
        System.out.println("File文件的路径"+f1.getPath());
        f1.delete();
        f2.delete();
        File f3 = new File("d:/电影/华语/大陆");
        boolean flag = f3.mkdir();
        System.out.println(flag);
        boolean flag1 = f3.mkdirs();
        System.out.println("mkdirs="+flag1);
    }
}
