package java2.reflection;

import java2.reflection.data.BasicData;

import java.lang.reflect.Method;

public class MethodV1 {
    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;

        System.out.println("===== methods() =====");
        // 상속 받은 메서드 포함 모든 public 메서드들
        Method[] methods = helloClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        System.out.println("===== declaredMethods() =====");
        // 내가 선언한 모든 메서드
        Method[] declaredMethods = helloClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("declaredMethod = " + method);
        }

    }
}
