package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App {

    public static void main(String[] args)
        throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Book> bookClass = Book.class;//JVM 실행 시 클래스 로더가 자바 클래스 파일들을 읽어서 .class 인스턴스를 힙 메모리 영역에 넣어준다.

        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        Class<?> aClass1 = Class.forName("reflection.Book");
        Constructor<?> constructor = aClass1.getConstructor(String.class, String.class, String.class);
        Book bookInst = (Book) constructor.newInstance("myBook", "b2", "b3");
        System.out.println(bookInst);

        Field a1 = Book.class.getDeclaredField("B");
        a1.setAccessible(true); //private 허용
        System.out.println(a1.get(null));

        Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) sum.invoke(book, 1, 2);
        System.out.println(invoke);

        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(a->{
                if(a instanceof MyAnnotation){
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println(myAnnotation.value());
                    System.out.println(myAnnotation.name());
                }
            });
        });

        Arrays.stream(bookClass.getAnnotations()).forEach(System.out::println);
    }
}
