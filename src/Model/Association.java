package Model;

import java.util.Map;

public class Association<K, V> implements Map.Entry<K, V> {

    private final K key;
    private V value;

    public Association(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key unrecognized");
        }
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
