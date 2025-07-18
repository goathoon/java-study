package java2.annotation.basic;

import java.util.Arrays;

public class ElementData1Main {

    public static void main(String[] args) {
        Class<ElementData1> elementData1Class = ElementData1.class;
        AnnoElement annotation = elementData1Class.getAnnotation(AnnoElement.class);

        String value = annotation.value();
        System.out.println("value = " + value);

        int count = annotation.count();
        System.out.println("count = " + count);

        String[] tags = annotation.tags();
        System.out.println("tags = " + Arrays.toString(tags)  );
    }
}
