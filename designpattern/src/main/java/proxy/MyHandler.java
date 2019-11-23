package proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Mabel
 */
public class MyHandler implements InvocationHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyHandler.class);

    private Object targetObject;

    public Object getTargetObject(Object proxy) {
        try {
            return proxy.getClass().newInstance();
        } catch (InstantiationException e) {
            LOGGER.error("", e);
        } catch (IllegalAccessException e) {
            LOGGER.error("", e);
        }
        return null;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        targetObject = this.getTargetObject(proxy);
        method.invoke(targetObject, args);
        return null;
    }
}

