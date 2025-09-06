package java3.lambda.lambda5.mystream;

import java3.lambda.lambda5.filter.GenericFilter;
import java3.lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex2_Student {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 70),
                new Student("Berry", 80),
                new Student("Tomato", 40)
        );

        List<String> directResult = direct(students);
        System.out.println("directResult = " + directResult);

        List<String> lambdaResult = lambda(students);
        System.out.println("lambdaResult = " + lambdaResult);
    }

    private static List<String> lambda(List<Student> students) {
        return GenericMapper.map(
                GenericFilter.filter(students,
                        student -> student.getScore() >= 80),
                Student::getName
        );
    }

    private static List<String> direct(List<Student> students) {
        List<String> list = new ArrayList<>();
        for (Student student : students) {
            if(student.getScore() >= 80) {
                list.add(student.getName());
            }
        }
        return list;
    }
}
