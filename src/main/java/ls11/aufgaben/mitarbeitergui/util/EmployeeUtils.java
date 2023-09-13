package ls11.aufgaben.mitarbeitergui.util;

import ls11.aufgaben.mitarbeitergui.util.employe.mitarbeiter_csv.employee.Employee;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class EmployeeUtils {
    private EmployeeUtils(){}

    public static Field[] getNonConstantEmployeeFields(Class<?> persistentClass) {
        return getNonConstantEmployeeFieldsRecursiv(persistentClass);
    }

    private static Field[] getNonConstantEmployeeFieldsRecursiv(Class<?> currentClass){
        //1. bin ich noch eine passende Klasse? Falls nein return
        if(! Employee.class.isAssignableFrom(currentClass)) return null;

        //2. Ich bin eine passende Klasse -> Felder der höheren Klassen holen, meine anhängen
        Class<?> parent = currentClass.getSuperclass();
        Field[] additionalFields = (parent == null) ? null : getNonConstantEmployeeFieldsRecursiv(parent);
        Field[] myFields = Arrays.stream(currentClass.getDeclaredFields()).filter(EmployeeUtils::isNotStaticFinal).toArray(Field[]::new);
        return concatenate(additionalFields, myFields);
    }

    private static <T> T[] concatenate(T[] a, T[] b) {
        if(a == null && b == null)return null;
        else if(a == null) return b;
        else if(b == null) return a;

        int aLen = a.length;
        int bLen = b.length;
        @SuppressWarnings("unchecked")
        T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    private static boolean isNotStaticFinal(Field field) {
        return !isStaticFinal(field);
    }

    private static boolean isStaticFinal(Field field) {
        int modifiers = field.getModifiers();
        return (Modifier.isStatic(modifiers) && Modifier
                .isFinal(modifiers));
    }
}
