package com.lch.route;

import java.lang.reflect.Method;

/**
 * Created by lichenghang on 2017/5/28.
 */

public class RouteManager {

    private static final String gDelegatorClassName = "com.lch.route.Route_";

    /**
     * @param cls
     * @param <T>
     * @return may return null,if cannot find service.
     */

    public static <T> T getService(Class<T> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("route service class is null.");
        }

        try {
            Class<?> delegCls = Class.forName(gDelegatorClassName);
            Method me = delegCls.getDeclaredMethod("getService", Class.class);
            me.setAccessible(true);
            return (T) me.invoke(null, cls);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


}
