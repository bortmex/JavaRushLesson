package com.javarush.task.task21.task2109;

/**
 * Created by alexa on 14.07.2017.
 */
public class ABC<A1,A2,B1,B2,C1,C2>{
    private A1 a1;
    private A2 a2;
    private B1 b1;
    private B2 b2;
    private C1 c1;
    private C2 c2;
    public ABC(A1 a1, A2 a2, B1 b1, B2 b2, C1 c1, C2 c2) {
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b1;
        this.b2 = b2;
        this.c1 = c1;
        this.c2 = c2;
    }
    public void printLn() {
        System.out.println(String.format("%s | %-28.28s | %s"," type",String.format("%16s","value"),String.format("%16s","clone")));
        System.out.println("----------------------------------------------------------------------");
        System.out.println(String.format(" A | %-28.28s | %s",String.format("%19s",a1),String.format("%19s",a2)));
        System.out.println(" B | " + b1 + " | " + b2);
        System.out.println(" C | " + c1 + " | " + c2);
    }
}