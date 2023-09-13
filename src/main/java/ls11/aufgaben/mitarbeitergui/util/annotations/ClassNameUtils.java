package ls11.aufgaben.mitarbeitergui.util.annotations;

import java.util.Arrays;

public class ClassNameUtils {
    public static String getClassNameOnly(Class<?> clazz) {
        if (clazz == null) return "";
        String className = Arrays.stream(clazz.getAnnotations()).filter(a -> a instanceof ClassName).map(a -> ((ClassName) a).name()).findFirst().orElse(null);
        if (className == null || className.isEmpty())
            className = clazz.getName().substring(clazz.getName().lastIndexOf(".") + 1);
        return className;

    }

}
