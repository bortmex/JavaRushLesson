package com.javarush.task.task36.task3606;

/*
Осваиваем ClassLoader и Reflection
*/

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File[] files = new File(packageName).listFiles();
        ClassLoaderFromPath classLoader = new ClassLoaderFromPath();

        for (File f : files) {
            Class<?> clazz = classLoader.load(f.toPath());
            if (clazz != null)
                hiddenClasses.add(clazz);
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class<?> clazz : hiddenClasses) {
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor[] constructors = clazz.getDeclaredConstructors();
                    for (Constructor constructor : constructors) {
                        if (constructor.getParameterTypes().length == 0) {
                            constructor.setAccessible(true);
                            return (HiddenClass) constructor.newInstance(null);
                        }
                    }
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }


    public static class ClassLoaderFromPath extends ClassLoader {
        public Class<?> load(Path path) {
            try {
                if (path.getFileName().toString().lastIndexOf(".class") == -1)
                    return null;

                byte[] b = Files.readAllBytes(path);
                return defineClass(null, b, 0, b.length); //here main magic
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}

/* мое решение
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() {
//packageName = packageName.replaceAll("/",".").substring(packageName.replaceAll("/",".").lastIndexOf("com"),packageName.replaceAll("/",".").length());
        File file = new File(packageName);
        File[] files = file.listFiles();
        ClassLoader myClassLoader = ClassLoader.getSystemClassLoader();
        for (int i = 0; i < files.length; i++) {
            if(files[i].getAbsolutePath().lastIndexOf(".class") == -1) continue;
            String testing = files[i].getAbsolutePath().replaceAll("\\\\", ".");
            String test = testing.substring(testing.lastIndexOf("com"), testing.length()).replaceAll(".class", "");//.replaceAll("/",".").substring(packageName.replaceAll("/",".").lastIndexOf("test"),packageName.replaceAll("/",".").length());
*/
/*hiddenClasses.add(Class.forName()*//*

//hiddenClasses.add((Class) Class.forName(test).newInstance());
            try {
                hiddenClasses.add(myClassLoader.loadClass(test));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class cl : hiddenClasses) {
            if (cl.getSimpleName().toLowerCase().startsWith(key.toLowerCase()))

                try {
                    Constructor[] constructor = cl.getDeclaredConstructors();
                    for (Constructor constructor1 : constructor) {
                        if (constructor1.getParameterTypes().length == 0) {
                            constructor1.setAccessible(true);
                            return (HiddenClass) constructor1.newInstance(null);
                        }
                    }
                    return (HiddenClass) cl.newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }
}*/
