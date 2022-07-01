package com.ryan.datastructure.hash;

import java.util.TreeMap;

/**
 * @author ryanzou
 */
public class HashTable<K, V> {

    private TreeMap<K, V>[] hashTable;
    private int size;
    private int M;

    public HashTable(int M) {
        this.M = M;
        this.size = 0;
        hashTable = new TreeMap[M];
        for (int i=0; i< M; i++){
            hashTable[i] = new TreeMap<>();
        }
    }


    public HashTable() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    /**
     * 如果key存在则修改，否则新增
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        int index = hashKey(key);
        TreeMap<K, V> treeMap = hashTable[index];
        if (treeMap.containsKey(key)) {
            treeMap.put(key, value);
        } else {
            treeMap.put(key, value);
            size ++;
        }
    }

    private int hashKey(K key) {
        return key.hashCode()&0x7fffffff%M;
    }

    public V remove(K key) {
        int index = hashKey(key);
        TreeMap<K, V> treeMap = hashTable[index];
        if (treeMap.containsKey(key)) {
            V v= treeMap.remove(key);
            size --;
            return v;
        }
        return null;
    }

    public V get(K key) {
        return hashTable[hashKey(key)].get(key);
    }

}
