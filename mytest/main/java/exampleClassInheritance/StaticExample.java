package exampleClassInheritance;

public class StaticExample {
    static StaticExample staticExample = new StaticExample();
    static int i = 4;
    static  int j = returnStaticInt();

    static int k = 3;
    int l = returnInt();
    static {
        System.out.println("static");
    }

    {
        System.out.println("clean");
    }

    static int returnStaticInt(){
        System.out.println(i);
        System.out.println(k);
        System.out.println("return static int");
        return 1;
    }
    int returnInt(){
        System.out.println("return int");
        return 2;
    }

    public StaticExample() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        new StaticExample();
    }

}
