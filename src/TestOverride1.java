/*
java 程式說明文件
comment
註解:單行註解  
     多行註解 
     文件註解 
annotation
註解:
RetentionPolicy
       SOURCE ,CLASS ,RUNTIME 
Target 
       

一個ANNOTATION  對應一個  RetentionPolicy     
                可對應多個TARGET
Deprecated 
Override
SuppressWarrings
               
*/
class SuperClass{
    void fun(){
        System.out.println("父類別成員方法");
    }
}
class SubClass extends SuperClass{
    @Override
    void fun(){// 不是 override
        System.out.println("子類別覆寫父類別同名成員方法");
    }
}
class TestOverride1{
    public static void main(String[] args){
    
        SubClass s1=new SubClass();
        //s1.Fun();
        s1.fun();
    }
}
