/*String类的对象代表不可变的Unicode字符序列，因此我们将string对象称为不可变对象。
* 不可变对象指的是，对象内部的成员成员变量的值无法再改变。
* private final char value[];String类的字符串内容全部保存再数组value中，而变量value是final类型的，就是常量(只能被赋值一次)*/
public class TestString {
    public static void main(String []args) {
        String s1 = new String("abcdef");
        String s2 = s1.substring(2, 4);
        System.out.println("s1=" + s1);
        System.out.println("S2=" + s2);
        //java.lang.Integer.toHexString() 方法返回为无符号整数基数为16的整数参数的字符串表示形式。
        System.out.println(Integer.toHexString(s1.hashCode()));
        System.out.println(Integer.toHexString(s2.hashCode()));
        //字符串常量拼接时的优化
        String s3 ="java"+ " hello";
        String s4 ="java hello";
        String s5 ="java";
        String s6 =" hello";
        String s7 = s5 + s6;
        System.out.println(s3==s4);
        System.out.println(s3.equals(s7));
    }
}
