package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T>{
    @Override
    public Iterator<T> iterator() {
        return  new RoundIterator();
    }

    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class RoundIterator implements Iterator<T> {
        Iterator<T> iterable = Solution.super.iterator();
        int count = 0;
        @Override
        public boolean hasNext() {
            if(size()==0){
                return false;
            }

            if (count >= size()) {
                iterable = Solution.super.iterator();
                count=0;
            }

            return true;
        }

        @Override
        public T next() {
            count++;
            return iterable.next();
        }

        @Override
        public void remove() {
            iterable.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            throw new ConcurrentModificationException();
        }
    }

}
