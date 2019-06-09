package com.huantt.annotationexample.annotation.json;

import java.lang.reflect.Field;
import java.util.Optional;

/**
 * @author huantt on 2019-06-08
 */
public class YMLWriter {

    public static String writeAsString(Object object) throws IllegalAccessException {
        if (object == null) return null;
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder YMLOutput = new StringBuilder();

        for (int i = 0; i < fields.length; i++) {
            // Allow accessing to private field
            fields[i].setAccessible(true);
            // Get Annotation to get value of the used annotation
            YMLNaming YMLNamingAnnotation = fields[i].getDeclaredAnnotation(YMLNaming.class);
            // Get Annotation's value or field name if Annotation's value is null
            YMLOutput.append(Optional.ofNullable(YMLNamingAnnotation)
                    .map(YMLNaming::value)
                    .orElse(fields[i].getName()));
            YMLOutput
                    .append(":\t")
                    .append(fields[i].get(object));
            if (i < fields.length - 1)
                YMLOutput.append("\n");
        }

        return YMLOutput.toString();
    }
}
