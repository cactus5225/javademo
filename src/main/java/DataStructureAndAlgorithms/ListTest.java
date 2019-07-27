package DataStructureAndAlgorithms;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class ListTest {
    @Test
    public void testLinkedHashMap() {
//        Map<String, Integer> seqMap = new LinkedHashMap<>();
//        seqMap.put("c", 100);
//        seqMap.put("d", 200);
//        seqMap.put("a", 500);
//        seqMap.put("d", 300);
//        for (Map.Entry<String, Integer> entry : seqMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

        //accessOrder为true的排序规则为最后被访问的放在最前面
        Map<String, Integer> accessMap = new LinkedHashMap<>(16,0.75f,true);
        accessMap.put("c",100);
        accessMap.put("d",200);
        accessMap.put("a",500);
        accessMap.get("c");
        accessMap.put("d",300);
        accessMap.get("a");
        for(Map.Entry<String,Integer> entry:accessMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
