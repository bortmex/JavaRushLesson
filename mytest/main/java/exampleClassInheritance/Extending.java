package exampleClassInheritance;

public class Extending extends Extending1 {
    int a = 20;
    int c = 20;

    static void methodStatic(){
        System.out.println("B static");
    }

    void method() {
        System.out.println("B common");
    }

    void methodFieldA(){
        System.out.println("B fieldA = " + a);
    }

    void methodFieldB(){
        System.out.println("B fieldB = " + b);
    }

    public static void main(String[] args) {
        Extending1 e = new Extending();
        e.method();
        e.methodFieldA();
        e.methodFieldB();
        e.methodFieldC();
    }

}
