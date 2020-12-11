package src;
import com.sun.source.tree.CatchTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/*将程序中的内容写出到文件内*/
public class TestIO2 {
    public static void main(String[]args){
        FileOutputStream fos = null;
        String str = "G2完胜GenG，3:0挺近半决赛！";
        try{
            fos = new FileOutputStream("D:/lol.txt",true);
            /*true表示内容会追加到文件末尾，false表示重写整个文件内容*/
            fos.write(str.getBytes());
            /*该方法是直接将一个字节数组写入文件中，而write(int n )是写入一个字节*/
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            try{
                if(fos!=null)
                    fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        copyFile("D:/lol.txt","D:/G2.txt");
    }


    /*********************************************************************/
    /*利用文件流实现文件的复制*/
    /*将src文件的内容拷贝到dec*/
    /*functionI 文件字节流*/
    static void copyFile(String src,String dec){
        FileOutputStream os = null;
        FileInputStream is = null;
        //为了提高效率设置缓存数组
        byte[] buff = new byte[1024];
        int temp = 0;
        try{
            is = new FileInputStream(src);
            os = new FileOutputStream(dec);
            //边读边写
            //temp指的是本次读取的真实长度，temp等于-1是表示读取结束
            while((temp=is.read(buff))!=-1) {
                os.write(buff, 0, temp);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            try {
                if (os!=null)
                    os.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            try {
                if (is!=null)
                    is.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    /*文件字符流*/

}
/*使用到一个write()方法，void write(byte[] b)，该方法不在一个字节一个字节的写入，而是直接写入一个字节数组；
* 另外该方法还有一个重载方法write(byte[] b,int off,int length)，
* 该方法也是写入一个字节数组，可以指定从字节数组的哪个位置开始写，写入长度是多少。
*
* 永遇乐·京口北固亭怀古 .辛弃疾

千古江山，英雄无觅，孙仲谋处。舞榭歌台，风流总被雨打风吹去。斜阳草树，寻常巷陌，人道寄奴曾住。想当年，金戈铁马，气吞万里如虎。

元嘉草草，封狼居胥，赢得仓皇北顾。四十三年，望中犹记，烽火扬州路。可堪回首，佛狸祠下，一片神鸦社鼓。凭谁问，廉颇老矣，尚能饭否？*/
/*文件字符流*/
