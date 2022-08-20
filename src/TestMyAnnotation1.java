import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class TestMyAnnotation1{
    @SuppressWarnings ({"deprecation","unchecked","override"})
    @MyAnnotation(name="測試method",urlPatterns={"fakeName","newValue"})
    //映射
    public void doSomething() {  
        // ....      
    }
    public static void main(String[] args) throws NoSuchMethodException{
        Class<TestMyAnnotation1> c = TestMyAnnotation1.class;

        // 因為MyAnnotation標示於doSomething()方法上
        // 所以要取得doSomething()方法的Method實例
        Method method = c.getMethod("doSomething");

        // 如果MyAnnotation存在的話
        if(method.isAnnotationPresent(MyAnnotation.class)) {
            System.out.println("找到 @MyAnnotation");
            // 取得MyAnnotation
            MyAnnotation annotation =  method.getAnnotation(MyAnnotation.class);
            // 取得urlPatterns成員值
            for(String v:annotation.urlPatterns())
                System.out.println("\turlPatterns = " + v);
            // 取得name成員值
            System.out.println("\tname = " + annotation.name());
        }else {
            System.out.println("找不到 @MyAnnotation");
        }

        // 取得doSomething()方法上所有的Annotation
        Annotation[] annotations = method.getAnnotations();
        // 顯示Annotation名稱
        for(Annotation annotation : annotations) {
            System.out.println("Annotation名稱：" + annotation.annotationType().getName());
        }
    }
}