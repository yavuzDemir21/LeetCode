package Playground;

public class Method_Overloading {
    public static void main(String[] args) {
        Interest_rate(3,3,3f);
        Interest_rate(3f,3,3f);
        Interest_rate(3,3,3.0);
    }

    public static void Interest_rate(int s, int a, float d){
        System.out.println("Method 1 --> int int float");
    }

    public static void Interest_rate(float s, int a, float d){
        System.out.println("Method 2 --> float int float");
    }

    public static void Interest_rate(int s, int a, double d){
        System.out.println("Method 3 --> int int double");
    }
}
