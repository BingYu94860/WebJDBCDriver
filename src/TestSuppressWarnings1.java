import java.util.*;
class MyClass{
    @Deprecated   //宣告過期最好不要使用
    void fun(){
        System.out.println("一開始正常使用,未來會廢棄的方法");
    }
}

class TestSuppressWarnings1{
    @SuppressWarnings("deprecation")
    public static void main(String[] args){
        Date date=new Date(2000,1,9);//請改用Calendar
        System.out.println(date);
        MyClass obj1=new MyClass();
        obj1.fun();
    }
    @SuppressWarnings("deprecation")
    void testFun(){
        MyClass obj1=new MyClass();
        obj1.fun();
    }
}
/*
java server page & servlet 
AP server
早期只有一個選項 XML
ANNOTATION 取代XML
*/