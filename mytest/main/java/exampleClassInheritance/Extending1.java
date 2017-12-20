package exampleClassInheritance;

public class Extending1 {

    int a = 10;
    int b = 10;
    int c = 10;

    static void methodStatic(){
        System.out.println("A static");
    }

    void method() {
        System.out.println("A common");
    }

    void methodFieldA(){
        System.out.println("A fieldA = " + a);
    }

    void methodFieldB(){
        System.out.println("A fieldB = " + b);
    }

    void methodFieldC(){
        System.out.println("A fieldC = " + c);
    }

}
