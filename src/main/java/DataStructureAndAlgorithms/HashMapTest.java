package DataStructureAndAlgorithms;

import org.junit.Test;

public class HashMapTest {
    @Test
    public void test(){
        int MAXIMUM_CAPACITY = 1 << 30;
        int cap = 6;
        int n = cap - 1;

        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println((n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1);

    }
}
