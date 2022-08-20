class MyClass{
    @Deprecated//宣告過期最好不要使用
    void fun(){
        System.out.println("一開始正常使用,未來會廢棄的方法");
    }
}

class TestDeprecated1{
    public static void main(String[] args){
        MyClass obj1=new MyClass();
        obj1.fun();
    }
}