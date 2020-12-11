package src;

/*StringBuffer 和 StringBuilder
* 均代表可变字符序列。这两个类都是抽象类AbstractStringBuilder的子类。
* 区别：
*  1. StringBuffer JDK1.0版本提供的类，线程安全，做线程同步检查， 效率较低。
   2. StringBuilder JDK1.5版本提供的类，线程不安全，不做线程同步检查，因此效率较高。建议采用该类。*/
public class TestString2 {
    public static void main(String []args){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<7;i++){
            sb.append((char)('a'+i));//追加单个字符
        }
        System.out.println(sb.toString());//转换成String输出
        sb.append("，I can say my abc!");
        System.out.println(sb.toString());
        /**********************************************/
        StringBuffer sb2 = new StringBuffer("中华人民共和国");
        sb2.insert(0,"爱").insert(0,"我");//插入字符串
        System.out.println(sb2);
        System.out.println(sb2.reverse());
        System.out.println(sb2.charAt(0));
        System.out.println(sb2.charAt(1));
        System.out.println(sb2.reverse());
        sb2.delete(0,2);
        System.out.println(sb2);
        sb2.deleteCharAt(0).deleteCharAt(0);
        System.out.println(sb2);
        TestString2 ts2 = new TestString2();
        ts2.testeffect();
        ts2.testeffect2(5000);

    }
    public static void testeffect(){
        /*使用String进行拼接*/
        String str ="";
        /*本质上使用StringBuilder进行拼接，但是每次循环都会生成一个StringBuilder对象*/
        long num1 = Runtime.getRuntime().freeMemory();
        long time1 = System.currentTimeMillis();
        for(int j =0;j<5000;j++){
            str = str + j;//相当于产生一万个对象
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("String拼接占用内存:"+(num1-num2));
        System.out.println("String拼接占用时间:"+(time2-time1));
    }
    public static void testeffect2(long max){
        StringBuilder stb = new StringBuilder("");
        long num1 = Runtime.getRuntime().freeMemory();
        long time1 = System.currentTimeMillis();
        for(int i=0;i<max;i++){
            stb.append(i);
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("StringBulider占用内存:"+(num1-num2));
        System.out.println("StringBuilder占用时间:"+(time2-time1));

    }
}
/*String一经初始化后就不会再改变其内容了。对String字符串的操作实际上是对其副本的操作（原始拷贝），原来的字符串一点儿也没有改变。
* 比如，String a = "abc";创建了一个字符串
* a = a+"efg";实际上原来的"abc"字符串已经丢弃了,现在又产生了另一个字符串a+"efg",(也就是"abcefg")。
* 如果多次执行这些改变字符串内容的操作，会导致大量副本字符串对象存留在内存中，降低效率。如果这样的操作放到循环中，会极大影响程序的时间和空间性能，甚至会造成副武器的崩溃。
* StringBuilder 和 StringBuffer是对源字符串本身进行操作的，可以对字符串进行修改，而不产生副本拷贝或少产生，因此可以在循环中使用。*/

