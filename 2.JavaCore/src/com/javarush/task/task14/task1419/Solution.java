package com.javarush.task.task14.task1419;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;
import sun.security.util.PendingException;

import javax.transaction.TransactionRequiredException;
import java.nio.BufferOverflowException;
import java.nio.channels.AcceptPendingException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.security.KeyStoreException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        exceptions.add(new AlreadyBoundException());
        exceptions.add(new BufferOverflowException());
        exceptions.add(new ArrayStoreException());
        exceptions.add(new AcceptPendingException());
        exceptions.add(new TransactionRequiredException());
        exceptions.add(new NotBoundException());
        exceptions.add(new PendingException());
        exceptions.add(new KeyStoreException());
        exceptions.add(new DuplicateName());

    }
}
