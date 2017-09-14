package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by alexa on 06.09.2017.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()) return true;
        else {
            if (pathname.getName().toLowerCase().endsWith(".html") || pathname.getName().toLowerCase().endsWith(".htm"))
                return true;
        }
        return false;
    }

    public String getDescription(){
        return "HTML и HTM файлы";
    }
}
