package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/**
 * Created by rogov on 18.09.2017.
 */

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root = new Entry<>("0");

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
//System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        System.out.println(list.size());
        list.remove("15");
        System.out.println(list.size());
list.add(String.valueOf(17));
//list.add("18");
//System.out.println(((CustomTree)list).getParent("129"));
//System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));

 /*       Map<String, Integer> list = new TreeMap<>();
        list.put("g",1);
        list.put("qwed",1);
        list.put("abd1",1);
        list.put("abd33",1);

        list.size();
        for (Map.Entry er: list.entrySet()) {
            System.out.println("map: first - > " + er.getKey());
            System.out.println("map: second - > " + er.getValue());
            System.out.println();
        }
        System.out.println(list.size());*/

    }

    static class Entry<T> implements Serializable, Comparable<Entry> {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry() {
        }

        Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (this.leftChild != null) this.availableToAddLeftChildren = false;
            if (this.rightChild != null) this.availableToAddRightChildren = false;
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public int compareTo(Entry o) {
            return new Integer(Integer.parseInt(this.elementName)).compareTo(Integer.parseInt(o.elementName));
        }
    }

    @Override
    public boolean add(String s) {
        if (root == null) {
            root = new Entry<>(s);
            return false;
        }
        Queue<Entry<String>> treeEntry = new LinkedList<>();
        Entry<String> localEntry =null;
        treeEntry.offer(root);
        while (!treeEntry.isEmpty()) {
            localEntry = treeEntry.poll();
            if (localEntry.isAvailableToAddChildren()) {
                if (localEntry.availableToAddLeftChildren) {
                    localEntry.leftChild = new Entry<>(s);
                    localEntry.leftChild.parent = localEntry;
                    localEntry.checkChildren();
                    localEntry.leftChild.checkChildren();
                    return true;
                } else {
                    localEntry.rightChild = new Entry<>(s);
                    localEntry.rightChild.parent = localEntry;
                    localEntry.checkChildren();
                    localEntry.rightChild.checkChildren();
                    return true;
                }
            } else {
                if(localEntry.leftChild.elementName!=null)
                    treeEntry.offer(localEntry.leftChild);
                if(localEntry.rightChild.elementName!=null)
                    treeEntry.offer(localEntry.rightChild);
            }

        }
        return false;
    }

    @Override
    public boolean remove(Object s1) {
        String s = (String) s1;
        if (s1==null) return false;
        Queue<Entry<String>> treeEntry = new LinkedList<>();
        Entry<String> entryLocal = null;
        treeEntry.offer(root);
        while (!treeEntry.isEmpty()) {
            entryLocal = treeEntry.poll();
            if (entryLocal.elementName.equals(s)) {
                treeEntry.clear();
                treeEntry.offer(entryLocal);
                while (!treeEntry.isEmpty()) {
                    entryLocal = treeEntry.poll();
                    if (entryLocal.leftChild != null) {
                        treeEntry.offer(entryLocal.leftChild);
                    }
                    if (entryLocal.rightChild != null) {
                        treeEntry.offer(entryLocal.rightChild);
                    }
                    entryLocal.leftChild = null;
                    entryLocal.rightChild = null;
                    entryLocal.parent = null;
                }
                return true;
            } else {
                if (entryLocal.leftChild != null)
                    treeEntry.offer(entryLocal.leftChild);
                if (entryLocal.rightChild != null)
                    treeEntry.offer(entryLocal.rightChild);
            }
        }
        return false;
    }

    public String getParent(String name){
        if (root == null || name == null)
            return null;
        if (name.equals(root.elementName))
            return null;
        Queue<Entry<String>> treeEntry = new LinkedList<>();
        Entry<String> entryLocal = null;
        treeEntry.offer(root);
        while (!treeEntry.isEmpty()){
            entryLocal = treeEntry.poll();
            if(entryLocal.elementName.equals(name))
                return entryLocal.parent.elementName;
            else {
                treeEntry.offer(entryLocal.leftChild);
                treeEntry.offer(entryLocal.rightChild);
            }
        }
        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        Queue<Entry<String>> treeEntry = new LinkedList<>();
        Entry<String> entryLocal = null;
        int size = 0;
        root.parent = new Entry<>("0");
        treeEntry.offer(root);
        while (!treeEntry.isEmpty()){
            entryLocal = treeEntry.poll();
            if (entryLocal.leftChild != null)
                treeEntry.offer(entryLocal.leftChild);
            if (entryLocal.rightChild != null)
                treeEntry.offer(entryLocal.rightChild);
            if(entryLocal.parent != null)
            size++;
        }
        return size-1;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
/*
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root = new Entry<>("0");
    private static TreeSet<Entry<String>> treeEntry = new TreeSet<>();
    private static TreeSet<Entry<String>> treeEntryForRemove = new TreeSet<>();
    private static int index = 0;
    private static int indexForRemove = 0;

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
//System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        //list.remove("3");
        */
/*list.add(String.valueOf(17));*//*

        System.out.println(list.size());
        list.remove("15");
        System.out.println(list.size());
        System.out.println(((CustomTree)list).getParent("129"));
//System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    static class Entry<T> implements Serializable, Comparable<Entry> {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry() {
        }

        Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (this.leftChild != null) this.availableToAddLeftChildren = false;
            if (this.rightChild != null) this.availableToAddRightChildren = false;
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(Integer.parseInt(this.elementName), Integer.parseInt(o.elementName));
        }
    }

    @Override
    public boolean add(String s) {
        while (true) {
            if (root.isAvailableToAddChildren()) {
                if (root.availableToAddLeftChildren) {
                    root.leftChild = new Entry<>(s);
                    root.leftChild.parent = root;
                    root.checkChildren();
                    root.leftChild.checkChildren();
                    treeEntry.add(root.leftChild);
                    return true;
                } else {
                    root.rightChild = new Entry<>(s);
                    root.rightChild.parent = root;
                    root.checkChildren();
                    root.rightChild.checkChildren();
                    treeEntry.add(root.rightChild);
                    return true;
                }
            } else {
                int localIndex = 0;
                Iterator<Entry<String>> iterator = treeEntry.iterator();
                while (localIndex!=index){
                    iterator.next();
                    localIndex++;
                }
                root = iterator.next();
                index++;
            }
        }
    }
    @Override
    public boolean remove(Object s1) {
        String s = (String) s1;
        if (root == null) {
            return false;
        }
        Iterator<Entry<String>> iterator = treeEntry.iterator();
        while (iterator.hasNext()){
            Entry<String> elem = iterator.next();
            if(elem.elementName.equals(s)){
                treeEntry.remove(elem);
                Entry<String> entry = elem.leftChild;
                while (true){
                    try {
                        if (!treeEntryForRemove.contains(entry)) {
                            treeEntryForRemove.add(entry);
                            entry = elem.rightChild;
                        } else {
                            int localIndex = 0;
                            Iterator<Entry<String>> iteratorForRemove = treeEntryForRemove.iterator();
                            while (localIndex != indexForRemove) {
                                iteratorForRemove.next();
                                localIndex++;
                            }
                            Entry<String> localEntry = iteratorForRemove.next();
                            ;
                            if (entry.equals(localEntry.leftChild))
                                entry = localEntry.rightChild;
                            else entry = localEntry.leftChild;
                            if (entry == null) break;
                            indexForRemove++;
                        }
                    }catch (NullPointerException e){
                        return true;
                    }
                }
                Iterator<Entry<String>> iteratorLocal = treeEntryForRemove.iterator();
                while (iteratorLocal.hasNext()){
                    treeEntry.remove(iteratorLocal.next());
                }
                treeEntryForRemove.clear();
                findFirstNullEntry();
                return true;
            }
        }
        findFirstNullEntry();
        return false;
    }

    public void findFirstNullEntry(){
        Iterator<Entry<String>> iterator = treeEntry.iterator();
        while (iterator.hasNext()){
            Entry<String> entry = iterator.next();
            if(entry.availableToAddLeftChildren||entry.availableToAddRightChildren){
                root = entry;
                break;
            }
        }
    }

    public String getParent(String name){
        Iterator<Entry<String>> iterator = treeEntry.iterator();
        while (iterator.hasNext()){
            Entry<String> entry = iterator.next();
            if(entry.elementName.equals(name)){
                return entry.parent.elementName;
            }
        }
        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return treeEntry.size();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}*/
