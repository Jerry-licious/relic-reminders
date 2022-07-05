package relicreminders.patches.pellets;

import java.lang.reflect.Field;

public class ReflectionHacks {
    public static Object getPrivateStatic(Class<?> cls, String name) {
        try {
            Field field = cls.getDeclaredField(name);
            field.setAccessible(true);
            return field.get(null);
        } catch (Exception _ignored) {
            return null;
        }
    }
}
