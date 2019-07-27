package DataStructureAndAlgorithms;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU最近最少使用
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int maxEntries;

    public LRUCache(int maxEntries) {
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxEntries;
    }

    public static void main(String[] args) {
        LRUCache<String,Object> cache = new LRUCache<>(3);
        cache.put("a","abstract");
        cache.put("b","basic");
        cache.put("c","call");
        cache.get("a");
        cache.put("d","滴滴滴");
        System.out.println(cache); // 输出为：{c=call, a=abstract, d=滴滴滴}

    }

}

