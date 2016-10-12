package com.demo.wkts.regression;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class DTO {

    private String regionName;

    public void setRegionCode(String regionCode) {
        System.out.println("SETTER IS CALLED");
    }

    public String getRegionName() {
        return regionName;
    }
}

class TypeTranslator {

    @SuppressWarnings("unchecked")
    public static <T> T translateValue(String value, Class<T> type) {
        if (value != null && !value.isEmpty()) {
            if (type == String.class) {
                return (T) value;
            } else if (type == Integer.class || type == int.class) {
                return (T) Integer.valueOf(value);
            } else if (type == Float.class || type == float.class) {
                return (T) Float.valueOf(value);
            } else if (type == Boolean.class || type == boolean.class) {
                Boolean result = false;
                if (value.equalsIgnoreCase("t") || value.equalsIgnoreCase("1") || value.equalsIgnoreCase("y") || value.equalsIgnoreCase("yes") || value.equalsIgnoreCase("true")) {
                    result = true;
                }
                return (T) result;
            } else if (type == Long.class || type == long.class) {
                return (T) Long.valueOf(value);
            }
        } else {
            if (type == String.class) {
                return (T) "";
            } else if (type == int.class || type == float.class || type == boolean.class || type == long.class) {
                return translateValue("0", type);
            } else if (type == Boolean.class) {
                return (T) new Boolean(false);
            }
        }
        return type.cast(value);
    }
}

public class RegressionDemo {

    private static void setPropertyValue(DTO dto, String fieldName, Object value) throws IllegalAccessException {
        try {
            String toCallSetter = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method[] declaredMethods = dto.getClass().getDeclaredMethods();

            for (Method declaredMethod : declaredMethods) {
                if (declaredMethod.getName().equals(toCallSetter)) {
                    declaredMethod.invoke(dto, value);
                }
            }

        } catch (Exception e) {
            // if fails set to field
            try {
                setFieldValue(dto, fieldName, value);
            } catch (Exception eInner) {
                throw new RuntimeException(String.format("FAILED TO MAP CALL SETTER FOR "));
            }
        }
    }

    private static void setFieldValue(DTO dto, String fieldName, Object value) throws IllegalAccessException {
        Field field = getField(fieldName, dto);

        if (value instanceof String) {
            Class<?> fieldType = field.getType();
            field.set(dto, TypeTranslator.translateValue((String) value, fieldType));
        } else {
            field.set(dto, value);
        }
    }

    private static Field getField(String fieldName, DTO dto) {

        Field field = null;
        Class<?> dtoClass = dto.getClass();
        while (field == null) {
            try {
                field = dtoClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException fieldExc) {
                dtoClass = dtoClass.getSuperclass();
            } catch (NullPointerException npeExc) {
                throw new NullPointerException(String.format("FAILED TO MAP FIELD %s WITH CLASS "));
            }
        }
        field.setAccessible(true);
        return field;
    }

    public static void main(String[] args) throws IllegalAccessException {
        DTO dto = new DTO();
        setPropertyValue(dto, "regionCode", "newValue");
    }
}
