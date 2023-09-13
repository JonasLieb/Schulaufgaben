package ls11.aufgaben.mitarbeitergui.util.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public class EmployeeDialogCreatableUtils {
    public static Constructor<?> getFirstConstructorWithAnnotation(Class<?> clazz) {
        return Arrays.stream(clazz.getConstructors()).filter(c -> {
            Annotation[] annotations = c.getAnnotations();
            for (Annotation annotation : annotations) if (annotation instanceof EmployeeDialogCreatable) return true;
            return false;
        }).findFirst().orElse(null);
    }
}
