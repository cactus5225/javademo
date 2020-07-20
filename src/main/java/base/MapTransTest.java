package base;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTransTest {


    @Test
    public void test(){
        String test = null;


    }

    @Test
    public void test1(){
        String params = "{\"withdraw_id\":1001947}";
        Map<String, Object> map = JSON.parseObject(params);
        Object withdrawIdObj = map.get("withdraw_id");
        System.out.println(Long.parseLong(withdrawIdObj.toString()));

        String test = null;

        map.put("tag",test);
        Map<String,Object> map1 = new HashMap<>();
        map1.put("tag", map.get("tag"));

        System.out.println(map1.get("tag")==null);




    }

}
