## How it work
- The first, we define an Annotation named [YMLNaming](src/main/java/com/huantt/annotationexample/annotation/json/YMLNaming.java) with a method called `value()`
```java
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
    public @interface YMLNaming {
    
        String value();
    }

```
 >- @Retention(RetentionPolicy.RUNTIME) means this Annotation can be read at RUNTIME. 
 (*[Read more about other RetentionPolicy values](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/annotation/RetentionPolicy.html)*)
 >- @Target({ ElementType.FIELD, ElementType.TYPE}) means this Annotation can be used with field/class/interface. (*[Read more about other ElementType values](https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/ElementType.html)*) 
- Then we use this Annotation in [Product](src/main/java/com/huantt/annotationexample/model/Product.java) for some fields.
```java
    public class Product {
    
        public Product(String skuCode, Double price) {
            this.skuCode = skuCode;
            this.price = price;
        }
    
        @YMLNaming("sku")
        private String skuCode;
        private Double price;
    
    }
``` 
- Now we can read Annotation's value anywhere via Java Reflection (*[Read more about Java Reflection](http://tutorials.jenkov.com/java-reflection/annotations.html)*)
```java
    Class<?> clazz = object.getClass();
    Field[] fields = clazz.getDeclaredFields();
    for (int i = 0; i < fields.length; i++) {
        YMLNaming YMLNamingAnnotation = fields[i].getDeclaredAnnotation(YMLNaming.class);
        String annotationValue = Optional.ofNullable(YMLNamingAnnotation).map(YMLNaming::value);
    }
```

## Conclusions:
- Annotations, a form of metadata, provide data about a program. 
- Annotations have no direct effect on the operation of the code they annotate.
- We can read annotation's values (returning value of methods) via Java Reflection