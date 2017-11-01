package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>((int)Math.max(16,Math.ceil(collection.size()/.75f)));
        addAll(collection);
    }


    public Object clone() throws CloneNotSupportedException {
        try {
            AmigoSet amigoSet = new AmigoSet();
            amigoSet.addAll(this);
            amigoSet.map.putAll((Map) this.map.clone());
            return amigoSet;
        }catch (Exception e){
            throw new InternalError();
        }
    }



    public boolean add(E o) {
        return map.put(o,PRESENT)==null;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)!=null;
    }

    public static void main(String[] args) {
        Set<String> s = new TreeSet<String>();
        s.add("asd");
        s.add("asd1");
        s.add("asd2");

        AmigoSet c = new AmigoSet(s);
        System.out.println(c);
    }
}
