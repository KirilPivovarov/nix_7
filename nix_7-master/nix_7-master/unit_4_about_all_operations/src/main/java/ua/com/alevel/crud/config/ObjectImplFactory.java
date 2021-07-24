package ua.com.alevel.crud.config;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ObjectImplFactory {

    private static ObjectImplFactory instance;
    private Reflections reflections;

    private ObjectImplFactory() {
        reflections = new Reflections("ua.com.alevel");
    }

    public static ObjectImplFactory getInstance() {
        if (instance == null) {
            instance = new ObjectImplFactory();
        }
        return instance;
    }

    public <S> S getImpl(Class<S> aClass) {
        Set<Class<? extends S>> objects = reflections.getSubTypesOf(aClass);
        for (Class<? extends S> object : objects) {
            if (!object.isAnnotationPresent(Deprecated.class)) {
                try {
                    return object.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new RuntimeException("idiot");
    }
}
