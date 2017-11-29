package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int count = 0;
        for (Entry<K, List<V>> qwe : map.entrySet()) {
            for (V asd : qwe.getValue()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public V put(K key, V value) {
        List<V> list = map.get(key);
        if (list == null) {
            List<V> list1 = new ArrayList<>();
            list1.add(value);
            map.put(key, list1);
            return null;
        }
        //if (list.size() == 0) return null;
        if (list.size() < repeatCount) {
            list.add(list.size(), value);
        } else if (list.size() == repeatCount) {
            list.remove(0);
            list.add(repeatCount - 1, value);
        }
        map.put(key, list);
        return map.get(key).get(list.size() - 2);
    }

    @Override
    public V remove(Object key) {
        for (Entry<K, List<V>> qew : map.entrySet()) {
            if (qew.getKey().equals(key)) {
                if (qew.getValue().size() == 0) {
                    map.remove(key);
                    break;
                }
                V qwe = qew.getValue().remove(0);
                if (qew.getValue().size() == 0) map.remove(key);
                return qwe;
            }
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Entry<K, List<V>> qew : map.entrySet()) {
            set.add(qew.getKey());
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        List<V> list = new ArrayList<>();
        for (Entry<K, List<V>> qwe : map.entrySet()) {
            list.addAll(qwe.getValue());
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry<K, List<V>> qwe : map.entrySet()) {
            for (V asd : qwe.getValue()) {
                if (asd.equals(value)) return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }

}