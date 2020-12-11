import java.lang.reflect.Array;
import java.util.*;

/*Collection表示一组对象，它是集中，收集的意思。Collection接口的两个子接口是List，Set接口。
List是有序，可重复的容器。
* 有序:List中每个元素都有索引标记，可以根据索引标记访问元素，从而精确控制元素
* 可重复:List允许加入重复的元素，List容器通常允许满足e1.equals(e2)的元素重复加入容器。*/
public class ListTest {
    /*List接口常用的三个实现类,ArrayList，LinkedList，Vector*/
    public static void test01(){
        List list = new ArrayList<String>();
        System.out.println("list.isEmpty="+list.isEmpty());
        list.add("提莫");
        System.out.println("list.isEmpty="+list.isEmpty());
        list.add("盖伦");
        list.add("kate");
        System.out.println(list);
        System.out.println("list容器的大小:"+list.size());
        System.out.println("是否包含指定元素:"+list.contains("提莫"));
        System.out.println("是否包含指定元素:"+list.contains("艾希"));
        list.remove("kate");
        System.out.println(list);
        Object [] obj = list.toArray();
        System.out.println("容器转换成object数组:"+ Arrays.toString(obj));
        list.clear();
        System.out.println("清空所有容器中元素："+list);
    }
    /*两个list之间的元素操作*/
    public static void test2(){
        List<String> list1 = new ArrayList<String>();
        list1.add("瑞兹");
        list1.add("金克斯");
        list1.add("崔丝塔娜");
        List<String> list2 = new ArrayList<String>();
        list2.add("凯特琳");
        list2.add("薇恩");
        list2.add("金克斯");
        System.out.println("list1中是否包含list2中所有元素："+list1.containsAll(list2));
        System.out.println(list1);
        list1.addAll(list2);
        System.out.println(list1);
        list1.removeAll(list2);
        System.out.println(list1);
        list1.retainAll(list2);
        System.out.println(list1);
    }
    public static void main(String[]args){
        test01();
        test2();
    }
    /*ArrayList底层是用数组实现的存储。特点:查询效率高，增删效率低，线程不安全。
    * 使用object数组来存储元素数据，所有的方法，都围绕这个核心的object数组来展开。
    * 我们知道数组的长度是有限的，而ArrayList可以存放任意数量的对象，长度不受限制，那么他是怎么实现的呢，本质上是通过定义新的更大的数组，将旧数组中的内容拷贝到新数组中，来实现扩容的。*/
    /*LinkedList底层用双向链表实现的存储。特点：查询效率低，增删效率高，线程不安全。
    * 双向链表也叫双链表，是链表的一种，它的每个数据节点中都有两个指针，分别指向前一个节点和后一个节点。所以，从双向链表中的任意一个节点开始，都可以很方便的找到所有节点。*/
}
