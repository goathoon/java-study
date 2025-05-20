package java2.io.member;

import java.io.Serializable;

public class Member implements  Serializable {
    private String id;
    private String name;
    private Integer age;

    public Member() {
    }

    public Member(String id, String name, Integer age) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member{" +
                "age=" + age +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
