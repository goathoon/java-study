package java2.reflection;

import java2.reflection.data.BasicData;

public class BasicV1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 클래스 메타데이터 조회 방법 세가지

        // 1. 클래스에서 찾기
        Class<BasicData> basicDataClass1 = BasicData.class;
        System.out.println("basicDataClass1 = " + basicDataClass1);

        // 2. 인스턴스에서 찾기
        BasicData basicInstance = new BasicData();
        Class<? extends BasicData> basicDataClass2 = basicInstance.getClass();
        System.out.println("basicDataClass2 = " + basicDataClass2);

        // 3. 문자로 찾기
        String className = "java2.reflection.data.BasicData"; // 패키지명 주의
        Class<?> baiscData3 = Class.forName(className);
        System.out.println("baiscData3 = " + baiscData3);



    }
}
