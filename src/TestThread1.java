class TestThread1 extends Thread{
  String name;
  TestThread1(String name){
    this.name=name;
  }
  int i=0;
  public void run(){
     while(i<100){
        System.out.println(name+"==>"+i);
        ++i;
     }
  }
  public static void main(String[] args){
    TestThread1 t1=new TestThread1("obj1");
    TestThread1 t2=new TestThread1("obj2");
    t1.start();
    t2.start();
  }
}