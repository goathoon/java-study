package java3.lambda.ex1;

public class M2After {

    public static void printKg(int kg) {
        System.out.printf("무게: %dkg\n", kg);
    }

    public static void printG(int g) {
        System.out.printf("무게: %dg\n", g);
    }
    public static void main(String[] args) {
        printKg(10);
        printKg(50);
        printG(200);
        printG(40);
    }
}