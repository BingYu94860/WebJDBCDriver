class MyClass{
    @Deprecated//�ŧi�L���̦n���n�ϥ�
    void fun(){
        System.out.println("�@�}�l���`�ϥ�,���ӷ|�o�󪺤�k");
    }
}

class TestDeprecated1{
    public static void main(String[] args){
        MyClass obj1=new MyClass();
        obj1.fun();
    }
}