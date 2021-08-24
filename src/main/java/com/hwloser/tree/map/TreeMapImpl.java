package com.hwloser.tree.map;

import java.util.*;

public class TreeMapImpl<K, V>
    extends AbstractMap<K, V>
    implements NavigableMap<K, V>, Cloneable, java.io.Serializable {

    // inner reference
    private Comparator<? super K> comparator;
    private transient Entry<K, V> root;
    private transient int size = 0;
    private transient int modCount = 0;

    // inner mechanics
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    @Override
    public V put(K key, V value) {
        Entry<K, V> t = this.root;
        if (Objects.isNull(t)) {
            compare(key, key); // 输入为空检查

            root = new Entry<>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }

        int cmp;
        Entry<K, V> parent;
        // split comparator and comparable paths
        Comparator<? super K> cpr = this.comparator;
        if (Objects.nonNull(cpr)) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);

                if (cmp < 0) {
                    t = t.left;
                } else if (cmp > 0) {
                    t = t.right;
                } else {
                    return t.setValue(value);
                }

            } while (Objects.nonNull(t));
        } else {
            if (Objects.isNull(key)) throw new NullPointerException();
            @SuppressWarnings("unchecked")
            Comparable<? super K> k = (Comparable<? super K>) key;

            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (Objects.nonNull(t));
        }
        Entry<K, V> e = new Entry<>(key, value, parent);
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;


        return super.put(key, value);
    }

    // abstract Map
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    // NavigableMap
    @Override
    public Comparator<? super K> comparator() {
        return null;
    }
    @Override
    public Entry<K, V> lowerEntry(K key) {
        return null;
    }
    @Override
    public K lowerKey(K key) {
        return null;
    }
    @Override
    public Entry<K, V> floorEntry(K key) {
        return null;
    }
    @Override
    public K floorKey(K key) {
        return null;
    }
    @Override
    public Entry<K, V> ceilingEntry(K key) {
        return null;
    }
    @Override
    public K ceilingKey(K key) {
        return null;
    }
    @Override
    public Entry<K, V> higherEntry(K key) {
        return null;
    }
    @Override
    public K higherKey(K key) {
        return null;
    }
    @Override
    public Entry<K, V> firstEntry() {
        return null;
    }
    @Override
    public Entry<K, V> lastEntry() {
        return null;
    }
    @Override
    public Entry<K, V> pollFirstEntry() {
        return null;
    }
    @Override
    public Entry<K, V> pollLastEntry() {
        return null;
    }
    @Override
    public NavigableMap<K, V> descendingMap() {
        return null;
    }
    @Override
    public NavigableSet<K> navigableKeySet() {
        return null;
    }
    @Override
    public NavigableSet<K> descendingKeySet() {
        return null;
    }
    @Override
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        return null;
    }
    @Override
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        return null;
    }
    @Override
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        return null;
    }
    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return null;
    }
    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return null;
    }
    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return null;
    }
    @Override
    public K firstKey() {
        return null;
    }
    @Override
    public K lastKey() {
        return null;
    }

    static final class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        boolean color = BLACK;

        Entry<K, V> left;
        Entry<K, V> right;
        Entry<K, V> parent;

        Entry(K key, V value, Entry<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        @Override
        public K getKey() {
            return key;
        }
        @Override
        public V getValue() {
            return value;
        }
        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) return false;
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            return valEquals(key, e.getKey()) && valEquals(value, e.getValue());
        }
        @Override
        public int hashCode() {
            int keyHash = (key == null ? 0 : key.hashCode());
            int valueHash = (value == null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }
        @Override
        public String toString() {
            return key + "=" + value;
        }
    }


    // private function for util
    @SuppressWarnings("unchecked")
    final int compare(Object k1, Object k2) {
        return comparator == null ?
            ((Comparable<? super K>) k1).compareTo((K) k2) :
            comparator.compare((K) k1, (K) k2);
    }
    static final boolean valEquals(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

//    private void fixAfterInsertion(Entry<K, V> x) {
//        x.color = RED;
//
//        while (x != null && x != root && x.parent.color == RED) {
//            if (parentOf(x) == )
//        }
//    }
    private static <K, V> Entry<K, V> parentOf(Entry<K, V> p) {
        return (p == null ? null : p.parent);
    }
    private static <K, V> Entry<K, V> leftOf(Entry<K, V> p) {
        return (p == null ? null : p.left);
    }
    private static <K, V> Entry<K, V> rightOf(Entry<K, V> p) {
        return (p == null ? null : p.right);
    }
}
