package org.pc.custom.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Optional;

public class LoggingProxy implements InvocationHandler {
    private final Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), // proxy works only interfaces
                new LoggingProxy(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        Object result = Optional.empty();
        if (targetMethod.isAnnotationPresent(LogExecution.class)) {

            LogExecution annotation = targetMethod.getAnnotation(LogExecution.class);
            String label = annotation.value().isBlank() ? method.getName() : annotation.value();

            try {
                long start = System.currentTimeMillis();
                System.out.println("▶ Starting: " + label);

                result = method.invoke(target, args);
                long time = System.currentTimeMillis() - start;

                System.out.println("✔ Completed: " + label + " in " + time + " ms");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                System.out.println("❌ Exception in method: " + method.getName());
                throw e.getCause(); // Unwrap original exception
            }

        }
        return result;
    }
}
