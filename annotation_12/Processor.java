package annotation_12;

import java.lang.reflect.Method;

public class Processor {
    public static void processAnnotation(Object target) {
        Class<?> clazz = target.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            GetMapping getMapping = method.getAnnotation(GetMapping.class);
            PostMapping postMapping = method.getAnnotation(PostMapping.class);
            if (getMapping != null) {
                System.out.println("Do something here - GetMapping: " + method.getName());
            }

            if (postMapping != null) {
                System.out.println("Do something here - PostMapping: Method:" + method.getName() + " Value: " + postMapping.value());
            }
        }
    }
}
