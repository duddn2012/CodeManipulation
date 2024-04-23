package dicontainer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import spring.di.BookRepository;

public class ContainerService {

    public static <T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f->{
            if(f.getAnnotation(Inject.class) != null){
                Object fieldInstance = createInstance(f.getType());
                f.setAccessible(true);
                try {
                    f.set(instance, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return instance;
    }

    public static <T> T createInstance(Class<T> aClass) {
        try {
            return aClass.getConstructor(null).newInstance(null);
        } catch (InvocationTargetException | NoSuchMethodException |
                 InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
