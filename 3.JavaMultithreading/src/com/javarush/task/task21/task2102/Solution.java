package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {

        switch (specificModifier){
            case Modifier.ABSTRACT:
                return Modifier.isAbstract(allModifiers);
            case Modifier.FINAL:
                return Modifier.isFinal(allModifiers);
            case Modifier.PRIVATE:
                return Modifier.isPrivate(allModifiers);
            case Modifier.PUBLIC:
                return Modifier.isPublic(allModifiers);
            case Modifier.PROTECTED:
                return Modifier.isProtected(allModifiers);
            case Modifier.STATIC:
                return Modifier.isStatic(allModifiers);
            case Modifier.NATIVE:
                return Modifier.isNative(allModifiers);
        }
        return false;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
