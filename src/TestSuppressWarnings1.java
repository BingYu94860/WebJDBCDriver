import java.util.*;
class MyClass{
    @Deprecated   //�ŧi�L���̦n���n�ϥ�
    void fun(){
        System.out.println("�@�}�l���`�ϥ�,���ӷ|�o�󪺤�k");
    }
}

class TestSuppressWarnings1{
    @SuppressWarnings("deprecation")
    public static void main(String[] args){
        Date date=new Date(2000,1,9);//�Ч��Calendar
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
�����u���@�ӿﶵ XML
ANNOTATION ���NXML
*/