import javax.management.InvalidApplicationException;
import java.io.IOException;
import java.net.*;
public class InetAdressTest {
    public static void main(String[]args){
        try {
            if(args.length>0) {
                String host = args[0];
                InetAddress[] address = InetAddress.getAllByName(host);
                for (InetAddress a : address) {
                    System.out.println(a);
                }
            }
                else
                {
                    InetAddress localHostAddress = InetAddress.getLocalHost();
                    System.out.println(localHostAddress);
                }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
/*
ORM（Object Relational Mapping）框架采用元数据来描述对象与关系映射的细节，元数据一般采用XML格式，
        并且存放在专门的对象一映射文件中。简单理解为一种框架的格式
        只要提供了持久化类与表的映射关系，ORM框架在运行时就能参照映射文件的信息，把对象持久化到数据库中。当前ORM框架主要有五种：Hibernate(Nhibernate)，iBATIS，mybatis，EclipseLink，JFinal。
        ORM是通过使用描述对象和数据库之间映射的元数据,在我们想到描述的时候自然就想到了xml和特性(Attribute).目前的ORM框架中,Hibernate就是典型的使用xml文件作为描述实体对象的映射框架,而大名鼎鼎的Linq则是使用特性(Attribute)来描述的
 */