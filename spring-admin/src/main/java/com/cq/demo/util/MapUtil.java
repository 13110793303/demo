package com.cq.demo.util;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.Map;

/**
 * @Author: ChengYangChang
 */
public class MapUtil {

    public static boolean mapIsNull(Map<String, Object> map) {
        return null == map || map.isEmpty();
    }

    public static boolean mapIsNotNull(Map<String, Object> map) {
        return !mapIsNull(map);
    }

    public static boolean mapIsNull(Map<String, Object> map, String key) {
        if (null == map || map.isEmpty()) {
            return true;
        }
        return StringUtil.isNull(map.get(key));
    }

    public static boolean mapIsNotNull(Map<String, Object> map, String key) {
        return !mapIsNull(map, key);
    }

    public static boolean mapIsNull(Map<String, Object> map, String[] keyArray) {
        if (null == map || map.isEmpty()) {
            return true;
        }
        for (String key : keyArray) {
            if (StringUtil.isNull(map.get(key))) {
                return true;
            }
        }
        return false;
    }

    public static boolean mapIsNotNull(Map<String, Object> map, String[] keyArray) {
        return !mapIsNull(map, keyArray);
    }

    /**
     * Map转Bean
     */
    public static <T> T map2Object(Map<String, Object> map, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        if (map == null) {
            return null;
        }
        T obj = clazz.newInstance();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }
            field.setAccessible(true);
            String filedTypeName = field.getType().getName();
            if (filedTypeName.equalsIgnoreCase("java.util.date")) {
                String datetimestamp = String.valueOf(map.get(field.getName()));
                if (datetimestamp.equalsIgnoreCase("null")) {
                    field.set(obj, null);
                } else {
                    field.set(obj, new Date(Long.parseLong(datetimestamp)));
                }
            } else {
                field.set(obj, map.get(field.getName()));
            }
        }
        return obj;
    }

}
