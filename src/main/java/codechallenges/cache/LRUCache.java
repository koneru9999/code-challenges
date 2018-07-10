package codechallenges.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * @author Venkaiah Chowdary Koneru
 */
public class LRUCache {
    private Entry<Integer, String> start, end;
    private Map<Integer, Entry<Integer, String>> storage;
    private int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.storage = new HashMap<>();
    }

    public void put(Integer key, String value) {
        if (storage.containsKey(key)) {
            Entry<Integer, String> ret = storage.get(key);
            ret.setValue(value);
            removeNode(ret);
            addToTop(ret);
        } else {
            Entry<Integer, String> entry = new Entry<>();
            entry.setKey(key);
            entry.setValue(value);
            if (storage.size() >= cacheSize) {
                storage.remove(end.getKey());
                removeNode(end);
            }
            addToTop(entry);
            storage.put(key, entry);
        }
    }

    private void removeNode(Entry<Integer, String> node) {
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            start = node.getNext();
        }

        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            end = node.getPrev();
        }
    }

    private void addToTop(Entry<Integer, String> node) {
        node.setNext(start);
        node.setPrev(null);

        if (start != null) {
            start.setPrev(node);
        }
        start = node;
        if (end == null) {
            end = start;
        }
    }

    public String get(Integer key) {
        if (storage.containsKey(key)) {
            Entry<Integer, String> ret = storage.get(key);
            removeNode(ret);
            addToTop(ret);
            return ret.getValue();
        }

        return null;
    }

    public class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> prev;
        private Entry<K, V> next;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getPrev() {
            return prev;
        }

        public void setPrev(Entry<K, V> prev) {
            this.prev = prev;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}
