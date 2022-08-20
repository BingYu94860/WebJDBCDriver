import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class TestMyAnnotation1{
    @SuppressWarnings ({"deprecation","unchecked","override"})
    @MyAnnotation(name="����method",urlPatterns={"fakeName","newValue"})
    //�M�g
    public void doSomething() {  
        // ....      
    }
    public static void main(String[] args) throws NoSuchMethodException{
        Class<TestMyAnnotation1> c = TestMyAnnotation1.class;

        // �]��MyAnnotation�Хܩ�doSomething()��k�W
        // �ҥH�n���odoSomething()��k��Method���
        Method method = c.getMethod("doSomething");

        // �p�GMyAnnotation�s�b����
        if(method.isAnnotationPresent(MyAnnotation.class)) {
            System.out.println("��� @MyAnnotation");
            // ���oMyAnnotation
            MyAnnotation annotation =  method.getAnnotation(MyAnnotation.class);
            // ���ourlPatterns������
            for(String v:annotation.urlPatterns())
                System.out.println("\turlPatterns = " + v);
            // ���oname������
            System.out.println("\tname = " + annotation.name());
        }else {
            System.out.println("�䤣�� @MyAnnotation");
        }

        // ���odoSomething()��k�W�Ҧ���Annotation
        Annotation[] annotations = method.getAnnotations();
        // ���Annotation�W��
        for(Annotation annotation : annotations) {
            System.out.println("Annotation�W�١G" + annotation.annotationType().getName());
        }
    }
}