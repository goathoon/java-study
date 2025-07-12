package java2.reflection;

import java2.reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodV2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // 정적 메서드 호출 - 일반적인 메서드 호출
        BasicData helloInstance = new BasicData();
        helloInstance.call(); // 이 부분은 코드를 변경하지 않는 이상 정적이다.

        // 동적 메서드 호출 - 리플렉션 사용
        Class<? extends BasicData> helloClass = helloInstance.getClass();
        String methodName = "hello";

        // 메서드 이름을 변수로 변경할 수 있다
        Method method1 = helloClass.getDeclaredMethod(methodName, String.class);
        // 껍데기의 메서드정보로, 어떤 인스턴스에 포함된 메서드를 호출할 건지 지정해야 한다.
        Object returnValue = method1.invoke(helloInstance, "hi");
        System.out.println("returnValue = " + returnValue);

    }
}
