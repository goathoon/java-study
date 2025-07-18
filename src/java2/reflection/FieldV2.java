package java2.reflection;

import java2.reflection.data.User;

import java.lang.reflect.Field;

public class FieldV2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("id1", "UserA", 20);
        System.out.println("user.getName() = " + user.getName());

        Class<? extends User> aClass = user.getClass();
        Field nameField = aClass.getDeclaredField("name");

        // private 필드에 접근 허용, private 메서드도 이렇게 호출 가능
        nameField.setAccessible(true);
        nameField.set(user, "UserB");
        System.out.println("변경된 이름 = " + user.getName() );

    }
}
